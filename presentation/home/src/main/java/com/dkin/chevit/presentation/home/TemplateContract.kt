package com.dkin.chevit.presentation.home

import androidx.compose.runtime.Stable
import com.dkin.chevit.core.mvi.ViewEffect
import com.dkin.chevit.core.mvi.ViewIntent
import com.dkin.chevit.core.mvi.ViewState
import com.dkin.chevit.presentation.home.model.Template

sealed interface TemplateIntent : ViewIntent

@Stable
sealed interface TemplateState : ViewState {
    object EMPTY : TemplateState
    data class Available(
        val templateList: List<Template>
    ) : TemplateState
}

sealed interface TemplateEffect : ViewEffect {

    object NavigateToAddTemplate : TemplateEffect

    object NavigateToSortTemplate : TemplateEffect

    data class NavigateToTemplate(val id: String) : TemplateEffect
}