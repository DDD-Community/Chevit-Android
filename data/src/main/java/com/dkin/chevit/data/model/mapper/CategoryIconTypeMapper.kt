package com.dkin.chevit.data.model.mapper

import com.dkin.chevit.data.model.type.CategoryIconTypeResponse
import com.dkin.chevit.data.model.type.CategoryIconTypeResponse.BABY
import com.dkin.chevit.data.model.type.CategoryIconTypeResponse.BEAUTY_PRODUCTS
import com.dkin.chevit.data.model.type.CategoryIconTypeResponse.BUSINESS
import com.dkin.chevit.data.model.type.CategoryIconTypeResponse.CAMPING
import com.dkin.chevit.data.model.type.CategoryIconTypeResponse.CLOTHES
import com.dkin.chevit.data.model.type.CategoryIconTypeResponse.COMPANION_ANIMAL
import com.dkin.chevit.data.model.type.CategoryIconTypeResponse.ELECTRONICS
import com.dkin.chevit.data.model.type.CategoryIconTypeResponse.EMERGENCY_MEDICINE
import com.dkin.chevit.data.model.type.CategoryIconTypeResponse.ETC
import com.dkin.chevit.data.model.type.CategoryIconTypeResponse.EXERCISE
import com.dkin.chevit.data.model.type.CategoryIconTypeResponse.MOUNTAIN
import com.dkin.chevit.data.model.type.CategoryIconTypeResponse.PHOTO
import com.dkin.chevit.data.model.type.CategoryIconTypeResponse.REQUIRES
import com.dkin.chevit.data.model.type.CategoryIconTypeResponse.SWIMMING
import com.dkin.chevit.data.model.type.CategoryIconTypeResponse.TOILETRIES
import com.dkin.chevit.domain.model.CategoryIconType

internal object CategoryIconTypeMapper : Mapper<CategoryIconTypeResponse, CategoryIconType> {
    override fun mapDomain(input: CategoryIconTypeResponse): CategoryIconType = when (input) {
        REQUIRES -> CategoryIconType.REQUIRES
        ELECTRONICS -> CategoryIconType.ELECTRONICS
        EXERCISE -> CategoryIconType.EXERCISE
        TOILETRIES -> CategoryIconType.TOILETRIES
        EMERGENCY_MEDICINE -> CategoryIconType.EMERGENCY_MEDICINE
        BEAUTY_PRODUCTS -> CategoryIconType.BEAUTY_PRODUCTS
        BABY -> CategoryIconType.BABY
        COMPANION_ANIMAL -> CategoryIconType.COMPANION_ANIMAL
        MOUNTAIN -> CategoryIconType.MOUNTAIN
        BUSINESS -> CategoryIconType.BUSINESS
        PHOTO -> CategoryIconType.PHOTO
        CAMPING -> CategoryIconType.CAMPING
        SWIMMING -> CategoryIconType.SWIMMING
        CLOTHES -> CategoryIconType.CLOTHES
        ETC -> CategoryIconType.ETC
    }
}
