package com.dkin.chevit.presentation.step

import androidx.compose.runtime.Stable
import com.dkin.chevit.core.mvi.ViewEffect
import com.dkin.chevit.core.mvi.ViewIntent
import com.dkin.chevit.core.mvi.ViewState

sealed interface StepIntent : ViewIntent {
}

@Stable
data class StepState(
    val country: String
) : ViewState {
    companion object {
        fun empty(): StepState = StepState("")
    }
}

sealed interface StepEffect : ViewEffect {
}
