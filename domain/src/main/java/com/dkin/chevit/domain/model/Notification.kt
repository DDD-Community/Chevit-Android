package com.dkin.chevit.domain.model

import com.dkin.chevit.domain.base.DomainModel

data class Notification(
    val id: Long,
    val subject: String,
    val text: String,
    val time: FormattedTime
) : DomainModel
