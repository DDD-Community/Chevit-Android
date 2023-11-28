package com.dkin.chevit.presentation.checklist.template.model

import com.dkin.chevit.presentation.checklist.main.ChecklistState

data class TemplateDetailState(
    val templateName: String,
    val categories: List<ChecklistState.Category>,
)