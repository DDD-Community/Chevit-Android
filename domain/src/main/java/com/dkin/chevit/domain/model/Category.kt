package com.dkin.chevit.domain.model

import com.dkin.chevit.domain.base.DomainModel

data class Category(
    val id: String,
    val icon: CategoryIconType,
    val subject: String,
    val createdTime: FormattedTime,
    val checkedCount: Int,
    val checkList: List<CheckItem>
) : DomainModel
