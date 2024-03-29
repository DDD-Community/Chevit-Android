package com.dkin.chevit.domain.repository

import com.dkin.chevit.domain.model.UserState

interface AuthRepository {
    suspend fun getUserState(): UserState

    suspend fun signUpUser(name: String): UserState

    suspend fun updateUser(name: String?, profileImage: String?): UserState

    suspend fun signOutUser(): UserState

    suspend fun withDrawUser(): UserState
}
