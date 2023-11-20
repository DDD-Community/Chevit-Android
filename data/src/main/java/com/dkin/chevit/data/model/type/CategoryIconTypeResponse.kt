package com.dkin.chevit.data.model.type

import com.dkin.chevit.data.DataModel
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal enum class CategoryIconTypeResponse : DataModel {
    @SerialName("REQUIRES")
    REQUIRES,

    @SerialName("ELECTRONICS")
    ELECTRONICS,

    @SerialName("EXERCISE")
    EXERCISE,

    @SerialName("TOILETRIES")
    TOILETRIES,

    @SerialName("EMERGENCY_MEDICINE")
    EMERGENCY_MEDICINE,

    @SerialName("BEAUTY_PRODUCTS")
    BEAUTY_PRODUCTS,

    @SerialName("BABY")
    BABY,

    @SerialName("COMPANION_ANIMAL")
    COMPANION_ANIMAL,

    @SerialName("MOUNTAIN")
    MOUNTAIN,

    @SerialName("BUSINESS")
    BUSINESS,

    @SerialName("PHOTO")
    PHOTO,

    @SerialName("CAMPING")
    CAMPING,

    @SerialName("SWIMMING")
    SWIMMING,

    @SerialName("CLOTHES")
    CLOTHES,

    @SerialName("ETC")
    ETC;
}
