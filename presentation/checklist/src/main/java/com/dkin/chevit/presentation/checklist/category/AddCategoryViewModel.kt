package com.dkin.chevit.presentation.checklist.category

import com.dkin.chevit.core.mvi.MVIViewModel
import com.dkin.chevit.domain.base.onComplete
import com.dkin.chevit.domain.usecase.plan.PostNewCategoryUseCase
import com.dkin.chevit.presentation.common.model.CategoryType
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddCategoryViewModel @Inject constructor(
    private val postNewCategoryUseCase: PostNewCategoryUseCase
) :
    MVIViewModel<AddCategoryIntent, AddCategoryState, AddCategoryEffect>() {
    override fun createInitialState(): AddCategoryState = AddCategoryState.empty()

    override suspend fun processIntent(intent: AddCategoryIntent) {
        when (intent) {
            is AddCategoryIntent.AddCategory -> addCategory(intent.title, intent.type)
        }
    }

    fun initState(planId: String) {
        setState {
            AddCategoryState(planId, "", null)
        }
    }

    private suspend fun addCategory(title: String, type: CategoryType) {
        val state = state.value
        val addItem = postNewCategoryUseCase(
            PostNewCategoryUseCase.Param(
                planId = state.planId,
                subject = title,
                iconType = type.name,
            )
        )
        addItem.onComplete(
            doOnComplete = {},
            doOnError = {
                if (it is NullPointerException) {
                    //성공했을 때 응답값이 null로 내려옴
                    setEffect { AddCategoryEffect.AddItemSuccess }
                } else {
                    setEffect { AddCategoryEffect.AddItemFailed }
                }
            },
            doOnSuccess = {
                setEffect { AddCategoryEffect.AddItemSuccess }
            }
        )
    }
}