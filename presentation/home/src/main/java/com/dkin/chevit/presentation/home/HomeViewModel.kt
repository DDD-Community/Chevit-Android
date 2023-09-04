package com.dkin.chevit.presentation.home

import com.dkin.chevit.core.mvi.MVIViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : MVIViewModel<HomeIntent, HomeState, HomeEffect>() {

    override fun createInitialState(): HomeState = HomeState.empty()

    override suspend fun processIntent(intent: HomeIntent) {
        when (intent) {
            is HomeIntent.NoticeClicked -> TODO()
            HomeIntent.LogoutClicked -> TODO()
            HomeIntent.WithdrawClicked -> TODO()
        }
    }

    fun onClickAddChecklist() {
        setEffect { HomeEffect.NavigateToAddCheckList }
    }

    fun onClickChecklist(id: Int) {
        setEffect { HomeEffect.NavigateToCheckList(id) }
    }

    fun onClickProfileSetting() {
        setEffect { HomeEffect.NavigateToProfileSetting }
    }

    fun onClickMyCheckList() {
        setEffect { HomeEffect.NavigateToMyCheckList }
    }

    fun onClickTerms() {
        setEffect { HomeEffect.NavigateToTerms }
    }

    fun onClickLogout() {
        launch { processIntent(HomeIntent.LogoutClicked) }
    }

    fun onClickWithdraw() {
        launch { processIntent(HomeIntent.WithdrawClicked) }
    }

    fun onClickAlarmEnabled(enabled: Boolean) {
        setState { copy(alarmEnabled = enabled) }
        launch {
            processIntent(HomeIntent.NoticeClicked(enabled))
        }
    }
    fun onClickNotificationSetting() {
        setEffect { HomeEffect.NavigateToNotificationSetting }
    }
}
