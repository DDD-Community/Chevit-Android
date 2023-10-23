package com.dkin.chevit.domain.usecase.auth

import com.dkin.chevit.domain.base.CoroutineDispatcherProvider
import com.dkin.chevit.domain.base.IOUseCase
import com.dkin.chevit.domain.model.UserState
import com.dkin.chevit.domain.repository.AuthRepository
import com.dkin.chevit.domain.usecase.auth.SignUpUserUseCase.Param

class SignUpUserUseCase(
    coroutineDispatcherProvider: CoroutineDispatcherProvider,
    private val authRepository: AuthRepository,
) : IOUseCase<Param, UserState>(coroutineDispatcherProvider) {
    override suspend fun execute(params: Param): UserState {
        return authRepository.signUpUser(params.name)
    }

    @JvmInline
    value class Param(val name: String)
}
