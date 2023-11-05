package com.dkin.chevit.presentation.checklist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.viewModels
import com.dkin.chevit.core.mvi.MVIComposeFragment
import com.dkin.chevit.presentation.checklist.databinding.FragmentChecklistBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CheckList : MVIComposeFragment<ChecklistIntent, ChecklistState, ChecklistEffect>() {

    override val viewModel: ChecklistViewModel by viewModels()

    private var _binding: FragmentChecklistBinding? = null
    private val binding get() = _binding!!

    override fun processEffect(effect: ChecklistEffect) {
        when (effect) {
            ChecklistEffect.NavigateToAddCategory -> {}
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
        _binding = FragmentChecklistBinding.inflate(inflater, container, false)
        val view = binding.root
        binding.composeView.apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                ChecklistScreen(
                    viewModel = viewModel,
                    onClickBack = { requireActivity().onBackPressed() }
                )
            }
        }
        return view
    }
}