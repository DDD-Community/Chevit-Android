package com.dkin.chevit.domain.model

import com.dkin.chevit.domain.base.DomainModel

data class Schedule(
    val backgroundImageUrl: String,
    val country: Country,
    val startTime: FormattedTime,
    val endTime: FormattedTime
) : DomainModel
