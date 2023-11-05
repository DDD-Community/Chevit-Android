package com.dkin.chevit.presentation.checklist

import androidx.compose.runtime.Stable
import com.dkin.chevit.core.mvi.ViewEffect
import com.dkin.chevit.core.mvi.ViewIntent
import com.dkin.chevit.core.mvi.ViewState
import com.dkin.chevit.presentation.common.category.CategoryType

sealed interface ChecklistIntent : ViewIntent {
    data class ChangeTemplateOpenSetting(val isOpen: Boolean) : ChecklistIntent
}

@Stable
data class ChecklistState(
    val title: String,
    val date: String,
    val notice: Notice,
    val weathers: List<Weather>,
    val weatherDetailUrl: String,
    val categories: List<Category>,
    val isTemplateOpen: Boolean
) : ViewState {

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
        val categoryId: Int,
        val title: String,
        val categoryType: CategoryType,
        val checked: Int,
        val total: Int,
    )

    companion object {
        fun empty(): ChecklistState = ChecklistState(
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
                Category(categoryId = 0, title = "필수 준비물", categoryType = CategoryType.REQUIRES, checked = 12, total = 32),
                Category(categoryId = 1, title = "세면도구", categoryType = CategoryType.TOILETRIES, checked = 24, total = 24),
                Category(categoryId = 2, title = "의류", categoryType = CategoryType.CLOTHES, checked = 24, total = 24),
                Category(categoryId = 3, title = "등산", categoryType = CategoryType.CAMPING, checked = 12, total = 32),
                Category(categoryId = 4, title = "전자기기", categoryType = CategoryType.ELECTRONICS, checked = 20, total = 40),
                Category(categoryId = 5, title = "반려동물", categoryType = CategoryType.COMPANION_ANIMAL, checked = 24, total = 24),
            ),
            isTemplateOpen = true
        )
    }
}

sealed interface ChecklistEffect : ViewEffect {
    object NavigateToAddCategory : ChecklistEffect
    data class NavigateToLink(val url: String) : ChecklistEffect
    data class NavigateToCategory(val categoryId: Int) : ChecklistEffect
}
