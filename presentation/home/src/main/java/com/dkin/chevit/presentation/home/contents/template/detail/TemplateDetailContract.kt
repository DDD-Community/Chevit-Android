package com.dkin.chevit.presentation.home.contents.template.detail

import com.dkin.chevit.core.mvi.ViewEffect
import com.dkin.chevit.core.mvi.ViewIntent
import com.dkin.chevit.core.mvi.ViewState
import com.dkin.chevit.presentation.common.model.CategoryType

sealed interface TemplateDetailIntent : ViewIntent {
    data class ChangeTemplateOpenSetting(val isOpen: Boolean) : TemplateDetailIntent
}

data class TemplateDetailState(
    val title: String,
    val categories: List<Category>,
    val isTemplateOpen: Boolean,
) : ViewState {
    data class Category(
        val categoryId: String,
        val title: String,
        val categoryType: CategoryType,
        val checked: Int,
        val total: Int,
    )

    companion object {
        fun dummy(): TemplateDetailState = TemplateDetailState(
            title = "테스트 타이틀",
            categories = listOf(
                Category(
                    categoryId = "0",
                    title = CategoryType.REQUIRES.title,
                    categoryType = CategoryType.REQUIRES,
                    checked = 12,
                    total = 32
                ),
                Category(
                    categoryId = "1",
                    title = CategoryType.TOILETRIES.title,
                    categoryType = CategoryType.TOILETRIES,
                    checked = 24,
                    total = 24
                ),
                Category(
                    categoryId = "2",
                    title = CategoryType.CLOTHES.title,
                    categoryType = CategoryType.CLOTHES,
                    checked = 24,
                    total = 24
                ),
                Category(
                    categoryId = "3",
                    title = CategoryType.CAMPING.title,
                    categoryType = CategoryType.CAMPING,
                    checked = 12,
                    total = 32
                ),
                Category(
                    categoryId = "4",
                    title = CategoryType.ELECTRONICS.title,
                    categoryType = CategoryType.ELECTRONICS,
                    checked = 20,
                    total = 40
                ),
                Category(
                    categoryId = "5",
                    title = CategoryType.BABY.title,
                    categoryType = CategoryType.BABY,
                    checked = 24,
                    total = 24
                ),
                Category(
                    categoryId = "6",
                    title = CategoryType.BEAUTY_PRODUCTS.title,
                    categoryType = CategoryType.BEAUTY_PRODUCTS,
                    checked = 24,
                    total = 24
                ),
                Category(
                    categoryId = "7",
                    title = CategoryType.EMERGENCY_MEDICINE.title,
                    categoryType = CategoryType.EMERGENCY_MEDICINE,
                    checked = 24,
                    total = 24
                ),
                Category(
                    categoryId = "8",
                    title = CategoryType.ETC.title,
                    categoryType = CategoryType.ETC,
                    checked = 24,
                    total = 24
                ),
            ),
            isTemplateOpen = true
        )
    }
}

sealed interface TemplateDetailEffect : ViewEffect {
    data class NavigateToChecklistDetail(val categoryId: String) : TemplateDetailEffect
    object NavigateToAddCategory : TemplateDetailEffect
}