package com.dkin.chevit.domain.model

import com.dkin.chevit.domain.base.DomainModel

enum class CategoryIconType : DomainModel {
    REQUIRES,
    ELECTRONICS,
    EXERCISE,
    TOILETRIES,
    EMERGENCY_MEDICINE,
    BEAUTY_PRODUCTS,
    BABY,
    COMPANION_ANIMAL,
    MOUNTAIN,
    BUSINESS,
    PHOTO,
    CAMPING,
    SWIMMING,
    CLOTHES,
    ETC;
}

fun String.getCategoryIconTypeByName(): CategoryIconType {
    val colors = CategoryIconType.values()
    return colors.find { it.name == this } ?: CategoryIconType.ETC
}