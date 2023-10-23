package com.dkin.chevit.data.di

import com.dkin.chevit.data.remote.AuthAPI
import com.dkin.chevit.data.remote.NotificationAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
internal object RetrofitModule {
    @Provides
    @Singleton
    fun provideAuthAPI(
        retrofit: Retrofit
    ): AuthAPI = retrofit.create(AuthAPI::class.java)

    @Provides
    @Singleton
    fun provideNotificationAPI(
        retrofit: Retrofit
    ): NotificationAPI = retrofit.create(NotificationAPI::class.java)
}
