package com.dkin.chevit.data.model.response

import com.dkin.chevit.data.DataModel
import com.dkin.chevit.data.model.type.PlanTypeResponse
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class PlanResponse(
    @SerialName("planId") val planId: String,
    @SerialName("planType") val planTypeResponse: PlanTypeResponse,
    @SerialName("owner") val owner: OwnerResponse,
    @SerialName("isPublic") val isPublic: Boolean,
    @SerialName("createdTime") val createdTime: Long,
    @SerialName("categories") val categories: List<CategoryResponse>,
    @SerialName("schedule") val schedule: ScheduleResponse? = null,
    @SerialName("template") val template: TemplateResponse? = null
) : DataModel
