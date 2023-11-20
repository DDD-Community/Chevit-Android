package com.dkin.chevit.data.model.response

import com.dkin.chevit.data.DataModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class NewsResponse(
    @SerialName("safetyNoticeTitle") val title: String,
    @SerialName("safetyNoticeDetailLink") val webUrl: String
) : DataModel
