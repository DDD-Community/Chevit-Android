package com.dkin.chevit.data.di

import com.dkin.chevit.data.repository.AuthRepositoryImpl
import com.dkin.chevit.data.repository.NotificationRepositoryImpl
import com.dkin.chevit.data.repository.PlanRepositoryImpl
import com.dkin.chevit.data.repository.ServiceRepositoryImpl
import com.dkin.chevit.domain.repository.AuthRepository
import com.dkin.chevit.domain.repository.NotificationRepository
import com.dkin.chevit.domain.repository.PlanRepository
import com.dkin.chevit.domain.repository.ServiceRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal abstract class RepositoryModule {
    @Binds
    abstract fun bindAuthRepository(
        impl: AuthRepositoryImpl
    ): AuthRepository

    @Binds
    abstract fun bindNotificationRepository(
        impl: NotificationRepositoryImpl
    ): NotificationRepository

    @Binds
    abstract fun bindServiceRepository(
        impl: ServiceRepositoryImpl
    ): ServiceRepository

    @Binds
    abstract fun bindPlanRepository(
        impl: PlanRepositoryImpl
    ): PlanRepository
}
