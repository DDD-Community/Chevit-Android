package com.dkin.chevit.data.remote

import com.dkin.chevit.data.model.response.AppInfoResponse
import retrofit2.http.GET

/**
 * 서비스 관련 API 모음
 */
internal interface ServiceAPI {
    @GET("appInfo")
    suspend fun getAppInfo(): AppInfoResponse
}
