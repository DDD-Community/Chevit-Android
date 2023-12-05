package com.dkin.chevit.domain.model

import com.dkin.chevit.domain.base.DomainModel

enum class ColorType : DomainModel {
    DAWN,
    MORNING,
    AFTERNOON,
    SUNSET,
    NIGHT;
}

fun String.getColorTypeByName(): ColorType {
    val colors = ColorType.values()
    return colors.find { it.name == this } ?: ColorType.DAWN
}