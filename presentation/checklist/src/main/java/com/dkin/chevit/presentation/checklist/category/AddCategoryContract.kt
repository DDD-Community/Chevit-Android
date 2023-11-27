package com.dkin.chevit.presentation.checklist.category

import androidx.compose.runtime.Stable
import com.dkin.chevit.core.mvi.ViewEffect
import com.dkin.chevit.core.mvi.ViewIntent
import com.dkin.chevit.core.mvi.ViewState
import com.dkin.chevit.presentation.checklist.model.CategoryType

sealed interface AddCategoryIntent : ViewIntent {
}

@Stable
data class AddCategoryState(
    val title: String,
    val category: CategoryType?
) : ViewState {
    companion object {
        fun empty(): AddCategoryState = AddCategoryState("", null)
    }
}

sealed interface AddCategoryEffect : ViewEffect {
}