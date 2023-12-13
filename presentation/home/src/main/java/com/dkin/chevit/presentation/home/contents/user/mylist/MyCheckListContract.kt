package com.dkin.chevit.presentation.home.contents.user.mylist

import androidx.compose.runtime.Stable
import com.dkin.chevit.core.mvi.ViewEffect
import com.dkin.chevit.core.mvi.ViewIntent
import com.dkin.chevit.core.mvi.ViewState
import com.dkin.chevit.presentation.home.model.CheckListItem

sealed interface MyCheckListIntent : ViewIntent {

}

@Stable
data class MyCheckListState(
    val checkList: List<CheckListItem>,
) : ViewState {

    companion object {
        fun empty(): MyCheckListState = MyCheckListState(listOf())
        fun dummy(): MyCheckListState = MyCheckListState(
            listOf(
                CheckListItem(
                    id = "0",
                    title = "파리, 프랑스",
                    date = "2023.07.16 ~ 2023.07.20",
                    isProgress = true,
                    backgroundUrl = "",
                ),
                CheckListItem(
                    id = "1",
                    title = "오사카, 일본",
                    date = "2023.07.10 ~ 2023.07.12",
                    isProgress = true,
                    backgroundUrl = "",
                ),
                CheckListItem(
                    id = "2",
                    title = "토론토, 캐나다",
                    date = "2023.07.01 ~ 2023.07.10",
                    isProgress = true,
                    backgroundUrl = "",
                ),
            )
        )
    }
}

sealed interface MyCheckListEffect : ViewEffect {
    data class NavigateToCheckList(val id: String) : MyCheckListEffect
}
