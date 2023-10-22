package com.dkin.chevit.presentation.home

import com.dkin.chevit.core.mvi.MVIViewModel
import com.dkin.chevit.domain.base.get
import com.dkin.chevit.domain.usecase.GetUserUseCase
import com.dkin.chevit.presentation.home.MyPageIntent.AlarmSwitchClicked
import com.dkin.chevit.presentation.home.MyPageIntent.LogoutClicked
import com.dkin.chevit.presentation.home.MyPageIntent.ViewCreated
import com.dkin.chevit.presentation.home.MyPageIntent.WithdrawClicked
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MyPageViewModel @Inject constructor(
    private val getUserUseCase: GetUserUseCase
) : MVIViewModel<MyPageIntent, MyPageState, MyPageEffect>() {

    override fun createInitialState(): MyPageState = MyPageState.empty()

    override suspend fun processIntent(intent: MyPageIntent) = when (intent) {
        LogoutClicked -> {}
        WithdrawClicked -> {}
        is AlarmSwitchClicked -> {}
        ViewCreated -> setup()
    }

    private suspend fun setup() {
        val user = getUserUseCase(Unit).get()
        setState { copy(userName = user.name, profileUrl = user.profileImageUrl) }
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
        launch { processIntent(LogoutClicked) }
    }

    fun onClickWithdraw() {
        launch { processIntent(WithdrawClicked) }
    }

    fun onClickAlarmEnabled(enabled: Boolean) {
        setState { copy(alarmEnabled = enabled) }
        launch {
            processIntent(AlarmSwitchClicked(enabled))
        }
    }

    fun onClickNotificationSetting() {
        setEffect { MyPageEffect.NavigateToNotificationSetting }
    }
}
