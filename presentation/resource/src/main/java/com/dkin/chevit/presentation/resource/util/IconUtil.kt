package com.dkin.chevit.presentation.resource.util

import com.dkin.chevit.presentation.common.category.CategoryType
import com.dkin.chevit.presentation.resource.R

fun CategoryType.getCategoryIconResId(): Int {
    return when (this) {
        CategoryType.REQUIRES -> R.drawable.ic_category_requires
        CategoryType.ELECTRONICS -> R.drawable.ic_category_electronics
        CategoryType.EXERCISE -> R.drawable.ic_category_exercise
        CategoryType.TOILETRIES -> R.drawable.ic_category_toiletries
        CategoryType.EMERGENCY_MEDICINE -> R.drawable.ic_category_emergency_medicine
        CategoryType.BEAUTY_PRODUCTS -> R.drawable.ic_category_beauty_product
        CategoryType.BABY -> R.drawable.ic_category_baby
        CategoryType.COMPANION_ANIMAL -> R.drawable.ic_category_companion_animal
        CategoryType.MOUNTAIN -> R.drawable.ic_category_mountain
        CategoryType.BUSINESS -> R.drawable.ic_category_business
        CategoryType.PHOTO -> R.drawable.ic_category_photo
        CategoryType.CAMPING -> R.drawable.ic_category_camping
        CategoryType.SWIMMING -> R.drawable.ic_category_swimming
        CategoryType.CLOTHES -> R.drawable.ic_category_clothes
        CategoryType.ETC -> R.drawable.ic_category_etc
    }
}