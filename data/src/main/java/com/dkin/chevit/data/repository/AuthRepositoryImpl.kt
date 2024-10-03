package com.dkin.chevit.data.repository

import com.dkin.chevit.data.model.request.ProfileImageUploadPayload
import com.dkin.chevit.data.model.request.SignUpPayload
import com.dkin.chevit.data.model.request.UpdateUserPayload
import com.dkin.chevit.data.model.response.toUser
import com.dkin.chevit.data.remote.AuthAPI
import com.dkin.chevit.data.remote.ImageAPI
import com.dkin.chevit.domain.base.None
import com.dkin.chevit.domain.model.ProfileImageData
import com.dkin.chevit.domain.model.UserState
import com.dkin.chevit.domain.repository.AuthRepository
import com.google.firebase.auth.FirebaseAuth
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import java.io.File
import javax.inject.Inject

internal class AuthRepositoryImpl @Inject constructor(
    private val authAPI: AuthAPI,
    private val imageAPI: ImageAPI,
    private val auth: FirebaseAuth,
) : AuthRepository {
    override suspend fun getUserState(): UserState {
        return runCatching {
            authAPI.getUser().toUser()
        }.getOrDefault(UserState.Guest)
    }

    override suspend fun signUpUser(name: String): UserState {
        return runCatching {
            val payload = SignUpPayload(name = name)
            authAPI.signUpUser(body = payload).toUser()
        }.getOrDefault(UserState.Guest)
    }

    override suspend fun updateUser(name: String?, profileImage: String?): UserState {
        return runCatching {
            val payload = UpdateUserPayload(name = name, profileImage = profileImage)
            authAPI.updateUser(body = payload).toUser()
        }.getOrDefault(UserState.Guest)
    }

    override suspend fun signOutUser(): UserState {
        auth.signOut()
        return getUserState()
    }

    override suspend fun withDrawUser(): UserState {
        authAPI.deleteUser()
        auth.signOut()
        return getUserState()
    }

    override suspend fun getProfileUploadURL(fileSize: Int): ProfileImageData {
        val result = authAPI.getProfileUploadURL(
            ProfileImageUploadPayload(
                fileSize = fileSize,
                mimeType = "image/jpeg"
            )
        )
        return ProfileImageData(
            uploadMethod = result.uploadMethod,
            uploadURL = result.uploadURL,
            uploadHeaders = "{\"Content-Type\": [\"image/jpeg\"]}",
            imageURL = result.imageURL,
        )
    }

    override suspend fun uploadProfileImage(
        uploadURL: String,
        uploadMethod: String,
        uploadHeaders: String,
        file: File
    ) {
        val requestFile: RequestBody = file.asRequestBody("image/jpeg".toMediaTypeOrNull())
        return imageAPI.uploadProfileImage(uploadURL, requestFile)
    }
}
