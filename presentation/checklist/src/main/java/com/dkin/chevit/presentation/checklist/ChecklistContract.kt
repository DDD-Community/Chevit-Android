package com.dkin.chevit.presentation.checklist

import androidx.compose.runtime.Stable
import com.dkin.chevit.core.mvi.ViewEffect
import com.dkin.chevit.core.mvi.ViewIntent
import com.dkin.chevit.core.mvi.ViewState

sealed interface ChecklistIntent : ViewIntent {
}

@Stable
data class ChecklistState(
    val title: String = ""
) : ViewState {

    companion object {
        fun empty(): ChecklistState = ChecklistState()
    }
}

sealed interface ChecklistEffect : ViewEffect {
    object NavigateToAddCategory : ChecklistEffect
}
