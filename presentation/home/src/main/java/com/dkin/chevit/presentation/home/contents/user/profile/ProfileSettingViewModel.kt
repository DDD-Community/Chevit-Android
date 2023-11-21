package com.dkin.chevit.presentation.home.contents.user.profile

import com.dkin.chevit.core.mvi.MVIViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileSettingViewModel @Inject constructor() :
    MVIViewModel<ProfileSettingIntent, ProfileSettingState, ProfileSettingEffect>() {

    override fun createInitialState(): ProfileSettingState = ProfileSettingState.dummy()

    override suspend fun processIntent(intent: ProfileSettingIntent) {
        when (intent) {
            else -> {}
        }
    }

    fun getProfile() {
        //TODO Init
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