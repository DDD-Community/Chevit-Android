package com.dkin.chevit.data.model.response

import com.dkin.chevit.data.DataModel
import com.dkin.chevit.data.model.type.CategoryIconTypeResponse
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class CategoryResponse(
    @SerialName("categoryId") val id: String,
    @SerialName("icon") val icon: CategoryIconTypeResponse,
    @SerialName("subject") val subject: String,
    @SerialName("createdTime") val createdTime: Long,
    @SerialName("checkedCount") val checkedCount: Int,
    @SerialName("checkList") val checkList: List<CheckItemResponse>,
) : DataModel
