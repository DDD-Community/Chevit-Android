package com.dkin.chevit.presentation.home.contents.user

import com.dkin.chevit.core.mvi.MVIViewModel
import com.dkin.chevit.domain.base.get
import com.dkin.chevit.domain.base.onComplete
import com.dkin.chevit.domain.usecase.auth.GetUserUseCase
import com.dkin.chevit.domain.usecase.auth.SignOutUseCase
import com.dkin.chevit.domain.usecase.auth.WithDrawUserUseCase
import com.dkin.chevit.domain.usecase.notification.UpdateNotificationEnableStateUseCase
import com.dkin.chevit.domain.usecase.service.GetAppInfoUseCase
import com.dkin.chevit.presentation.home.contents.user.MyPageIntent.AlarmSwitchClicked
import com.dkin.chevit.presentation.home.contents.user.MyPageIntent.NotificationSettingClicked
import com.dkin.chevit.presentation.home.contents.user.MyPageIntent.ProfileSettingClicked
import com.dkin.chevit.presentation.home.contents.user.MyPageIntent.SignOutClicked
import com.dkin.chevit.presentation.home.contents.user.MyPageIntent.TermsBottomSheetClicked
import com.dkin.chevit.presentation.home.contents.user.MyPageIntent.TermsClicked
import com.dkin.chevit.presentation.home.contents.user.MyPageIntent.ViewCreated
import com.dkin.chevit.presentation.home.contents.user.MyPageIntent.WithDrawClicked
import com.dkin.chevit.presentation.home.model.Terms
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MyPageViewModel @Inject constructor(
    private val getUserUseCase: GetUserUseCase,
    private val signOutUseCase: SignOutUseCase,
    private val withDrawUserUseCase: WithDrawUserUseCase,
    private val updateNotificationEnableStateUseCase: UpdateNotificationEnableStateUseCase,
    private val getAppInfoUseCase: GetAppInfoUseCase
) : MVIViewModel<MyPageIntent, MyPageState, MyPageEffect>() {

    override fun createInitialState(): MyPageState = MyPageState.empty()

    override suspend fun processIntent(intent: MyPageIntent) = when (intent) {
        ViewCreated -> setup()
        is AlarmSwitchClicked -> onClickAlarmEnabled(intent.enabled)
        SignOutClicked -> onClickSignOut()
        WithDrawClicked -> onClickWithdraw()
        ProfileSettingClicked -> onClickProfileSetting()
        TermsClicked -> onClickTerms()
        NotificationSettingClicked -> onClickNotificationSetting()
        is TermsBottomSheetClicked -> showTermsWebView(intent.item)

    }

    private suspend fun setup() {
        val user = getUserUseCase(Unit).get()
        setState {
            copy(
                userName = user.name,
                profileUrl = user.profileImageUrl,
                notificationEnabled = user.notificationEnabled
            )
        }
    }

    private suspend fun onClickAlarmEnabled(enabled: Boolean) {
        val param = UpdateNotificationEnableStateUseCase.Param(notificationEnabled = enabled)
        val notificationSetting = updateNotificationEnableStateUseCase(param).get()
        setState { copy(notificationEnabled = notificationSetting.notificationEnabled) }
    }

    private suspend fun onClickSignOut() {
        signOutUseCase(Unit).onComplete {
            setEffect { MyPageEffect.NavigateToOnBoarding }
        }
    }

    private suspend fun onClickWithdraw() {
        withDrawUserUseCase(Unit).onComplete {
            setEffect { MyPageEffect.NavigateToOnBoarding }
        }
    }

    private fun onClickProfileSetting() {
        setEffect { MyPageEffect.NavigateToProfileSetting }
    }

    private suspend fun onClickTerms() {
        setEffect { MyPageEffect.ShowTermsBottomSheet }
    }

    private fun onClickNotificationSetting() {
        setEffect { MyPageEffect.NavigateToNotificationSetting }
    }

    private suspend fun showTermsWebView(terms: Terms) {
        getAppInfoUseCase(Unit).onComplete {
            val url = when (terms) {
                Terms.SERVICE -> termsOfServiceWebUrl
                Terms.PRIVACY -> privacyPolicyWebUrl
            }
            setEffect { MyPageEffect.ShowTermsWebView(url) }
        }
    }
}
