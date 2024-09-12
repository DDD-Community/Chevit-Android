package com.dkin.chevit.data.remote

import com.dkin.chevit.data.model.request.ProfileImageUploadPayload
import com.dkin.chevit.data.model.request.SignUpPayload
import com.dkin.chevit.data.model.request.UpdateUserPayload
import com.dkin.chevit.data.model.request.ValidationNicknamePayload
import com.dkin.chevit.data.model.response.ProfileImageUploadResponse
import com.dkin.chevit.data.model.response.UserResponse
import com.dkin.chevit.domain.base.None
import okhttp3.MultipartBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Part
import retrofit2.http.Url

/**
 * 유저 정보 및 인증 관련 API 모음
 */
internal interface AuthAPI {
    @GET("getUser")
    suspend fun getUser(): UserResponse

    @POST("signUpUser")
    suspend fun signUpUser(@Body body: SignUpPayload): UserResponse

    @PUT("updateUser")
    suspend fun updateUser(@Body body: UpdateUserPayload): UserResponse

    @POST("validationNickname")
    suspend fun validationNickname(@Body body: ValidationNicknamePayload)

    @DELETE("deleteUser")
    suspend fun deleteUser(): Response<Unit>

    @POST("getProfileUploadURL")
    suspend fun getProfileUploadURL(@Body body: ProfileImageUploadPayload): ProfileImageUploadResponse

    @Multipart
    @POST
    suspend fun uploadProfileImage(
        @Url url: String,
        @Part image: MultipartBody.Part
    ): None
}
