package com.dkin.chevit.data.model.request

import com.dkin.chevit.data.DataModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class NotificationSettingUpdatePayload(
    @SerialName("pushToken") val pushToken: String? = null,
    @SerialName("isNotificationAllowed") val notificationEnabled: Boolean? = null
) : DataModel
