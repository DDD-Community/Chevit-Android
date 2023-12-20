package com.dkin.chevit.presentation.checklist.main

import androidx.compose.runtime.Stable
import com.dkin.chevit.core.mvi.ViewEffect
import com.dkin.chevit.core.mvi.ViewIntent
import com.dkin.chevit.core.mvi.ViewState
import com.dkin.chevit.presentation.common.model.CategoryType
import com.dkin.chevit.presentation.resource.TemplateColor

sealed interface ChecklistIntent : ViewIntent {
    data class ChangeTemplateOpenSetting(val isOpen: Boolean) : ChecklistIntent
    data class DeleteCategory(val planId: String, val categoryId: String) : ChecklistIntent
    data class SaveTemplate(val title: String, val color: TemplateColor) : ChecklistIntent
    data class RefreshChecklist(val planId: String) : ChecklistIntent
}

@Stable
sealed interface ChecklistState : ViewState {
    object Loading : ChecklistState

    data class Available(
        val id: String = "",
        val title: String = "",
        val date: String = "",
        val notice: Notice = Notice("", ""),
        val weathers: List<Weather> = listOf(),
        val weatherDetailUrl: String = "",
        val categories: List<Category> = listOf(),
        val isTemplateOpen: Boolean = false
    ) : ChecklistState {

        data class Notice(
            val title: String,
            val url: String
        )

        data class Weather(
            val date: String,
            val iconUrl: String,
            val temperature: String
        )

        data class Category(
            val categoryId: String,
            val title: String,
            val categoryType: CategoryType,
            val checked: Int,
            val total: Int,
        )

        companion object {
            fun empty(): ChecklistState = Available(
                id = "",
                title = "",
                date = "",
                notice = Notice(
                    title = "",
                    url = ""
                ),
                weathers = listOf(),
                weatherDetailUrl = "",
                categories = listOf(),
                isTemplateOpen = false
            )

            fun dummy(): ChecklistState = Available(
                id = "",
                title = "파리, 프랑스",
                date = "2023.07.16 ~ 2023.07.30",
                notice = Notice(
                    title = "[주의] 프랑스, 폭력시위 관련 안전유의 공지",
                    url = ""
                ),
                weathers = listOf(
                    Weather(date = "7/16", iconUrl = "", temperature = "14°/25°"),
                    Weather(date = "7/17", iconUrl = "", temperature = "13°/22°"),
                    Weather(date = "7/18", iconUrl = "", temperature = "14°/21°"),
                ),
                weatherDetailUrl = "",
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
}

sealed interface ChecklistEffect : ViewEffect {
    object NavigateToBringTemplate : ChecklistEffect
    data class NavigateToLink(val url: String) : ChecklistEffect
    data class NavigateToCategory(val categoryId: String) : ChecklistEffect
    object SaveTemplateFailed : ChecklistEffect
    object DeleteCategoryFailed : ChecklistEffect

}
