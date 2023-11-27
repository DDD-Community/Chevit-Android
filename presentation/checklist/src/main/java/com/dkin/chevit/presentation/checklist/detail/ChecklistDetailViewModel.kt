package com.dkin.chevit.presentation.checklist.detail

import com.dkin.chevit.core.mvi.MVIViewModel
import com.dkin.chevit.presentation.common.model.SortType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class ChecklistDetailViewModel @Inject constructor() :
    MVIViewModel<ChecklistDetailIntent, ChecklistDetailState, ChecklistDetailEffect>() {

    private val _sortType: MutableStateFlow<SortType> = MutableStateFlow(SortType.NEW)
    val sortType = _sortType.asStateFlow()

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

    fun removeItem(itemId: String) {
        //TODO
    }

    fun sortItem(type: SortType) {
        //TODO
    }

    fun addItem(title: String, memo: String, count: Int) {
        //TODO
    }

    fun editItem(itemId: String, title: String, memo: String, count: Int) {
        //TODO
    }
}