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
class EditCategory :
    MVIComposeFragment<EditCategoryIntent, EditCategoryState, EditCategoryEffect>() {
    override val viewModel: EditCategoryViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                EditCategoryScreen(
                    viewModel = viewModel,
                    onClickBack = { findNavController().popBackStack() },
                    saveCategory = { title, type ->
                        viewModel.dispatch(
                            EditCategoryIntent.UpdateCategory(title, type)
                        )
                    }
                )
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val planId = arguments?.getString("planId")
        val categoryId = arguments?.getString("categoryId")
        val title = arguments?.getString("title")
        val type = arguments?.getString("type")
        if (planId == null || categoryId == null || title == null || type == null) {
            //todo alert
            findNavController().popBackStack()
        } else {
            viewModel.initState(planId, categoryId, title, getCategoryTypeByName(type))
        }
    }

    override fun processEffect(effect: EditCategoryEffect) {
        when (effect) {
            EditCategoryEffect.EditItemSuccess -> findNavController().popBackStack()
            EditCategoryEffect.EditItemFailed -> {
                Toast.makeText(requireContext(), "카테고리 수정에 실패하였습니다.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun processState(state: EditCategoryState) {}

}