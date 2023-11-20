package com.dkin.chevit.data.model.ext

import com.dkin.chevit.data.model.type.CategoryIconTypeResponse
import com.dkin.chevit.domain.model.CategoryIconType
import com.dkin.chevit.domain.model.CategoryIconType.BABY
import com.dkin.chevit.domain.model.CategoryIconType.BEAUTY_PRODUCTS
import com.dkin.chevit.domain.model.CategoryIconType.BUSINESS
import com.dkin.chevit.domain.model.CategoryIconType.CAMPING
import com.dkin.chevit.domain.model.CategoryIconType.CLOTHES
import com.dkin.chevit.domain.model.CategoryIconType.COMPANION_ANIMAL
import com.dkin.chevit.domain.model.CategoryIconType.ELECTRONICS
import com.dkin.chevit.domain.model.CategoryIconType.EMERGENCY_MEDICINE
import com.dkin.chevit.domain.model.CategoryIconType.ETC
import com.dkin.chevit.domain.model.CategoryIconType.EXERCISE
import com.dkin.chevit.domain.model.CategoryIconType.MOUNTAIN
import com.dkin.chevit.domain.model.CategoryIconType.PHOTO
import com.dkin.chevit.domain.model.CategoryIconType.REQUIRES
import com.dkin.chevit.domain.model.CategoryIconType.SWIMMING
import com.dkin.chevit.domain.model.CategoryIconType.TOILETRIES

internal fun CategoryIconType.toResponse(): CategoryIconTypeResponse = when (this) {
    REQUIRES -> CategoryIconTypeResponse.REQUIRES
    ELECTRONICS -> CategoryIconTypeResponse.ELECTRONICS
    EXERCISE -> CategoryIconTypeResponse.EXERCISE
    TOILETRIES -> CategoryIconTypeResponse.TOILETRIES
    EMERGENCY_MEDICINE -> CategoryIconTypeResponse.EMERGENCY_MEDICINE
    BEAUTY_PRODUCTS -> CategoryIconTypeResponse.BEAUTY_PRODUCTS
    BABY -> CategoryIconTypeResponse.BABY
    COMPANION_ANIMAL -> CategoryIconTypeResponse.COMPANION_ANIMAL
    MOUNTAIN -> CategoryIconTypeResponse.MOUNTAIN
    BUSINESS -> CategoryIconTypeResponse.BUSINESS
    PHOTO -> CategoryIconTypeResponse.PHOTO
    CAMPING -> CategoryIconTypeResponse.CAMPING
    SWIMMING -> CategoryIconTypeResponse.SWIMMING
    CLOTHES -> CategoryIconTypeResponse.CLOTHES
    ETC -> CategoryIconTypeResponse.ETC
}
