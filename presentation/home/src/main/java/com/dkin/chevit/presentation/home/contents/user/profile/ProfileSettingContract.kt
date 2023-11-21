package com.dkin.chevit.presentation.home.contents.user.profile

import androidx.compose.runtime.Stable
import com.dkin.chevit.core.mvi.ViewEffect
import com.dkin.chevit.core.mvi.ViewIntent
import com.dkin.chevit.core.mvi.ViewState

sealed interface ProfileSettingIntent : ViewIntent {

}

@Stable
data class ProfileSettingState(
    val name: String,
    val imageUrl: String
) : ViewState {
    companion object {
        fun dummy(): ProfileSettingState = ProfileSettingState(name = "민지", imageUrl = "")
    }
}

sealed interface ProfileSettingEffect : ViewEffect {

}
