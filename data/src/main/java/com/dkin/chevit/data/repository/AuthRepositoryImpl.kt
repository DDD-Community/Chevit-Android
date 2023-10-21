package com.dkin.chevit.data.repository

import com.dkin.chevit.data.model.response.GenderResponse.FEMALE
import com.dkin.chevit.data.model.response.GenderResponse.MALE
import com.dkin.chevit.data.remote.AuthAPI
import com.dkin.chevit.domain.model.Gender
import com.dkin.chevit.domain.model.UserState
import com.dkin.chevit.domain.provider.DeviceIdProvider
import com.dkin.chevit.domain.repository.AuthRepository
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.suspendCancellableCoroutine
import javax.inject.Inject
import kotlin.coroutines.resume

internal class AuthRepositoryImpl
    @Inject
    constructor(
        private val auth: FirebaseAuth,
        private val authAPI: AuthAPI,
        private val deviceIdProvider: DeviceIdProvider,
    ) : AuthRepository {
        override suspend fun getUserState(): UserState {
            return runCatching {
                val token = getIdToken().takeIf { it.isNotBlank() } ?: return UserState.Guest
                val userResponse =
                    authAPI.getUser(
                        deviceId = deviceIdProvider.getDeviceId(),
                        token = "Bearer $token",
                    )
                if (userResponse.needSignUp) {
                    UserState.NotRegister(token = token)
                } else {
                    UserState.User(
                        token = token,
                        id = userResponse.id,
                        name = userResponse.name,
                        gender =
                            when (userResponse.gender) {
                                FEMALE -> Gender.FEMALE
                                MALE -> Gender.MALE
                            },
                        birthYear = "${userResponse.birthYear}",
                        profileImageUrl = userResponse.profileImageUrl,
                    )
                }
            }.getOrDefault(UserState.Guest)
        }

        private suspend fun getIdToken(): String =
            suspendCancellableCoroutine { continuation ->
                val currentUser = auth.currentUser
                if (currentUser != null) {
                    currentUser.getIdToken(true)
                        .addOnCompleteListener { task ->
                            if (task.isSuccessful) {
                                val token = task.result?.token
                                continuation.resume(token ?: "")
                            } else {
                                continuation.resume("")
                            }
                        }
                } else {
                    continuation.resume("")
                }
            }
    }
