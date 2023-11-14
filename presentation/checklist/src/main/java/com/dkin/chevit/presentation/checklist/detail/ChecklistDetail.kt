package com.dkin.chevit.presentation.checklist.detail

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
                            navigateEditItem = { navController.navigate("editItem") },
                            openSortSheet = { navController.navigate("sort") },
                            openEditSheet = { navController.navigate("edit") }
                        )
                    }
                    composable("addItem") {
                        AddItemScreen()
                    }
                    composable("editItem") {
                        EditItemScreen()
                    }
                    dialog(
                        route = "sort",
                        dialogProperties = DialogProperties(usePlatformDefaultWidth = false)
                    ) {

                    }
                    dialog(
                        route = "edit",
                        dialogProperties = DialogProperties(usePlatformDefaultWidth = false)
                    ) {

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