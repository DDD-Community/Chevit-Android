package com.dkin.chevit.data.remote.interceptor

import com.dkin.chevit.domain.provider.TokenProvider
import okhttp3.Interceptor
import okhttp3.Interceptor.Chain
import okhttp3.Response

class TokenInterceptor(
    private val tokenProvider: TokenProvider
) : Interceptor {
    override fun intercept(chain: Chain): Response {
        val request = chain.request()
            .newBuilder()
            .headers(
                chain.request().headers.newBuilder()
                    .add(HEADER_FIREBASE_TOKEN, "Bearer ${tokenProvider.getFirebaseToken()}")
                    .build()
            )
            .build()

        return chain.proceed(request)
    }

    companion object {
        const val HEADER_FIREBASE_TOKEN = "Authorization"
    }
}
