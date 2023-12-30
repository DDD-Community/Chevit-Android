package com.dkin.chevit.data.model.mapper

import com.dkin.chevit.data.model.response.PlanResponse
import com.dkin.chevit.domain.model.ColorType
import com.dkin.chevit.domain.model.Country
import com.dkin.chevit.domain.model.FormattedTime
import com.dkin.chevit.domain.model.Plan
import com.dkin.chevit.domain.model.Schedule
import com.dkin.chevit.domain.model.Template
import com.dkin.chevit.domain.model.TemplateDetail

internal object PlanMapper : Mapper<PlanResponse, Plan> {
    override fun mapDomain(input: PlanResponse): Plan = with(input) {
        Plan(
            id = planId,
            planType = PlanTypeMapper.mapDomain(planTypeResponse),
            owner = OwnerMapper.mapDomain(owner),
            isPublic = isPublic,
            createdTime = FormattedTimeMapper.mapDomain(createdTime),
            categoryList = categories.map(CategoryMapper::mapDomain),
            schedule = schedule?.let { ScheduleMapper.mapDomain(it) } ?: Schedule(
                backgroundImageUrl = "",
                country = Country(id = "", name = ""),
                startTime = FormattedTime(unixMillis = 0, formatted = ""),
                endTime = FormattedTime(unixMillis = 0, formatted = ""),
                isProgress = false
            )
        )
    }

    fun mapDomainTemplate(input: PlanResponse): Template = with(input) {
        Template(
            id = planId,
            planType = PlanTypeMapper.mapDomain(planTypeResponse),
            owner = OwnerMapper.mapDomain(owner),
            isPublic = isPublic,
            createdTime = FormattedTimeMapper.mapDomain(createdTime),
            categoryList = categories.map(CategoryMapper::mapDomain),
            template = template?.let { TemplateMapper.mapDomain(it) } ?: TemplateDetail(
                colorType = ColorType.DAWN, subject = ""
            )
        )
    }
}
