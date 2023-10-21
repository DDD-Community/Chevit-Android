package com.dkin.chevit.data.datastore

import androidx.datastore.core.DataStore
import com.dkin.chevit.data.proto.DeviceInfo
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.flow.first

@Singleton
internal class DeviceDataStore @Inject constructor(
    private val datastore: DataStore<DeviceInfo>,
) {
    suspend fun getDeviceInfo(): DeviceInfo {
        return datastore.data.first()
    }

    suspend fun updateDeviceInfo(deviceInfo: DeviceInfo) {
        datastore.updateData { deviceInfo }
    }
}
