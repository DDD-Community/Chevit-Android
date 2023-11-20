package com.dkin.chevit.data.model.mapper

import com.dkin.chevit.data.model.response.NotificationResponse
import com.dkin.chevit.domain.model.Notification

internal object NotificationMapper : Mapper<NotificationResponse, Notification> {
    override fun mapDomain(input: NotificationResponse): Notification = with(input) {
        Notification(
            id = id,
            subject = subject,
            text = text,
            time = FormattedTimeMapper.mapDomain(createTime)
        )
    }
}
