package com.dkin.chevit.data.di

import com.dkin.chevit.data.BuildConfig
import com.dkin.chevit.data.di.annotation.JsonConverter
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object NetworkModule {
    private val jsonConverter by lazy {
        val json =
            Json {
                isLenient = true
                coerceInputValues = true
                ignoreUnknownKeys = true
            }
        json.asConverterFactory("application/json".toMediaType())
    }

    @JsonConverter
    @Provides
    @Singleton
    fun provideJsonConverter(): Converter.Factory = jsonConverter

    @Provides
    @Singleton
    fun provideDeviceIdInterceptor(
        deviceIdProvider: DeviceIdProvider
    ) = DeviceIdInterceptor(deviceIdProvider)

    @Provides
    @Singleton
    fun provideTokenInterceptor(
        tokenProvider: TokenProvider
    ) = TokenInterceptor(tokenProvider)

    @Provides
    @Singleton
    fun provideOkHttpClient(
        deviceIdInterceptor: DeviceIdInterceptor,
        tokenInterceptor: TokenInterceptor,
    ) = OkHttpClient.Builder()
        .connectTimeout(20, TimeUnit.SECONDS)
        .readTimeout(20, TimeUnit.SECONDS)
        .writeTimeout(20, TimeUnit.SECONDS)
        .addInterceptor(deviceIdInterceptor)
        .addInterceptor(tokenInterceptor)
        .build()

    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        @JsonConverter jsonConverter: Converter.Factory,
    ): Retrofit = Retrofit.Builder()
            .client(okHttpClient)
            .addConverterFactory(jsonConverter)
            .baseUrl(BuildConfig.API_URL)
            .build()
}
