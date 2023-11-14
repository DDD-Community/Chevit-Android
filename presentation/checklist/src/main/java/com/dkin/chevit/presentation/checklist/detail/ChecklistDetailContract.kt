package com.dkin.chevit.presentation.checklist.detail

import androidx.compose.runtime.Stable
import com.dkin.chevit.core.mvi.ViewEffect
import com.dkin.chevit.core.mvi.ViewIntent
import com.dkin.chevit.core.mvi.ViewState

sealed interface ChecklistDetailIntent : ViewIntent {
}

@Stable
data class ChecklistDetailState(
    val title: String,
) : ViewState {


    companion object {
        fun empty(): ChecklistDetailState = ChecklistDetailState(
            title = "파리, 프랑스",
        )
    }
}

sealed interface ChecklistDetailEffect : ViewEffect {
    object NavigateToAddItem : ChecklistDetailEffect
}
