package com.dkin.chevit.presentation.home.contents.user.profile

import androidx.core.net.toUri
import androidx.lifecycle.viewModelScope
import com.dkin.chevit.core.mvi.MVIViewModel
import com.dkin.chevit.domain.base.get
import com.dkin.chevit.domain.base.onComplete
import com.dkin.chevit.domain.usecase.auth.GetProfileImageDataUseCase
import com.dkin.chevit.domain.usecase.auth.GetUserUseCase
import com.dkin.chevit.domain.usecase.auth.UpdateUserUseCase
import com.dkin.chevit.domain.usecase.auth.UploadProfileImageUseCase
import com.dkin.chevit.presentation.home.contents.user.profile.ProfileSettingIntent.Initialize
import com.dkin.chevit.presentation.home.contents.user.profile.ProfileSettingIntent.SaveProfile
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.io.File
import javax.inject.Inject

@HiltViewModel
class ProfileSettingViewModel @Inject constructor(
    private val getUserUseCase: GetUserUseCase,
    private val updateUserUseCase: UpdateUserUseCase,
    private val getProfileImageDataUseCase: GetProfileImageDataUseCase,
    private val uploadProfileImageUseCase: UploadProfileImageUseCase
) : MVIViewModel<ProfileSettingIntent, ProfileSettingState, ProfileSettingEffect>() {

    override fun createInitialState(): ProfileSettingState = ProfileSettingState.Loading

    override suspend fun processIntent(intent: ProfileSettingIntent) {
        when (intent) {
            Initialize -> getProfile()
            is SaveProfile -> saveProfile(intent.name, intent.imageUrl, intent.isNewImage)
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

    private suspend fun saveProfile(name: String, imageUrl: String, isNewImage: Boolean) {
        if (isNewImage) {
            kotlin.runCatching {
                val imageUri = imageUrl.toUri()
                val filePath = imageUri.path ?: ""
                val imageFile = File(filePath)
                getProfileImageDataUseCase(
                    params = GetProfileImageDataUseCase.Param(
                        fileSize = imageFile.length().toInt()
                    )
                ).onComplete {
                    saveImageWithUpdateProfile(
                        name = name,
                        imageUrl = imageUrl,
                        newImageUrl = imageURL,
                        uploadURL = uploadURL,
                        uploadMethod = uploadMethod,
                        uploadHeaders = uploadHeaders,
                        file = imageFile
                    )
                }
            }.onFailure {
                updateProfile(name, imageUrl)
            }
        } else {
            updateProfile(name, imageUrl)
        }
    }

    private suspend fun updateProfile(name: String, imageUrl: String) {
        val param = UpdateUserUseCase.Params(
            name = name.takeIf { it.isNotBlank() },
            profileImage = imageUrl.takeIf { it.isNotBlank() }
        )
        updateUserUseCase(param).onComplete {
            setEffect { ProfileSettingEffect.NavPopBack }
        }
    }

    private fun saveImageWithUpdateProfile(
        name: String,
        imageUrl: String,
        file: File,
        newImageUrl: String,
        uploadURL: String,
        uploadMethod: String,
        uploadHeaders: String
    ) {
        viewModelScope.launch {
            kotlin.runCatching {
                uploadProfileImageUseCase(
                    params = UploadProfileImageUseCase.Param(
                        uploadURL = uploadURL,
                        uploadMethod = uploadMethod,
                        uploadHeaders = uploadHeaders,
                        file = file
                    )
                )
            }.onSuccess {
                updateProfile(name, newImageUrl)
            }.onFailure {
                updateProfile(name, imageUrl)
            }
        }

    }
}
