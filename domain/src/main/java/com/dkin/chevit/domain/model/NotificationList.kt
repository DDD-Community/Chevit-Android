package com.dkin.chevit.domain.model

import com.dkin.chevit.domain.base.DomainModel

data class NotificationList(
    val list: List<NotificationListItem>
) : DomainModel {
    data class NotificationListItem(
        val id: Long,
        val subject: String,
        val text: String,
        val time: FormattedTime
    )
}
