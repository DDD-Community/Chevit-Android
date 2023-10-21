package com.dkin.chevit.presentation.home

import com.dkin.chevit.core.mvi.MVIViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MyPageViewModel @Inject constructor() :
    MVIViewModel<MyPageIntent, MyPageState, MyPageEffect>() {

    override fun createInitialState(): MyPageState = MyPageState.empty()

    override suspend fun processIntent(intent: MyPageIntent) {
        when (intent) {
            MyPageIntent.LogoutClicked -> {}
            MyPageIntent.WithdrawClicked -> {}
            is MyPageIntent.AlarmSwitchClicked -> {}
        }
    }

    fun onClickProfileSetting() {
        setEffect { MyPageEffect.NavigateToProfileSetting }
    }

    fun onClickMyCheckList() {
        setEffect { MyPageEffect.NavigateToMyCheckList }
    }

    fun onClickTerms() {
        setEffect { MyPageEffect.NavigateToTerms }
    }

    fun onClickLogout() {
        launch { processIntent(MyPageIntent.LogoutClicked) }
    }

    fun onClickWithdraw() {
        launch { processIntent(MyPageIntent.WithdrawClicked) }
    }

    fun onClickAlarmEnabled(enabled: Boolean) {
        setState { copy(alarmEnabled = enabled) }
        launch {
            processIntent(MyPageIntent.AlarmSwitchClicked(enabled))
        }
    }

    fun onClickNotificationSetting() {
        setEffect { MyPageEffect.NavigateToNotificationSetting }
    }
}
