package com.dkin.chevit.data.repository

import com.dkin.chevit.data.model.request.NotificationSettingUpdatePayload
import com.dkin.chevit.data.model.response.toNotificationSetting
import com.dkin.chevit.data.remote.NotificationAPI
import com.dkin.chevit.domain.base.None
import com.dkin.chevit.domain.model.NotificationSetting
import com.dkin.chevit.domain.repository.NotificationRepository
import javax.inject.Inject

internal class NotificationRepositoryImpl @Inject constructor(
    private val notificationAPI: NotificationAPI
) : NotificationRepository {
    override suspend fun updatePushToken(token: String): None {
        val payload = NotificationSettingUpdatePayload(pushToken = token)
        notificationAPI.updatePushToken(body = payload)
        return None
    }

    override suspend fun updateNotificationPushEnabled(
        notificationEnabled: Boolean
    ): NotificationSetting {
        val payload = NotificationSettingUpdatePayload(notificationEnabled = notificationEnabled)
        return notificationAPI.updateNotification(body = payload).toNotificationSetting()
    }
}
