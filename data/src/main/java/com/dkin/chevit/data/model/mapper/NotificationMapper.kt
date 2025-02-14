package com.dkin.chevit.data.model.mapper

import com.dkin.chevit.data.model.response.NotificationResponse
import com.dkin.chevit.domain.model.NotificationList

internal object NotificationMapper : Mapper<NotificationResponse, NotificationList> {
    override fun mapDomain(input: NotificationResponse): NotificationList = with(input) {
        NotificationList(
            list = list.map {
                NotificationList.NotificationListItem(
                    id = it.id,
                    subject = it.subject,
                    text = it.text,
                    time = FormattedTimeMapper.mapDomain(it.createTime)
                )
            }
        )
    }
}
