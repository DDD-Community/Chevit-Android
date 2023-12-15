package com.dkin.chevit.presentation.home.contents.user.mylist

import androidx.lifecycle.viewModelScope
import com.dkin.chevit.core.mvi.MVIViewModel
import com.dkin.chevit.domain.base.get
import com.dkin.chevit.domain.base.onComplete
import com.dkin.chevit.domain.usecase.plan.DeletePlanUseCase
import com.dkin.chevit.domain.usecase.plan.GetMyChecklistUseCase
import com.dkin.chevit.presentation.home.model.CheckListItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyCheckListViewModel @Inject constructor(
    private val getMyChecklistUseCase: GetMyChecklistUseCase,
    private val deletePlanUseCase: DeletePlanUseCase
) : MVIViewModel<MyCheckListIntent, MyCheckListState, MyCheckListEffect>() {

    override fun createInitialState() = MyCheckListState.empty()

    override suspend fun processIntent(intent: MyCheckListIntent) {
        when (intent) {
            is MyCheckListIntent.DeleteCheckList -> deleteChecklist(intent.id)
        }
    }


    fun onClickChecklist(id: String) {
        setEffect { MyCheckListEffect.NavigateToCheckList(id) }
    }

    fun initMyChecklist() {
        viewModelScope.launch {
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

    private suspend fun deleteChecklist(id: String) {
        val deleteItem = deletePlanUseCase(
            DeletePlanUseCase.Param(
                planId = id,
            )
        )
        deleteItem.onComplete(
            doOnComplete = {},
            doOnError = {
                if (it is NullPointerException) {
                    //성공했을 때 응답값이 null로 내려옴
                    initMyChecklist()
                } else {
                    setEffect { MyCheckListEffect.DeletePlanFailed }
                }
            },
            doOnSuccess = {
                initMyChecklist()
            }
        )
    }
}