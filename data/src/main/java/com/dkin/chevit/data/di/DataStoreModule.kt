package com.dkin.chevit.data.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.DataStoreFactory
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler
import androidx.datastore.dataStoreFile
import com.dkin.chevit.data.proto.DeviceInfo
import com.dkin.chevit.data.proto.DeviceInfoSerializer
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object DataStoreModule {
    @Singleton
    @Provides
    fun provideDeviceInfoDataStore(
        @ApplicationContext context: Context,
    ): DataStore<DeviceInfo> {
        return DataStoreFactory.create(
            serializer = DeviceInfoSerializer(),
            corruptionHandler =
            ReplaceFileCorruptionHandler {
                DeviceInfo.getDefaultInstance()
            },
            produceFile = {
                context.dataStoreFile("device.pb")
            },
        )
    }
}
