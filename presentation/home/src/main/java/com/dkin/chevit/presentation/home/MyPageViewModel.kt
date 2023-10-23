package com.dkin.chevit.presentation.home

import com.dkin.chevit.core.mvi.MVIViewModel
import com.dkin.chevit.domain.base.get
import com.dkin.chevit.domain.usecase.auth.GetUserUseCase
import com.dkin.chevit.domain.usecase.notification.GetNotificationSettingUseCase
import com.dkin.chevit.domain.usecase.notification.UpdateNotificationEnableStateUseCase
import com.dkin.chevit.presentation.home.MyPageIntent.AlarmSwitchClicked
import com.dkin.chevit.presentation.home.MyPageIntent.LogoutClicked
import com.dkin.chevit.presentation.home.MyPageIntent.ViewCreated
import com.dkin.chevit.presentation.home.MyPageIntent.WithdrawClicked
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.awaitAll
import timber.log.Timber

@HiltViewModel
class MyPageViewModel @Inject constructor(
    private val getUserUseCase: GetUserUseCase,
    private val getNotificationSettingUseCase: GetNotificationSettingUseCase,
    private val updateNotificationEnableStateUseCase: UpdateNotificationEnableStateUseCase
) : MVIViewModel<MyPageIntent, MyPageState, MyPageEffect>() {

    override fun createInitialState(): MyPageState = MyPageState.empty()

    override suspend fun processIntent(intent: MyPageIntent) = when (intent) {
        ViewCreated -> setup()
        is AlarmSwitchClicked -> onClickAlarmEnabled(intent.enabled)
        LogoutClicked -> {}
        WithdrawClicked -> {}
    }

    private suspend fun setup() {
        val asyncUser = async { getUserUseCase(Unit).get() }
        val notificationSettingAsync = async { getNotificationSettingUseCase(Unit).get() }
        listOf(asyncUser, notificationSettingAsync).awaitAll()
        val user = asyncUser.await()
        val notificationSetting = notificationSettingAsync.await()
        setState {
            copy(
                userName = user.name,
                profileUrl = user.profileImageUrl,
                notificationEnabled = notificationSetting.notificationEnabled
            )
        }
    }

    private suspend fun onClickAlarmEnabled(enabled: Boolean) {
        val param = UpdateNotificationEnableStateUseCase.Param(notificationEnabled = enabled)
        val notificationSetting = updateNotificationEnableStateUseCase(param).get()
        setState { copy(notificationEnabled = notificationSetting.notificationEnabled) }
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

    fun onClickNotificationSetting() {
        setEffect { MyPageEffect.NavigateToNotificationSetting }
    }
}
