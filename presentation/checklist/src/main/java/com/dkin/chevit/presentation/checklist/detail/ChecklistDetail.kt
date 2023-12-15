package com.dkin.chevit.presentation.checklist.detail

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
import com.dkin.chevit.presentation.checklist.detail.contents.ChecklistDetailMoreContents
import com.dkin.chevit.presentation.checklist.detail.contents.ChecklistDetailSortContents
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ChecklistDetail :
    MVIComposeFragment<ChecklistDetailIntent, ChecklistDetailState, ChecklistDetailEffect>() {
    override val viewModel: ChecklistDetailViewModel by viewModels()

    override fun processEffect(effect: ChecklistDetailEffect) {
        when (effect) {
            ChecklistDetailEffect.GetChecklistFailed -> {
                Toast.makeText(requireContext(), "체크리스트 가져오기에 실패하였습니다.", Toast.LENGTH_SHORT).show()
            }

            ChecklistDetailEffect.AddItemFailed -> {
                Toast.makeText(requireContext(), "아이템 추가에 실패하였습니다.", Toast.LENGTH_SHORT).show()
            }

            ChecklistDetailEffect.CheckItemFailed -> {
                Toast.makeText(requireContext(), "아이템 체크에 실패하였습니다.", Toast.LENGTH_SHORT).show()
            }

            ChecklistDetailEffect.DeleteItemFailed -> {
                Toast.makeText(requireContext(), "아이템 삭제에 실패하였습니다.", Toast.LENGTH_SHORT).show()
            }

            ChecklistDetailEffect.EditItemFailed -> {
                Toast.makeText(requireContext(), "아이템 업데이트에 실패하였습니다.", Toast.LENGTH_SHORT).show()
            }
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
                            openMoreSheet = { itemId, title, memo, count ->
                                navController.navigate("more/${itemId}?title=${title}?memo=${memo}?count=${count}")
                            }
                        )
                    }
                    composable("addItem") {
                        AddItemScreen(
                            viewModel = viewModel,
                            onClickBack = { navController.popBackStack() },
                        )
                    }
                    composable(
                        route = "editItem/{itemId}?title={title}?memo={memo}?count={count}",
                        arguments = listOf(
                            navArgument("itemId") { type = NavType.StringType },
                            navArgument("title") { type = NavType.StringType; defaultValue = "" },
                            navArgument("memo") { type = NavType.StringType; defaultValue = "" },
                            navArgument("count") { type = NavType.IntType; defaultValue = 1 },
                        ),
                    ) {
                        val itemId = it.arguments?.getString("itemId") ?: ""
                        val title = it.arguments?.getString("title") ?: ""
                        val memo = it.arguments?.getString("memo") ?: ""
                        val count = it.arguments?.getInt("count") ?: 1
                        EditItemScreen(
                            viewModel = viewModel,
                            onClickBack = { navController.popBackStack() },
                            itemId = itemId,
                            savedTitle = title,
                            savedMemo = memo,
                            savedCount = count
                        )
                    }
                    dialog(
                        route = "sort",
                        dialogProperties = DialogProperties(usePlatformDefaultWidth = false)
                    ) {
                        val sortType by viewModel.sortType.collectAsState()
                        ChecklistDetailSortContents(
                            selectedType = sortType,
                            onClickType = { type ->
                                viewModel.dispatch(
                                    ChecklistDetailIntent.SortItem(
                                        type
                                    )
                                )
                                navController.popBackStack()
                            },
                            onClose = { navController.popBackStack() }
                        )
                    }
                    dialog(
                        route = "more/{itemId}?title={title}?memo={memo}?count={count}",
                        arguments = listOf(
                            navArgument("itemId") { type = NavType.StringType },
                            navArgument("title") { type = NavType.StringType; defaultValue = "" },
                            navArgument("memo") { type = NavType.StringType; defaultValue = "" },
                            navArgument("count") { type = NavType.IntType; defaultValue = 1 },
                        ),
                        dialogProperties = DialogProperties(usePlatformDefaultWidth = false)
                    ) {
                        val itemId = it.arguments?.getString("itemId") ?: ""
                        val title = it.arguments?.getString("title") ?: ""
                        val memo = it.arguments?.getString("memo") ?: ""
                        val count = it.arguments?.getInt("count") ?: 1
                        ChecklistDetailMoreContents(
                            title = title,
                            navigateEditItem = {
                                navController.navigate("editItem/${itemId}?title=${title}?memo=${memo}?count=${count}")
                            },
                            deleteItem = {
                                viewModel.dispatch(
                                    ChecklistDetailIntent.DeleteCheckItem(
                                        itemId
                                    )
                                )
                                navController.popBackStack()
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
        val planId = arguments?.getString("planId")
        val categoryId = arguments?.getString("categoryId")
        planId?.let { plan -> categoryId?.let { viewModel.getChecklistDetail(plan, it) } }
    }
}