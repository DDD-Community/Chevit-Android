package com.dkin.chevit.data.di.usecase

import com.dkin.chevit.domain.base.CoroutineDispatcherProvider
import com.dkin.chevit.domain.repository.AuthRepository
import com.dkin.chevit.domain.repository.NotificationRepository
import com.dkin.chevit.domain.usecase.notification.GetNotificationSettingUseCase
import com.dkin.chevit.domain.usecase.notification.UpdateNotificationEnableStateUseCase
import com.dkin.chevit.domain.usecase.notification.UpdatePushTokenUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
internal object NotificationUseCaseModule {
    @Provides
    fun provideGetNotificationSettingUseCase(
        coroutineDispatcherProvider: CoroutineDispatcherProvider,
        authRepository: AuthRepository
    ) = GetNotificationSettingUseCase(
        coroutineDispatcherProvider,
        authRepository
    )

    @Provides
    fun provideUpdatePushTokenUseCase(
        coroutineDispatcherProvider: CoroutineDispatcherProvider,
        notificationRepository: NotificationRepository
    ) = UpdatePushTokenUseCase(
        coroutineDispatcherProvider,
        notificationRepository
    )

    @Provides
    fun provideUpdateNotificationEnableStateUseCase(
        coroutineDispatcherProvider: CoroutineDispatcherProvider,
        notificationRepository: NotificationRepository
    ) = UpdateNotificationEnableStateUseCase(
        coroutineDispatcherProvider,
        notificationRepository
    )
}
