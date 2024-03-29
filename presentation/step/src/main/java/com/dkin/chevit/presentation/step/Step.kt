package com.dkin.chevit.presentation.step

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.dkin.chevit.core.mvi.MVIComposeFragment
import com.dkin.chevit.presentation.deeplink.DeepLink
import com.dkin.chevit.presentation.deeplink.deepLink
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Step : MVIComposeFragment<StepIntent, StepState, StepEffect>() {

    override val viewModel: StepViewModel by viewModels()

    override fun processEffect(effect: StepEffect) {
        when (effect) {
            is StepEffect.NavigateToCheckList -> {
                deepLink(DeepLink.CheckList(effect.id)) {
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
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                StepScreen(
                    viewModel = viewModel,
                    onClickClose = { requireActivity().onBackPressed() },
                )
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val nickname = arguments?.getString("nickname")
        nickname?.let {
            viewModel.setNickname(nickname)
        } ?: findNavController().popBackStack()
    }
}
