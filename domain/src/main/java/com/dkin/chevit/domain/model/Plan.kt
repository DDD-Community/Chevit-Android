package com.dkin.chevit.domain.model

import com.dkin.chevit.domain.base.DomainModel

data class Plan(
    val id: String,
    val planType: PlanType,
    val owner: UserState.User,
    val isPublic: Boolean,
    val createdTime: FormattedTime,
    val categoryList: List<Category>,
    val schedule: Schedule
) : DomainModel
