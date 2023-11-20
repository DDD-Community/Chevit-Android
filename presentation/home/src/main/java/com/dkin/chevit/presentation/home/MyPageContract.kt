package com.dkin.chevit.presentation.home

import androidx.compose.runtime.Stable
import com.dkin.chevit.core.mvi.ViewEffect
import com.dkin.chevit.core.mvi.ViewIntent
import com.dkin.chevit.core.mvi.ViewState

sealed interface MyPageIntent : ViewIntent {
    object ViewCreated : MyPageIntent
    data class AlarmSwitchClicked(val enabled: Boolean) : MyPageIntent
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
