package com.dkin.chevit.presentation.checklist.detail

import androidx.compose.runtime.Stable
import com.dkin.chevit.core.mvi.ViewEffect
import com.dkin.chevit.core.mvi.ViewIntent
import com.dkin.chevit.core.mvi.ViewState

sealed interface ChecklistDetailIntent : ViewIntent {
}

@Stable
data class ChecklistDetailState(
    val planId: String,
    val title: String,
    val detailItems: List<ChecklistDetailItem> = listOf()
) : ViewState {

    data class ChecklistDetailItem(
        val id: String,
        val checked: Boolean,
        val title: String,
        val memo: String,
        val count: Int
    )

    companion object {
        fun empty(): ChecklistDetailState = ChecklistDetailState(
            planId = "",
            title = "파리, 프랑스",
            detailItems = listOf(
                ChecklistDetailItem(id = "0", checked = true, title = "여권", memo = "", count = 1),
                ChecklistDetailItem(id = "1", checked = true, title = "항공권", memo = "프린트하기", count = 1),
                ChecklistDetailItem(id = "2", checked = false, title = "여행자보험", memo = "프린트하기", count = 1),
                ChecklistDetailItem(id = "3", checked = false, title = "지갑 및 현금", memo = "공항에서 환전하기", count = 1),
                ChecklistDetailItem(id = "4", checked = false, title = "볼펜", memo = "입국신고서 및 서류 작성용", count = 1),
                ChecklistDetailItem(id = "5", checked = false, title = "기내용 겉옷", memo = "", count = 2),
                ChecklistDetailItem(id = "6", checked = false, title = "목베개", memo = "", count = 1),
                ChecklistDetailItem(id = "7", checked = true, title = "티", memo = "", count = 2),
                ChecklistDetailItem(id = "8", checked = true, title = "바지", memo = "", count = 2),
                ChecklistDetailItem(id = "9", checked = true, title = "신발", memo = "", count = 2),
            ),
        )
    }
}

sealed interface ChecklistDetailEffect : ViewEffect {
    object NavigateToAddItem : ChecklistDetailEffect
}
