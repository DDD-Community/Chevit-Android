package com.dkin.chevit.domain.model

import com.dkin.chevit.domain.base.DomainModel

data class CheckItem(
    val id: String,
    val content: String,
    val memo: String,
    val quantity: Int,
    val createdTime: FormattedTime,
    val checked: Boolean
) : DomainModel
