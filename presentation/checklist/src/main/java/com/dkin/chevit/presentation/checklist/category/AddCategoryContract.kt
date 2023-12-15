package com.dkin.chevit.presentation.checklist.category

import androidx.compose.runtime.Stable
import com.dkin.chevit.core.mvi.ViewEffect
import com.dkin.chevit.core.mvi.ViewIntent
import com.dkin.chevit.core.mvi.ViewState
import com.dkin.chevit.presentation.common.model.CategoryType

sealed interface AddCategoryIntent : ViewIntent {
    data class AddCategory(val title: String, val type: CategoryType) : AddCategoryIntent
}

@Stable
data class AddCategoryState(
    val planId: String,
    val title: String,
    val category: CategoryType?
) : ViewState {
    companion object {
        fun empty(): AddCategoryState = AddCategoryState("", "", null)
    }
}

sealed interface AddCategoryEffect : ViewEffect {
    object AddItemSuccess : AddCategoryEffect
    object AddItemFailed : AddCategoryEffect
}