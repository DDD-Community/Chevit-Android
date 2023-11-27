package com.dkin.chevit.presentation.checklist.category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.dkin.chevit.core.mvi.MVIComposeFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddCategory :
    MVIComposeFragment<AddCategoryIntent, AddCategoryState, AddCategoryEffect>() {
    override val viewModel: AddCategoryViewModel by viewModels()

    override fun processEffect(effect: AddCategoryEffect) {
        when (effect) {
            else -> {}
        }
    }

    override fun processState(state: AddCategoryState) {}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                AddCategoryScreen(
                    viewModel = viewModel,
                    onClickBack = { findNavController().popBackStack() }
                )
            }
        }
    }
}