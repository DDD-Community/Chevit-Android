package com.dkin.chevit.presentation.checklist

import com.dkin.chevit.core.mvi.MVIViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ChecklistViewModel @Inject constructor() :
    MVIViewModel<ChecklistIntent, ChecklistState, ChecklistEffect>() {

    override fun createInitialState(): ChecklistState = ChecklistState.empty()

    override suspend fun processIntent(intent: ChecklistIntent) {
        when (intent) {
            else -> {}
        }
    }
}