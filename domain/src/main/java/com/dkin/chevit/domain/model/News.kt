package com.dkin.chevit.domain.model

import com.dkin.chevit.domain.base.DomainModel

data class News(
    val title: String,
    val webUrl: String
) : DomainModel
