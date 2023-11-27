package com.dkin.chevit.presentation.checklist.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
import com.dkin.chevit.presentation.checklist.R
import com.dkin.chevit.presentation.checklist.main.contents.FloatingContents
import com.dkin.chevit.presentation.checklist.main.contents.MoreCategoryBottomSheet
import com.dkin.chevit.presentation.checklist.main.contents.SaveTemplateContents
import com.dkin.chevit.presentation.deeplink.DeepLink
import com.dkin.chevit.presentation.deeplink.deepLink
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Checklist : MVIComposeFragment<ChecklistIntent, ChecklistState, ChecklistEffect>() {

    override val viewModel: ChecklistViewModel by viewModels()

    lateinit var planId: String

    override fun processEffect(effect: ChecklistEffect) {
        when (effect) {
            ChecklistEffect.NavigateToBringTemplate -> {}
            is ChecklistEffect.NavigateToLink -> {}
            is ChecklistEffect.NavigateToCategory -> {
                deepLink(
                    DeepLink.CheckListDetail(
                        planId = planId,
                        categoryId = effect.categoryId
                    )
                ) { popUpTo(R.id.checklist) }
            }
        }
    }

    override fun processState(state: ChecklistState) {}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "checklist") {
                    composable("checklist") {
                        ChecklistScreen(
                            viewModel = viewModel,
                            onClickBack = { findNavController().popBackStack() },
                            navigateAddCategory = {
                                deepLink(
                                    DeepLink.AddCategory(
                                        planId = planId,
                                    )
                                ) { popUpTo(R.id.checklist) }
                            },
                            openFloatingContents = { navController.navigate("floating") },
                            openCategoryMoreSheet = { id, title, type ->
                                navController.navigate("categoryMore/${id}?title=${title}?type=${type.name}")
                            }
                        )
                    }
                    dialog(
                        route = "saveTemplate",
                        dialogProperties = DialogProperties(usePlatformDefaultWidth = false)
                    ) {
                        SaveTemplateContents(
                            saveTemplate = { title, color -> viewModel.saveTemplate(title, color) },
                            onClose = { navController.popBackStack() })
                    }
                    dialog(
                        route = "floating",
                        dialogProperties = DialogProperties(usePlatformDefaultWidth = false)
                    ) {
                        FloatingContents(
                            onClose = { navController.popBackStack() },
                            onClickAddCategory = {
                                deepLink(
                                    DeepLink.AddCategory(
                                        planId = planId,
                                    )
                                ) { popUpTo(R.id.checklist) }
                            },
                            onClickSaveTemplate = { navController.navigate("saveTemplate") },
                            onClickBringTemplate = { viewModel.bringTemplate() },
                        )
                    }
                    dialog(
                        route = "categoryMore/{categoryId}?title={title}?type={type}",
                        arguments = listOf(
                            navArgument("categoryId") { type = NavType.StringType },
                            navArgument("title") { type = NavType.StringType; defaultValue = "" },
                            navArgument("type") { type = NavType.StringType; defaultValue = "" },
                        ),
                        dialogProperties = DialogProperties(usePlatformDefaultWidth = false),
                    ) {
                        val categoryId = it.arguments?.getString("categoryId") ?: ""
                        val title = it.arguments?.getString("title") ?: ""
                        val type = it.arguments?.getString("type") ?: ""
                        MoreCategoryBottomSheet(
                            title = title,
                            navigateEditItem = {
                                navController.popBackStack()
                                deepLink(
                                    DeepLink.EditCategory(
                                        planId = planId,
                                        categoryId = categoryId,
                                        title = title,
                                        type = type
                                    )
                                ) { popUpTo(R.id.checklist) }
                            },
                            deleteItem = {
                                navController.popBackStack()
                                viewModel.deleteCategory(planId, categoryId)
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
        val id = arguments?.getString("planId")
        id?.let {
            planId = it
            //todo if planId.isEmpty return
            viewModel.getChecklist(it)
        }
    }
}