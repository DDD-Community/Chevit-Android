package com.dkin.chevit.data.model.response

import com.dkin.chevit.data.DataModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class LocaleResponse(
    @SerialName("name") val name: String,
    @SerialName("text") val text: String,
    @SerialName("localeText") val localeText: LocaleTextResponse
) : DataModel {
    @Serializable
    internal data class LocaleTextResponse(
        @SerialName("en") val en: String,
        @SerialName("ko") val ko: String
    ) : DataModel
}
