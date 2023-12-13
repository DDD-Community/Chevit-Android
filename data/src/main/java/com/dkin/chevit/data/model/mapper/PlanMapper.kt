package com.dkin.chevit.data.model.mapper

import com.dkin.chevit.data.model.response.PlanResponse
import com.dkin.chevit.domain.model.Plan

internal object PlanMapper : Mapper<PlanResponse, Plan> {
    override fun mapDomain(input: PlanResponse): Plan = with(input) {
        Plan(
            id = planId,
            planType = PlanTypeMapper.mapDomain(planTypeResponse),
            owner = OwnerMapper.mapDomain(owner),
            isPublic = isPublic,
            createdTime = FormattedTimeMapper.mapDomain(createdTime),
            categoryList = categories.map(CategoryMapper::mapDomain),
            schedule = ScheduleMapper.mapDomain(schedule)
        )
    }
}
