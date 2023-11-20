package com.dkin.chevit.data.di.usecase

import com.dkin.chevit.domain.base.CoroutineDispatcherProvider
import com.dkin.chevit.domain.repository.AuthRepository
import com.dkin.chevit.domain.usecase.auth.GetUserStateUseCase
import com.dkin.chevit.domain.usecase.auth.GetUserUseCase
import com.dkin.chevit.domain.usecase.auth.SignOutUseCase
import com.dkin.chevit.domain.usecase.auth.SignUpUserUseCase
import com.dkin.chevit.domain.usecase.auth.WithDrawUserUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
internal object AuthUseCaseModule {
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

    @Provides
    fun provideSignOutUseCase(
        coroutineDispatcherProvider: CoroutineDispatcherProvider,
        authRepository: AuthRepository,
    ) = SignOutUseCase(
        coroutineDispatcherProvider,
        authRepository
    )

    @Provides
    fun provideDeleteUserUseCase(
        coroutineDispatcherProvider: CoroutineDispatcherProvider,
        authRepository: AuthRepository,
    ) = WithDrawUserUseCase(
        coroutineDispatcherProvider,
        authRepository
    )
}
