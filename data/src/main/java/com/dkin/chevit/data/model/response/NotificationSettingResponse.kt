package com.dkin.chevit.data.model.response

import com.dkin.chevit.data.DataModel
import com.dkin.chevit.domain.model.NotificationSetting
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class NotificationSettingResponse(
    @SerialName("isNotificationAllowed") val notificationEnabled: Boolean
) : DataModel

internal fun NotificationSettingResponse.toNotificationSetting() = NotificationSetting(
    notificationEnabled = notificationEnabled
)
