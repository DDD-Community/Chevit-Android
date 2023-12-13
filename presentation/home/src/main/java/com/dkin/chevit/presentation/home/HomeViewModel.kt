package com.dkin.chevit.presentation.home

import com.dkin.chevit.core.mvi.MVIViewModel
import com.dkin.chevit.domain.base.get
import com.dkin.chevit.domain.usecase.plan.GetMyChecklistUseCase
import com.dkin.chevit.presentation.home.model.CheckListItem
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getMyChecklistUseCase: GetMyChecklistUseCase
) : MVIViewModel<HomeIntent, HomeState, HomeEffect>() {

    override fun createInitialState(): HomeState = HomeState.empty()

    override suspend fun processIntent(intent: HomeIntent) {
        when (intent) {
            HomeIntent.ViewCreated -> getMyChecklist()
            is HomeIntent.NoticeClicked -> {}
        }
    }

    fun refreshMyCheckList() {
        //todo mypage에서 내 체크리스트 이동 시 사용
    }

    fun onClickAddChecklist() {
        setEffect { HomeEffect.NavigateToAddCheckList }
    }

    fun onClickChecklist(id: String) {
        setEffect { HomeEffect.NavigateToCheckList(id) }
    }

    private suspend fun getMyChecklist() {
        val checklist = getMyChecklistUseCase(Unit).get()
        setState {
            copy(
                checkList = checklist.list.map {
                    CheckListItem(
                        id = it.id,
                        title = it.schedule.country.name,
                        date = "${it.schedule.startTime.formatted} ~ ${it.schedule.endTime.formatted}",
                        isProgress = it.schedule.isProgress,
                        backgroundUrl = it.schedule.backgroundImageUrl
                    )
                }
            )
        }
    }
}
