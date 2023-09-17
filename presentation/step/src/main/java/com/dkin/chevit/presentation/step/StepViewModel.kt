package com.dkin.chevit.presentation.step

import com.dkin.chevit.core.mvi.MVIViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class StepViewModel @Inject constructor() : MVIViewModel<StepIntent, StepState, StepEffect>() {
    override fun createInitialState(): StepState = StepState.empty()

    override suspend fun processIntent(intent: StepIntent) {
        when (intent) {
            else -> {}
        }
    }
}