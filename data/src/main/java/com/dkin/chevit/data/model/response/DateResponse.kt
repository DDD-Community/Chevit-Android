package com.dkin.chevit.data.model.response

import com.dkin.chevit.data.DataModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class DateResponse(
    @SerialName("unixMillis") val unixMillis: Long,
    @SerialName("formatted") val formatted: String
) : DataModel
