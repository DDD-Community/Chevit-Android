package com.dkin.chevit.presentation.step

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.viewModels
import com.dkin.chevit.core.mvi.MVIComposeFragment
import com.dkin.chevit.presentation.deeplink.DeepLink
import com.dkin.chevit.presentation.deeplink.deepLink
import com.dkin.chevit.presentation.step.databinding.FragmentStepBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Step : MVIComposeFragment<StepIntent, StepState, StepEffect>() {

    override val viewModel: StepViewModel by viewModels()

    private var _binding: FragmentStepBinding? = null
    private val binding get() = _binding!!

    override fun processEffect(effect: StepEffect) {
        when (effect) {
            is StepEffect.NavigateToCheckList -> {
                deepLink(DeepLink.CheckList) {
                    popUpTo(R.id.step) { inclusive = true }
                }
            }
        }
    }

    override fun processState(state: StepState) {}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentStepBinding.inflate(inflater, container, false)
        val view = binding.root
        binding.composeView.apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                StepScreen(
                    viewModel = viewModel,
                    onClickClose = { requireActivity().onBackPressed() }
                )
            }
        }
        return view
    }
}