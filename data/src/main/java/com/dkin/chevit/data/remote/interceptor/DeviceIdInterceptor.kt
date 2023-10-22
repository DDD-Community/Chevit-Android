package com.dkin.chevit.data.remote.interceptor

import com.dkin.chevit.domain.provider.DeviceIdProvider
import okhttp3.Interceptor
import okhttp3.Interceptor.Chain
import okhttp3.Response

class DeviceIdInterceptor(
    private val deviceIdProvider: DeviceIdProvider
) : Interceptor {
    override fun intercept(chain: Chain): Response {
        val request = chain.request()
            .newBuilder()
            .headers(
                chain.request().headers.newBuilder()
                    .add(HEADER_DEVICE_ID, deviceIdProvider.getDeviceId())
                    .build()
            )
            .build()

        return chain.proceed(request)
    }

    companion object {
        const val HEADER_DEVICE_ID = "Device-Id"
    }
}
