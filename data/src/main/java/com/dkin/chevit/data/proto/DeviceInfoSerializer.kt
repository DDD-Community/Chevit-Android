package com.dkin.chevit.data.proto

import androidx.datastore.core.CorruptionException
import androidx.datastore.core.Serializer
import java.io.InputStream
import java.io.OutputStream

internal class DeviceInfoSerializer : Serializer<DeviceInfo> {
    override val defaultValue: DeviceInfo = DeviceInfo.getDefaultInstance()

    override suspend fun readFrom(input: InputStream): DeviceInfo {
        return kotlin.runCatching {
            DeviceInfo.parseFrom(input)
        }.onFailure {
            throw CorruptionException("Cannot parseFrom.", it)
        }.getOrThrow()
    }

    override suspend fun writeTo(
        t: DeviceInfo,
        output: OutputStream,
    ) {
        t.writeTo(output)
    }
}
