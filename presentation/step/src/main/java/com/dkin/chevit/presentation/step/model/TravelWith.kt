package com.dkin.chevit.presentation.step.model

enum class TravelWith(val key: String, val text: String) {
    ALONE("", "혼자"),
    FRIEND("FRIEND", "친구와"),
    LOVE("LOVE", "연인과"),
    MARRIAGE("MARRIAGE", "배우자와"),
    PARENT("PARENT", "부모님과"),
    BABY("BABY", "아기(2세 이하)와"),
    CHILD12("CHILD_12", "아이(2세 ~ 12세 이하)와"),
    CHILD("CHILD", "아이 (12세~)와"),
    SIBLING("SIBLING", "형제·자매와"),
    PET("PET", "반려동물과"),
    ETC("ETC", "기타"),
}