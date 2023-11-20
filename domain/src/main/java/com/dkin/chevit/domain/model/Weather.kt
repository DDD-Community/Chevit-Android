package com.dkin.chevit.domain.model

import com.dkin.chevit.domain.base.DomainModel

data class Weather(
    val formattedTime: FormattedTime,
    val iconUrl: String,
    val temperature: String
) : DomainModel
