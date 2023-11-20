package com.dkin.chevit.presentation.home

import com.dkin.chevit.core.mvi.MVIViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : MVIViewModel<HomeIntent, HomeState, HomeEffect>() {

    override fun createInitialState(): HomeState = HomeState.dummy()

    override suspend fun processIntent(intent: HomeIntent) {
        when (intent) {
            is HomeIntent.NoticeClicked -> {}
        }
    }

    fun refreshMyCheckList() {
        //todo mypage에서 내 체크리스트 이동 시 사용
    }

    fun onClickAddChecklist() {
        setEffect { HomeEffect.NavigateToAddCheckList }
    }

    fun onClickChecklist(id: String) {
        setEffect { HomeEffect.NavigateToCheckList(id) }
    }
}
