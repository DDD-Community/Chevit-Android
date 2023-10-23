package com.dkin.chevit.domain.usecase.auth

import com.dkin.chevit.domain.base.CoroutineDispatcherProvider
import com.dkin.chevit.domain.base.IOUseCase
import com.dkin.chevit.domain.model.UserState.User
import com.dkin.chevit.domain.repository.AuthRepository

class GetUserUseCase(
    coroutineDispatcherProvider: CoroutineDispatcherProvider,
    private val authRepository: AuthRepository
) : IOUseCase<Unit, User>(coroutineDispatcherProvider = coroutineDispatcherProvider) {
    override suspend fun execute(params: Unit): User {
        val user = authRepository.getUserState()
        require(user is User) {
            "유저 정보를 불러올 수 없습니다."
        }
        return user
    }
}
