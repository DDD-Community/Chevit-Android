package com.dkin.chevit.presentation.home.contents.user.profile

import androidx.compose.runtime.Stable
import com.dkin.chevit.core.mvi.ViewEffect
import com.dkin.chevit.core.mvi.ViewIntent
import com.dkin.chevit.core.mvi.ViewState

sealed interface ProfileSettingIntent : ViewIntent {
    object Initialize : ProfileSettingIntent
}

@Stable
sealed interface ProfileSettingState :  ViewState {
    object Loading : ProfileSettingState
    data class Stable(
        val name: String,
        val imageUrl: String
    ) : ProfileSettingState {
        companion object {
            fun dummy(): Stable = Stable(name = "민지", imageUrl = "")
        }
    }
}


sealed interface ProfileSettingEffect : ViewEffect {

}
