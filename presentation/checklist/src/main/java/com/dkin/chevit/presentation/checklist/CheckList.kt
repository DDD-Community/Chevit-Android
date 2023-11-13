package com.dkin.chevit.presentation.checklist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.viewModels
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.findNavController
import com.dkin.chevit.core.mvi.MVIComposeFragment
import com.dkin.chevit.presentation.common.category.AddCategoryContents
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CheckList : MVIComposeFragment<ChecklistIntent, ChecklistState, ChecklistEffect>() {

    override val viewModel: ChecklistViewModel by viewModels()

    override fun processEffect(effect: ChecklistEffect) {
        when (effect) {
            ChecklistEffect.NavigateToBringTemplate -> {}
            ChecklistEffect.NavigateToSaveTemplate -> {}
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
                            }
                        )
                    }
                    composable("addCategory") {
                        AddCategoryContents(
                            saveCategory = { title, category ->
                                viewModel.addCategory(title, category)
                                navController.popBackStack()
                            },
                            onClickBack = { navController.popBackStack() }
                        )
                    }
                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val id = arguments?.getString("checklistId")
        id?.let { viewModel.getChecklist(it) }
    }
}