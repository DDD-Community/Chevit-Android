package com.dkin.chevit.data.di.usecase

import com.dkin.chevit.domain.base.CoroutineDispatcherProvider
import com.dkin.chevit.domain.repository.AuthRepository
import com.dkin.chevit.domain.usecase.GetUserStateUseCase
import com.dkin.chevit.domain.usecase.GetUserUseCase
import com.dkin.chevit.domain.usecase.SignUpUserUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
internal object AuthUseCase {
    @Provides
    fun provideGetUserStateUseCase(
        coroutineDispatcherProvider: CoroutineDispatcherProvider,
        authRepository: AuthRepository,
    ) = GetUserStateUseCase(
        coroutineDispatcherProvider,
        authRepository,
    )

    @Provides
    fun provideGetUserUseCase(
        coroutineDispatcherProvider: CoroutineDispatcherProvider,
        authRepository: AuthRepository,
    ) = GetUserUseCase(
        coroutineDispatcherProvider,
        authRepository,
    )

    @Provides
    fun provideSignUpUserUseCase(
        coroutineDispatcherProvider: CoroutineDispatcherProvider,
        authRepository: AuthRepository,
    ) = SignUpUserUseCase(
        coroutineDispatcherProvider,
        authRepository
    )
}
