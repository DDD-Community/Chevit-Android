package com.dkin.chevit.presentation.checklist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.viewModels
import com.dkin.chevit.core.mvi.MVIComposeFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CheckList : MVIComposeFragment<ChecklistIntent, ChecklistState, ChecklistEffect>() {

    override val viewModel: ChecklistViewModel by viewModels()

    override fun processEffect(effect: ChecklistEffect) {
        when (effect) {
            ChecklistEffect.NavigateToAddCategory -> {}
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
                ChecklistScreen(
                    viewModel = viewModel,
                    onClickBack = { requireActivity().onBackPressed() }
                )
            }
        }
    }
}