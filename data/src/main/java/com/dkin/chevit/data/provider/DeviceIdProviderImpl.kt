package com.dkin.chevit.data.provider

import com.dkin.chevit.data.datastore.DeviceDataStore
import com.dkin.chevit.data.proto.DeviceInfo
import com.dkin.chevit.domain.base.CoroutineDispatcherProvider
import com.dkin.chevit.domain.provider.DeviceIdProvider
import kotlinx.coroutines.runBlocking
import java.util.UUID
import javax.inject.Inject

internal class DeviceIdProviderImpl
    @Inject
    constructor(
        private val coroutineDispatcherProvider: CoroutineDispatcherProvider,
        private val deviceDataStore: DeviceDataStore,
    ) : DeviceIdProvider {
        override fun getDeviceId(): String =
            runBlocking(coroutineDispatcherProvider.io) {
                val deviceInfo = deviceDataStore.getDeviceInfo()
                val uuid =
                    if (deviceInfo == DeviceInfo.getDefaultInstance()) {
                        UUID.randomUUID().toString()
                    } else {
                        deviceInfo.deviceId
                    }
                val newDeviceInfo =
                    deviceInfo.toBuilder()
                        .setDeviceId(uuid)
                        .build()
                deviceDataStore.updateDeviceInfo(newDeviceInfo)
                return@runBlocking uuid
            }
    }
