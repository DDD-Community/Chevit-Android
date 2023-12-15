package com.dkin.chevit.presentation.checklist.category

import com.dkin.chevit.core.mvi.ViewEffect
import com.dkin.chevit.core.mvi.ViewIntent
import com.dkin.chevit.core.mvi.ViewState
import com.dkin.chevit.presentation.common.model.CategoryType

sealed interface EditCategoryIntent : ViewIntent {
    data class UpdateCategory(val title: String, val type: CategoryType) : EditCategoryIntent
}

data class EditCategoryState(
    val planId: String,
    val categoryId: String,
    val title: String,
    val type: CategoryType
) : ViewState {
    companion object {
        fun empty() = EditCategoryState("", "", "", CategoryType.REQUIRES)
    }
}

sealed interface EditCategoryEffect : ViewEffect {
    object EditItemSuccess : EditCategoryEffect
    object EditItemFailed : EditCategoryEffect
}