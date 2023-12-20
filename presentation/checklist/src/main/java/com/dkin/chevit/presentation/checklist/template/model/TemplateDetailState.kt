package com.dkin.chevit.presentation.checklist.template.model

import androidx.compose.runtime.Stable
import com.dkin.chevit.presentation.checklist.main.ChecklistState

@Stable
sealed interface TemplateDetailState {
    object Loading : TemplateDetailState

    data class Available(
        val templateName: String,
        val categories: List<ChecklistState.Available.Category>,
    ) : TemplateDetailState {
        companion object {
            fun empty(): Available = Available("", listOf())
        }
    }
}