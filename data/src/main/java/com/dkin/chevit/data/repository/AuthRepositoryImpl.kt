package com.dkin.chevit.data.repository

import com.dkin.chevit.data.model.request.SignUpPayload
import com.dkin.chevit.data.model.response.toUser
import com.dkin.chevit.data.remote.AuthAPI
import com.dkin.chevit.domain.model.UserState
import com.dkin.chevit.domain.repository.AuthRepository
import com.google.firebase.auth.FirebaseAuth
import javax.inject.Inject

internal class AuthRepositoryImpl @Inject constructor(
    private val authAPI: AuthAPI,
    private val auth: FirebaseAuth
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

    override suspend fun signOutUser(): UserState {
        auth.signOut()
        return getUserState()
    }
}
