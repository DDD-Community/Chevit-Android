package com.dkin.chevit.data.di

import com.dkin.chevit.data.remote.AuthAPI
import com.dkin.chevit.data.remote.NotificationAPI
import com.dkin.chevit.data.remote.PlanAPI
import com.dkin.chevit.data.remote.ServiceAPI
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

    @Provides
    @Singleton
    fun provideServiceAPI(
        retrofit: Retrofit
    ): ServiceAPI = retrofit.create(ServiceAPI::class.java)

    @Provides
    @Singleton
    fun providePlanAPI(
        retrofit: Retrofit
    ): PlanAPI = retrofit.create(PlanAPI::class.java)
}
