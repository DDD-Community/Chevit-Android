package com.dkin.chevit.presentation.checklist.category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.dkin.chevit.core.mvi.MVIComposeFragment
import com.dkin.chevit.presentation.common.model.getCategoryTypeByName
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddCategory : MVIComposeFragment<AddCategoryIntent, AddCategoryState, AddCategoryEffect>() {
    override val viewModel: AddCategoryViewModel by viewModels()

    override fun processEffect(effect: AddCategoryEffect) {
        when (effect) {
            AddCategoryEffect.AddItemSuccess -> findNavController().popBackStack()
            AddCategoryEffect.AddItemFailed -> {
                Toast.makeText(requireContext(), "카테고리 생성에 실패하였습니다.", Toast.LENGTH_SHORT).show()
            }
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val planId = arguments?.getString("planId")
        if (planId == null) {
            findNavController().popBackStack()
        } else {
            viewModel.initState(planId)
        }
    }
}