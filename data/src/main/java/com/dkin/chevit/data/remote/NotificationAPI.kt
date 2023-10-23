package com.dkin.chevit.data.remote

import com.dkin.chevit.data.model.request.NotificationSettingUpdatePayload
import com.dkin.chevit.data.model.response.NotificationSettingResponse
import retrofit2.http.Body
import retrofit2.http.PUT

/**
 * 알림 관련 API 모음
 */
internal interface NotificationAPI {
    @PUT("updatePushToken")
    suspend fun updatePushToken(
        @Body body: NotificationSettingUpdatePayload
    )

    @PUT("updateNotification")
    suspend fun updateNotification(
        @Body body: NotificationSettingUpdatePayload
    ): NotificationSettingResponse
}
