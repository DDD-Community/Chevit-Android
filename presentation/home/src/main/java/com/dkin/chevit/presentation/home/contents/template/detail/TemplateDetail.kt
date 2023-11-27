package com.dkin.chevit.presentation.home.contents.template.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.dkin.chevit.core.mvi.MVIComposeFragment
import com.dkin.chevit.presentation.deeplink.DeepLink
import com.dkin.chevit.presentation.deeplink.deepLink
import com.dkin.chevit.presentation.home.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TemplateDetail:
    MVIComposeFragment<TemplateDetailIntent, TemplateDetailState, TemplateDetailEffect>() {
    override val viewModel: TemplateDetailViewModel by viewModels()

    private lateinit var planId: String

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                TemplateDetailScreen(
                    modifier = Modifier.fillMaxSize(),
                    viewModel = viewModel,
                    onClickBack = { findNavController().popBackStack() }
                )
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val id = arguments?.getString("planId")
        id?.let {
            planId = it
            //todo if planId.isEmpty return
            viewModel.getTemplateList(it)
        }
    }

    override fun processEffect(effect: TemplateDetailEffect) {
        when(effect) {
            TemplateDetailEffect.NavigateToAddCategory -> {
                deepLink(
                    DeepLink.AddCategory(
                        planId = planId,
                    )
                ) { popUpTo(R.id.templateDetail) }
            }
            is TemplateDetailEffect.NavigateToChecklistDetail -> {
                deepLink(
                    DeepLink.CheckListDetail(
                        planId = planId,
                        categoryId = effect.categoryId
                    )
                ) { popUpTo(R.id.templateDetail) }
            }
        }
    }

    override fun processState(state: TemplateDetailState) {}
}