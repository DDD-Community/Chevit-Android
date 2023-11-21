package com.dkin.chevit.presentation.home.contents.user

import androidx.compose.runtime.Stable
import com.dkin.chevit.core.mvi.ViewEffect
import com.dkin.chevit.core.mvi.ViewIntent
import com.dkin.chevit.core.mvi.ViewState

sealed interface MyPageIntent : ViewIntent {
    object ViewCreated : MyPageIntent
    data class AlarmSwitchClicked(val enabled: Boolean) : MyPageIntent
    object SignOutClicked : MyPageIntent
    object WithDrawClicked : MyPageIntent
    object ProfileSettingClicked : MyPageIntent
    object TermsClicked : MyPageIntent
    object NotificationSettingClicked : MyPageIntent
}

@Stable
data class MyPageState(
    val userName: String,
    val profileUrl: String,
    val notificationEnabled: Boolean,
) : ViewState {
    companion object {
        fun empty(): MyPageState = MyPageState("", "", false)
    }
}

sealed interface MyPageEffect : ViewEffect {
    object NavigateToProfileSetting : MyPageEffect

    object NavigateToTerms : MyPageEffect

    object NavigateToNotificationSetting : MyPageEffect

    object NavigateToOnBoarding : MyPageEffect
}
