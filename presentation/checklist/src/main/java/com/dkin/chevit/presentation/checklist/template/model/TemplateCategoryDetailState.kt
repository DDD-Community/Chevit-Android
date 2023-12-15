package com.dkin.chevit.presentation.checklist.template.model

import com.dkin.chevit.presentation.checklist.detail.ChecklistDetailState

data class TemplateCategoryDetailState(
    val categoryName: String,
    val detailItems: List<ChecklistDetailState.ChecklistDetailItem>
) {
    companion object {
        fun empty(): TemplateCategoryDetailState = TemplateCategoryDetailState("", listOf())
    }
}