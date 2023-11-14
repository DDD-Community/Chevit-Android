package com.dkin.chevit.presentation.checklist.detail

import com.dkin.chevit.core.mvi.MVIViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ChecklistDetailViewModel @Inject constructor() :
    MVIViewModel<ChecklistDetailIntent, ChecklistDetailState, ChecklistDetailEffect>() {
    override fun createInitialState(): ChecklistDetailState = ChecklistDetailState.empty()

    override suspend fun processIntent(intent: ChecklistDetailIntent) {
        when(intent) {
            else -> {}
        }
    }

    fun getChecklistDetail(planId: String, categoryId: String) {
        //TODO
    }

    fun searchItem(keyword: String) {
        //TODO
    }

    fun checkItem(itemId: String) {
        //TODO
    }

    fun editItem(itemId: String) {
        //TODO
    }

    fun removeItem(itemId: String) {
        //TODO
    }

    fun filterCompletedItem(completed: Boolean) {
        //TODO
    }
}