package com.dkin.chevit.data.remote

import com.dkin.chevit.data.model.request.SignUpPayload
import com.dkin.chevit.data.model.request.ValidationNicknamePayload
import com.dkin.chevit.data.model.response.UserResponse
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

/**
 * 유저 정보 및 인증 관련 API 모음
 */
internal interface AuthAPI {
    @GET("getUser")
    suspend fun getUser(
        @Header("Device-Id") deviceId: String,
        @Header("Authorization") token: String,
    ): UserResponse

    @POST("signUpUser")
    suspend fun signUpUser(
        @Header("Device-Id") deviceId: String,
        @Header("Authorization") token: String,
        @Body body: SignUpPayload
    ): UserResponse

    @POST("validationNickname")
    suspend fun validationNickname(
        @Body body: ValidationNicknamePayload,
    )

    @DELETE("deleteUser")
    suspend fun deleteUser()
}
