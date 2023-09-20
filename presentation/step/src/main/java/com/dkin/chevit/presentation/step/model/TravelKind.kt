package com.dkin.chevit.presentation.step.model

enum class TravelKind(val key: String, val text: String) {
    BUSINESS("BUSINESS", "출장/업무"),
    GASTROVENTURE("GASTROVENTURE", "맛집탐방"),
    SWIMMING("SWIMMING", "수영"),
    ACTIVITY("ACTIVITY", "액티비티"),
    ME_TIME("ME_TIME", "힐링여행"),
    CAMPING("CAMPING", "캠핑"),
    HIKING_CLIMBING("HIKING_CLIMBING", "등산"),
    SHOPPING("SHOPPING", "쇼핑"),
    TAKE_PHOTO("TAKE_PHOTO", "사진"),
    NATURE("NATURE", "자연"),
    TOURISTSPOT("TOURISTSPOT", "관광지 방문"),
    EXERCISE("EXERCISE", "운동"),
    ETC("ETC", "기타"),
}