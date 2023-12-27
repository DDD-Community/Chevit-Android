package com.dkin.chevit.domain.usecase.auth

import com.dkin.chevit.domain.base.CoroutineDispatcherProvider
import com.dkin.chevit.domain.base.IOUseCase
import com.dkin.chevit.domain.model.UserState
import com.dkin.chevit.domain.repository.AuthRepository
import com.dkin.chevit.domain.usecase.auth.UpdateUserUseCase.Params

class UpdateUserUseCase(
    coroutineDispatcherProvider: CoroutineDispatcherProvider,
    private val authRepository: AuthRepository
) : IOUseCase<Params, UserState>(coroutineDispatcherProvider) {

    override suspend fun execute(params: Params): UserState {
        return authRepository.updateUser(params.name, params.profileImage)
    }

    data class Params(
        val name: String?,
        val profileImage: String?
    )
}
