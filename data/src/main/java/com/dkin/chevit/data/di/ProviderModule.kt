package com.dkin.chevit.data.di

import com.dkin.chevit.data.provider.DeviceIdProviderImpl
import com.dkin.chevit.data.provider.TokenProviderImpl
import com.dkin.chevit.domain.provider.DeviceIdProvider
import com.dkin.chevit.domain.provider.TokenProvider
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal abstract class ProviderModule {
    @Binds
    abstract fun bindDeviceIdProvider(impl: DeviceIdProviderImpl): DeviceIdProvider

    @Binds
    abstract fun bindTokenProvider(impl: TokenProviderImpl): TokenProvider
}
