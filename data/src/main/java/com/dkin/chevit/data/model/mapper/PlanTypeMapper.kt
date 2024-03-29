package com.dkin.chevit.data.model.mapper

import com.dkin.chevit.data.model.type.PlanTypeResponse.SCHEDULE
import com.dkin.chevit.data.model.type.PlanTypeResponse.TEMPLATE
import com.dkin.chevit.domain.model.PlanType

internal object PlanTypeMapper : Mapper<com.dkin.chevit.data.model.type.PlanTypeResponse, PlanType> {
    override fun mapDomain(input: com.dkin.chevit.data.model.type.PlanTypeResponse): PlanType = when (input) {
        SCHEDULE -> PlanType.SCHEDULE
        TEMPLATE -> PlanType.TEMPLATE
    }
}
