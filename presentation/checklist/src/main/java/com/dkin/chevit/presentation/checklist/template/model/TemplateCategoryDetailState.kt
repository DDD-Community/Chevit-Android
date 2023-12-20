package com.dkin.chevit.presentation.checklist.template.model

import androidx.compose.runtime.Stable
import com.dkin.chevit.presentation.checklist.detail.ChecklistDetailState

@Stable
sealed interface TemplateCategoryDetailState {
    object Loading : TemplateCategoryDetailState

    data class Available(
        val categoryName: String,
        val detailItems: List<ChecklistDetailState.Available.ChecklistDetailItem>
    ) : TemplateCategoryDetailState {
        companion object {
            fun empty(): Available = Available("", listOf())
        }
    }
}