package com.dkin.chevit.presentation.checklist

import androidx.compose.runtime.Stable
import com.dkin.chevit.core.mvi.ViewEffect
import com.dkin.chevit.core.mvi.ViewIntent
import com.dkin.chevit.core.mvi.ViewState
import com.dkin.chevit.presentation.common.category.Category

sealed interface ChecklistIntent : ViewIntent {
}

@Stable
data class ChecklistState(
    val title: String,
    val date: String,
    val notice: Notice,
    val weathers: List<Weather>,
    val templates: List<Template>
) : ViewState {

    data class Notice(
        val title: String,
        val url: String
    )

    data class Weather(
        val date: String,
        val iconUrl: String,
        val temp: String,
    )

    data class Template(
        val title: String,
        val category: Category,
        val remain: Int,
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
            weathers = listOf(),
            templates = listOf()
        )
    }
}

sealed interface ChecklistEffect : ViewEffect {
    object NavigateToAddCategory : ChecklistEffect
}
