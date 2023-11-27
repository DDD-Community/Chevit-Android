package com.dkin.chevit.presentation.common.model

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

fun getCategoryTypeByName(name: String): CategoryType {
    val colors = CategoryType.values()
    return colors.find { it.name == name } ?: CategoryType.REQUIRES
}