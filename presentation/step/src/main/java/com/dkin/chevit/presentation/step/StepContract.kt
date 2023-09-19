package com.dkin.chevit.presentation.step

import androidx.compose.runtime.Stable
import com.dkin.chevit.core.mvi.ViewEffect
import com.dkin.chevit.core.mvi.ViewIntent
import com.dkin.chevit.core.mvi.ViewState
import com.dkin.chevit.presentation.step.model.CountryModel

sealed interface StepIntent : ViewIntent {
}

@Stable
data class StepState(
    val country: CountryModel? = null,
    val startDate: String? = null,
    val endDate: String? = null,
    val travelWith: String? = null,
    val travelKind: String? = null
) : ViewState {
    companion object {
        fun empty(): StepState = StepState()
    }
}

sealed interface StepEffect : ViewEffect {
}
