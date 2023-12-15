package com.dkin.chevit.presentation.checklist.category

import com.dkin.chevit.core.mvi.MVIViewModel
import com.dkin.chevit.domain.base.onComplete
import com.dkin.chevit.domain.usecase.plan.UpdateCategoryUseCase
import com.dkin.chevit.domain.usecase.plan.UpdateCheckItemUseCase
import com.dkin.chevit.presentation.checklist.detail.ChecklistDetailEffect
import com.dkin.chevit.presentation.common.model.CategoryType
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EditCategoryViewModel @Inject constructor(
    private val updateCategoryUseCase: UpdateCategoryUseCase
) : MVIViewModel<EditCategoryIntent, EditCategoryState, EditCategoryEffect>() {
    override fun createInitialState(): EditCategoryState = EditCategoryState.empty()

    override suspend fun processIntent(intent: EditCategoryIntent) {
        when (intent) {
            is EditCategoryIntent.UpdateCategory -> updateCategory(intent.title, intent.type)
        }
    }

    fun initState(planId: String, categoryId: String, title: String, type: CategoryType) {
        setState {
            EditCategoryState(planId, categoryId, title, type)
        }
    }

    private suspend fun updateCategory(title: String, type: CategoryType) {
        val state = state.value
        val editItem = updateCategoryUseCase(
            UpdateCategoryUseCase.Param(
                planId = state.planId,
                categoryId = state.categoryId,
                subject = title,
                iconType = type.name,
            )
        )
        editItem.onComplete(
            doOnComplete = {},
            doOnError = {
                if (it is NullPointerException) {
                    //성공했을 때 응답값이 null로 내려옴
                    setEffect { EditCategoryEffect.EditItemSuccess }
                } else {
                    setEffect { EditCategoryEffect.EditItemFailed }
                }
            },
            doOnSuccess = {
                setEffect { EditCategoryEffect.EditItemSuccess }
            }
        )
    }
}