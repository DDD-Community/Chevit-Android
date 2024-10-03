package com.dkin.chevit.domain.repository

import com.dkin.chevit.domain.base.None
import com.dkin.chevit.domain.model.ProfileImageData
import com.dkin.chevit.domain.model.UserState
import java.io.File

interface AuthRepository {
    suspend fun getUserState(): UserState

    suspend fun signUpUser(name: String): UserState

    suspend fun updateUser(name: String?, profileImage: String?): UserState

    suspend fun signOutUser(): UserState

    suspend fun withDrawUser(): UserState

    suspend fun getProfileUploadURL(fileSize: Int): ProfileImageData

    suspend fun uploadProfileImage(uploadURL: String, uploadMethod: String, uploadHeaders: String, file: File)
}
