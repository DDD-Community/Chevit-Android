package com.dkin.chevit.presentation.checklist.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.window.DialogProperties
import androidx.fragment.app.viewModels
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.dialog
import androidx.navigation.compose.rememberNavController
import androidx.navigation.findNavController
import com.dkin.chevit.core.mvi.MVIComposeFragment
import com.dkin.chevit.presentation.checklist.main.contents.SaveTemplateContents
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Checklist : MVIComposeFragment<ChecklistIntent, ChecklistState, ChecklistEffect>() {

    override val viewModel: ChecklistViewModel by viewModels()

    override fun processEffect(effect: ChecklistEffect) {
        when (effect) {
            ChecklistEffect.NavigateToBringTemplate -> {}
            is ChecklistEffect.NavigateToLink -> {}
            is ChecklistEffect.NavigateToCategory -> {}
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
                            onClickBack = {
                                findNavController().popBackStack()
                            },
                            navigateAddCategory = {
                                navController.navigate("addCategory")
                            },
                            navigateSaveTemplate = {
                                navController.navigate("saveTemplate")
                            }
                        )
                    }
                    composable("addCategory") {
                        AddCategoryScreen(
                            saveCategory = { title, category ->
                                viewModel.addCategory(title, category)
                                navController.popBackStack()
                            },
                            onClickBack = { navController.popBackStack() }
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
                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val id = arguments?.getString("planId")
        id?.let { viewModel.getChecklist(it) }
    }
}