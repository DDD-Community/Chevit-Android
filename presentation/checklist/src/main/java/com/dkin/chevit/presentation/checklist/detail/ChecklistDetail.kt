package com.dkin.chevit.presentation.checklist.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
import com.dkin.chevit.presentation.checklist.detail.contents.ChecklistDetailMoreContents
import com.dkin.chevit.presentation.checklist.detail.contents.ChecklistDetailSortContents
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ChecklistDetail :
    MVIComposeFragment<ChecklistDetailIntent, ChecklistDetailState, ChecklistDetailEffect>() {
    override val viewModel: ChecklistDetailViewModel by viewModels()

    override fun processEffect(effect: ChecklistDetailEffect) {
        when (effect) {
            ChecklistDetailEffect.NavigateToAddItem -> {}
        }
    }

    override fun processState(state: ChecklistDetailState) {}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "detail") {
                    composable("detail") {
                        ChecklistDetailScreen(
                            viewModel = viewModel,
                            onClickBack = { findNavController().popBackStack() },
                            navigateAddItem = { navController.navigate("addItem") },
                            openSortSheet = { navController.navigate("sort") },
                            openMoreSheet = { itemId, title -> navController.navigate("more/${itemId}?title=${title}") }
                        )
                    }
                    composable("addItem") {
                        AddItemScreen()
                    }
                    composable("editItem/{itemId}") {
                        val itemId = it.arguments?.getString("itemId") ?: ""
                        EditItemScreen()
                    }
                    dialog(
                        route = "sort",
                        dialogProperties = DialogProperties(usePlatformDefaultWidth = false)
                    ) {
                        val sortType by viewModel.sortType.collectAsState()
                        ChecklistDetailSortContents(
                            selectedType = sortType,
                            onClickType = { type -> viewModel.sortItem(type) },
                            onClose = { navController.popBackStack() }
                        )
                    }
                    dialog(
                        route = "more/{itemId}?title={title}",
                        arguments = listOf(
                            navArgument("itemId") { type = NavType.StringType },
                            navArgument("title") { defaultValue = "" }
                        ),
                        dialogProperties = DialogProperties(usePlatformDefaultWidth = false)
                    ) {
                        val itemId = it.arguments?.getString("itemId") ?: ""
                        val title = it.arguments?.getString("title") ?: ""
                        ChecklistDetailMoreContents(
                            title = title,
                            navigateEditItem = { navController.navigate("editItem") },
                            deleteItem = { viewModel.removeItem(itemId) },
                            onClose = { navController.popBackStack() }
                        )
                    }
                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val planId = arguments?.getString("planId")
        val categoryId = arguments?.getString("categoryId")
        planId?.let { plan -> categoryId?.let { viewModel.getChecklistDetail(plan, it) } }
    }
}