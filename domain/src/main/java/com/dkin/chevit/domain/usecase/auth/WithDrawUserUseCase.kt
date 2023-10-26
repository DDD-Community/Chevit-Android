package com.dkin.chevit.domain.usecase.auth

import com.dkin.chevit.domain.base.CoroutineDispatcherProvider
import com.dkin.chevit.domain.base.IOUseCase
import com.dkin.chevit.domain.model.UserState
import com.dkin.chevit.domain.repository.AuthRepository

class WithDrawUserUseCase(
    coroutineDispatcherProvider: CoroutineDispatcherProvider,
    private val authRepository: AuthRepository
) : IOUseCase<Unit, UserState>(coroutineDispatcherProvider) {
    override suspend fun execute(params: Unit): UserState {
        return authRepository.withDrawUser()
    }
}
