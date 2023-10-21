package com.dkin.chevit.data.repository

import com.dkin.chevit.data.model.request.SignUpPayload
import com.dkin.chevit.data.model.response.toUser
import com.dkin.chevit.data.remote.AuthAPI
import com.dkin.chevit.domain.model.UserState
import com.dkin.chevit.domain.provider.DeviceIdProvider
import com.dkin.chevit.domain.provider.TokenProvider
import com.dkin.chevit.domain.repository.AuthRepository
import javax.inject.Inject

internal class AuthRepositoryImpl @Inject constructor(
    private val authAPI: AuthAPI,
    private val deviceIdProvider: DeviceIdProvider,
    private val tokenProvider: TokenProvider
) : AuthRepository {
    override suspend fun getUserState(): UserState {
        return runCatching {
            val token = tokenProvider.getFirebaseToken().takeIf { it.isNotBlank() }
                ?: return UserState.Guest
            val response = authAPI.getUser(
                deviceId = deviceIdProvider.getDeviceId(),
                token = "Bearer $token",
            )
            response.toUser(token)
        }.getOrDefault(UserState.Guest)
    }

    override suspend fun signUpUser(name: String): UserState {
        return runCatching {
            val token = tokenProvider.getFirebaseToken().takeIf { it.isNotBlank() }
                ?: return UserState.Guest
            val payload = SignUpPayload(name = name)
            val response = authAPI.signUpUser(
                deviceId = deviceIdProvider.getDeviceId(),
                token = "Bearer $token",
                body = payload
            )
            response.toUser(token)
        }.getOrDefault(UserState.Guest)
    }
}
