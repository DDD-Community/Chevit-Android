package com.dkin.chevit.data.di.usecase

import com.dkin.chevit.domain.base.CoroutineDispatcherProvider
import com.dkin.chevit.domain.repository.ServiceRepository
import com.dkin.chevit.domain.usecase.service.GetAppInfoUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
internal object ServiceUseCaseModule {
    @Provides
    fun provideGetAppInfoUseCase(
        coroutineDispatcherProvider: CoroutineDispatcherProvider,
        serviceRepository: ServiceRepository
    ) = GetAppInfoUseCase(
        coroutineDispatcherProvider,
        serviceRepository
    )
}
