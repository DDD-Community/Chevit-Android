package com.dkin.chevit.presentation.home.contents.user.profile

import com.dkin.chevit.core.mvi.MVIViewModel
import com.dkin.chevit.domain.base.get
import com.dkin.chevit.domain.usecase.auth.GetUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileSettingViewModel @Inject constructor(
    private val getUserUseCase: GetUserUseCase,
) :
    MVIViewModel<ProfileSettingIntent, ProfileSettingState, ProfileSettingEffect>() {

    override fun createInitialState(): ProfileSettingState = ProfileSettingState.Loading

    override suspend fun processIntent(intent: ProfileSettingIntent) {
        when (intent) {
            ProfileSettingIntent.Initialize -> getProfile()
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

    fun saveProfile(name: String, imageUrl: String) {
        //TODO
    }

    fun openAlbum() {
        //TODO
    }

    fun resetProfileImage() {
        //TODO
    }
}