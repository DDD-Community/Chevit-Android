package com.dkin.chevit.data.repository

import com.dkin.chevit.data.model.mapper.NotificationMapper
import com.dkin.chevit.data.model.request.NotificationSettingUpdatePayload
import com.dkin.chevit.data.model.response.toNotificationSetting
import com.dkin.chevit.data.remote.NotificationAPI
import com.dkin.chevit.domain.base.None
import com.dkin.chevit.domain.model.NotificationList
import com.dkin.chevit.domain.model.NotificationSetting
import com.dkin.chevit.domain.repository.NotificationRepository
import com.google.firebase.messaging.FirebaseMessaging
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

internal class NotificationRepositoryImpl @Inject constructor(
    private val notificationAPI: NotificationAPI,
    private val firebaseMessaging: FirebaseMessaging
) : NotificationRepository {
    override suspend fun getPushToken(): String {
        return runCatching { firebaseMessaging.token.await() }.getOrDefault("")
    }

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

    override suspend fun fetchNotificationList(): NotificationList {
        return notificationAPI.fetchNotificationList().let(NotificationMapper::mapDomain)
    }
}
