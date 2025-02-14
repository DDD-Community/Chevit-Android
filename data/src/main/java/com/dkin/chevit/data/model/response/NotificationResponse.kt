package com.dkin.chevit.data.model.response

import com.dkin.chevit.data.DataModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class NotificationResponse(
    @SerialName("list") val list: List<NotificationItemResponse>,
) : DataModel

@Serializable
data class NotificationItemResponse(
    @SerialName("notificationId") val id: Long,
    @SerialName("subject") val subject: String,
    @SerialName("text") val text: String,
    @SerialName("createTime") val createTime: Long
) : DataModel