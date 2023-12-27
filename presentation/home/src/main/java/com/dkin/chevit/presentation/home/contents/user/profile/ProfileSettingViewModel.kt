package com.dkin.chevit.presentation.home.contents.user.profile

import com.dkin.chevit.core.mvi.MVIViewModel
import com.dkin.chevit.domain.base.get
import com.dkin.chevit.domain.base.onComplete
import com.dkin.chevit.domain.usecase.auth.GetUserUseCase
import com.dkin.chevit.domain.usecase.auth.UpdateUserUseCase
import com.dkin.chevit.presentation.home.contents.user.profile.ProfileSettingIntent.Initialize
import com.dkin.chevit.presentation.home.contents.user.profile.ProfileSettingIntent.SaveProfile
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileSettingViewModel @Inject constructor(
    private val getUserUseCase: GetUserUseCase,
    private val updateUserUseCase: UpdateUserUseCase,
) : MVIViewModel<ProfileSettingIntent, ProfileSettingState, ProfileSettingEffect>() {

    override fun createInitialState(): ProfileSettingState = ProfileSettingState.Loading

    override suspend fun processIntent(intent: ProfileSettingIntent) {
        when (intent) {
            Initialize -> getProfile()
            is SaveProfile -> saveProfile(intent.name, intent.imageUrl)
        }
    }

    private suspend fun getProfile() {
        val user = getUserUseCase(Unit).get()
        setState {
            ProfileSettingState.Stable(
                name = user.name,
                imageUrl = user.profileImageUrl,
            )
        }
    }

    private suspend fun saveProfile(name: String, imageUrl: String) {
        val param = UpdateUserUseCase.Params(
            name = name.takeIf { it.isNotBlank() },
            profileImage = imageUrl.takeIf { it.isNotBlank() }
        )
        updateUserUseCase(param).onComplete {
            setEffect { ProfileSettingEffect.NavPopBack }
        }
    }

    fun openAlbum() {
        //TODO
    }

    fun resetProfileImage() {
        //TODO
    }
}
