package com.dkin.chevit.presentation.checklist.main

import com.dkin.chevit.core.mvi.MVIViewModel
import com.dkin.chevit.domain.usecase.plan.GetChecklistUseCase
import com.dkin.chevit.presentation.resource.TemplateColor
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ChecklistViewModel @Inject constructor(
    private val getChecklistUseCase: GetChecklistUseCase
) :
    MVIViewModel<ChecklistIntent, ChecklistState, ChecklistEffect>() {

    override fun createInitialState(): ChecklistState = ChecklistState.dummy()

    override suspend fun processIntent(intent: ChecklistIntent) {
        when (intent) {
            is ChecklistIntent.ChangeTemplateOpenSetting -> {
                //todo
            }
        }
    }

    fun setChecklistId(id: String) {
        setState {
            copy(id = id)
        }
    }

    fun initChecklist() {
        //todo
    }

    fun refreshChecklist() {
        //todo
    }

    fun onClickUrl(url: String) {
        setEffect { ChecklistEffect.NavigateToLink(url) }
    }

    fun onClickCategory(id: String) {
        setEffect { ChecklistEffect.NavigateToCategory(id) }
    }

    fun deleteCategory(planId: String, categoryId: String) {
        //todo
    }

    fun bringTemplate() {
        setEffect { ChecklistEffect.NavigateToBringTemplate }
    }

    fun saveTemplate(title: String, color: TemplateColor) {
        //TODO
    }
}
