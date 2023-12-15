package com.dkin.chevit.presentation.home.contents.user.mylist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.window.DialogProperties
import androidx.fragment.app.viewModels
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.dialog
import androidx.navigation.compose.rememberNavController
import androidx.navigation.findNavController
import androidx.navigation.navArgument
import com.dkin.chevit.core.mvi.MVIComposeFragment
import com.dkin.chevit.presentation.deeplink.DeepLink
import com.dkin.chevit.presentation.deeplink.deepLink
import com.dkin.chevit.presentation.home.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MyCheckList :
    MVIComposeFragment<MyCheckListIntent, MyCheckListState, MyCheckListEffect>() {
    override val viewModel: MyCheckListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "main") {
                    composable("main") {
                        val state by viewModel.state.collectAsState()
                        MyCheckListScreen(
                            onClickBack = { findNavController().popBackStack() },
                            checkList = state.checkList,
                            onClickChecklist = { id -> viewModel.onClickChecklist(id) },
                            onLongClickChecklist = { id, title -> navController.navigate("more/${id}?title=${title}") }
                        )
                    }
                    dialog(
                        route = "more/{itemId}?title={title}",
                        arguments = listOf(
                            navArgument("itemId") { type = NavType.StringType },
                            navArgument("title") { type = NavType.StringType; defaultValue = "" },
                        ),
                        dialogProperties = DialogProperties(usePlatformDefaultWidth = false),
                    ) {
                        val itemId = it.arguments?.getString("itemId") ?: ""
                        val title = it.arguments?.getString("title") ?: ""
                        ChecklistMoreBottomSheet(
                            title = title,
                            deleteItem = {
                                navController.popBackStack()
                                viewModel.dispatch(MyCheckListIntent.DeleteCheckList(itemId))
                            },
                            onClose = { navController.popBackStack() }
                        )
                    }
                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.initMyChecklist()
    }

    override fun processEffect(effect: MyCheckListEffect) {
        when (effect) {
            is MyCheckListEffect.NavigateToCheckList -> deepLink(DeepLink.CheckList(effect.id)) {
                popUpTo(
                    R.id.myChecklist
                )
            }

            MyCheckListEffect.DeletePlanFailed -> {
                Toast.makeText(requireContext(), "체크리스트 삭제에 실패하였습니다.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun processState(state: MyCheckListState) {}

}