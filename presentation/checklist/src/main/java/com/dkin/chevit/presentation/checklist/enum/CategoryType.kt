package com.dkin.chevit.presentation.checklist.enum

import com.dkin.chevit.presentation.resource.R


enum class CategoryType(val title: String) {
    REQUIRES("필수준비물"),
    ELECTRONICS("전자기기"),
    EXERCISE("운동"),
    TOILETRIES("세안용품"),
    EMERGENCY_MEDICINE("비상의약품"),
    BEAUTY_PRODUCTS("미용용품"),
    BABY("아기"),
    COMPANION_ANIMAL("반려동물"),
    MOUNTAIN("등산"),
    BUSINESS("출장"),
    PHOTO("사진"),
    CAMPING("캠핑"),
    SWIMMING("수영"),
    CLOTHES("의류"),
    ETC("기타"),
}

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