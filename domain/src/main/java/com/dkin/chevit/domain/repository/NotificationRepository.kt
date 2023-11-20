package com.dkin.chevit.domain.repository

import com.dkin.chevit.domain.base.DomainListModel
import com.dkin.chevit.domain.base.None
import com.dkin.chevit.domain.model.Notification
import com.dkin.chevit.domain.model.NotificationSetting

interface NotificationRepository {
    suspend fun updatePushToken(token: String): None
    suspend fun updateNotificationPushEnabled(notificationEnabled: Boolean): NotificationSetting
    suspend fun fetchNotificationList(): DomainListModel<Notification>
}
