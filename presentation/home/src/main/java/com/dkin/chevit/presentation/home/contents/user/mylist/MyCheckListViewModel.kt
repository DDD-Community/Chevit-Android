package com.dkin.chevit.presentation.home.contents.user.mylist

import com.dkin.chevit.core.mvi.MVIViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MyCheckListViewModel @Inject constructor() :
    MVIViewModel<MyCheckListIntent, MyCheckListState, MyCheckListEffect>() {

    override fun createInitialState() = MyCheckListState.dummy()

    override suspend fun processIntent(intent: MyCheckListIntent) {
        when (intent) {
            else -> {}
        }
    }

    fun onClickChecklist(id: String) {
        setEffect { MyCheckListEffect.NavigateToCheckList(id) }
    }
}