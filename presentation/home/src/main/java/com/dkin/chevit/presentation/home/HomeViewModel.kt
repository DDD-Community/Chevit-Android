package com.dkin.chevit.presentation.home

import androidx.lifecycle.viewModelScope
import com.dkin.chevit.core.mvi.MVIViewModel
import com.dkin.chevit.domain.base.getOrNull
import com.dkin.chevit.domain.usecase.auth.GetUserUseCase
import com.dkin.chevit.domain.usecase.plan.GetMyChecklistUseCase
import com.dkin.chevit.presentation.home.model.CheckListItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getMyChecklistUseCase: GetMyChecklistUseCase,
    private val getUserUseCase: GetUserUseCase,
) : MVIViewModel<HomeIntent, HomeState, HomeEffect>() {

    override fun createInitialState(): HomeState = HomeState.Loading

    override suspend fun processIntent(intent: HomeIntent) {
        when (intent) {
            HomeIntent.Initialize -> {
                getHomeTabInfo()
            }

            is HomeIntent.NoticeClicked -> {}
        }
    }

    fun onClickAddChecklist() {
        setEffect { HomeEffect.NavigateToAddCheckList }
    }

    fun onClickChecklist(id: String) {
        setEffect { HomeEffect.NavigateToCheckList(id) }
    }

    private suspend fun getHomeTabInfo() {
        val userAsync = async { getUserUseCase(Unit) }
        val checklistAsync = async { getMyChecklistUseCase(Unit) }
        listOf(userAsync, checklistAsync).awaitAll()
        val user = userAsync.await().getOrNull()
        val checklist = checklistAsync.await().getOrNull()
        setState {
            val currentState = state.value
            if (currentState is HomeState.Stable) {
                currentState.copy(
                    userName = user?.name ?: currentState.userName,
                    profileUrl = user?.profileImageUrl ?: currentState.profileUrl,
                    checkList = checklist?.list?.map {
                        CheckListItem(
                            id = it.id,
                            title = it.schedule.country.name,
                            date = "${it.schedule.startTime.formatted} ~ ${it.schedule.endTime.formatted}",
                            isProgress = it.schedule.isProgress,
                            backgroundUrl = it.schedule.backgroundImageUrl
                        )
                    } ?: listOf()
                )
            } else {
                HomeState.Stable(
                    userName = user?.name ?: "",
                    profileUrl = user?.profileImageUrl ?: "",
                    checkList = checklist?.list?.map {
                        CheckListItem(
                            id = it.id,
                            title = it.schedule.country.name,
                            date = "${it.schedule.startTime.formatted} ~ ${it.schedule.endTime.formatted}",
                            isProgress = it.schedule.isProgress,
                            backgroundUrl = it.schedule.backgroundImageUrl
                        )
                    } ?: listOf()
                )
            }
        }
    }
}
