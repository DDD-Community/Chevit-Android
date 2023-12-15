package com.dkin.chevit.presentation.checklist.detail

import androidx.lifecycle.viewModelScope
import com.dkin.chevit.core.mvi.MVIViewModel
import com.dkin.chevit.domain.base.get
import com.dkin.chevit.domain.base.onComplete
import com.dkin.chevit.domain.usecase.plan.DeleteCheckItemUseCase
import com.dkin.chevit.domain.usecase.plan.GetCategoryUseCase
import com.dkin.chevit.domain.usecase.plan.PostNewCheckItemUseCase
import com.dkin.chevit.domain.usecase.plan.UpdateCheckItemCheckedUseCase
import com.dkin.chevit.domain.usecase.plan.UpdateCheckItemUseCase
import com.dkin.chevit.presentation.common.model.SortType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChecklistDetailViewModel @Inject constructor(
    private val getCategoryUseCase: GetCategoryUseCase,
    private val updateCheckItemCheckedUseCase: UpdateCheckItemCheckedUseCase,
    private val deleteCheckItemUseCase: DeleteCheckItemUseCase,
    private val postNewCheckItemUseCase: PostNewCheckItemUseCase,
    private val updateCheckItemUseCase: UpdateCheckItemUseCase
) :
    MVIViewModel<ChecklistDetailIntent, ChecklistDetailState, ChecklistDetailEffect>() {

    private val _sortType: MutableStateFlow<SortType> = MutableStateFlow(SortType.NEW)
    val sortType = _sortType.asStateFlow()

    override fun createInitialState(): ChecklistDetailState = ChecklistDetailState.empty()

    override suspend fun processIntent(intent: ChecklistDetailIntent) {
        when (intent) {
            is ChecklistDetailIntent.SortItem -> sortItem(intent.sortType)
            is ChecklistDetailIntent.AddCheckItem -> addItem(
                intent.content,
                intent.memo,
                intent.quantity
            )

            is ChecklistDetailIntent.DeleteCheckItem -> removeItem(intent.checkItemId)
            is ChecklistDetailIntent.UpdateCheckItem -> editItem(
                intent.checkItemId,
                intent.content,
                intent.memo,
                intent.quantity
            )

            is ChecklistDetailIntent.UpdateCheckItemChecked -> checkItem(
                intent.checkItemId,
                intent.checked
            )
        }
    }

    fun getChecklistDetail(planId: String, categoryId: String) {
        viewModelScope.launch {
            val detailUseCase = getCategoryUseCase(
                GetCategoryUseCase.Param(planId = planId, categoryId = categoryId)
            )
            detailUseCase.onComplete(
                doOnComplete = {},
                doOnError = {
                    setEffect { ChecklistDetailEffect.GetChecklistFailed }
                },
                doOnSuccess = {
                    val detail = this
                    setState {
                        copy(
                            planId = planId,
                            categoryId = categoryId,
                            title = detail.subject,
                            detailItems = detail.checkList.map {
                                ChecklistDetailState.ChecklistDetailItem(
                                    id = it.id,
                                    checked = it.checked,
                                    title = it.content,
                                    memo = it.memo,
                                    count = it.quantity
                                )
                            }
                        )
                    }
                }
            )

        }
    }

    private suspend fun checkItem(itemId: String, checked: Boolean) {
        val state = state.value
        val checkItem = updateCheckItemCheckedUseCase(
            UpdateCheckItemCheckedUseCase.Param(
                planId = state.planId,
                checkItemId = itemId,
                checked = checked
            )
        )
        checkItem.onComplete(
            doOnComplete = {},
            doOnError = {
                if (it is NullPointerException) {
                    //성공했을 때 응답값이 null로 내려옴
                    getChecklistDetail(state.planId, state.categoryId)
                } else {
                    setEffect { ChecklistDetailEffect.CheckItemFailed }
                }
            },
            doOnSuccess = {
                getChecklistDetail(state.planId, state.categoryId)
            }
        )
    }

    private suspend fun removeItem(itemId: String) {
        val state = state.value
        val deleteItem = deleteCheckItemUseCase(
            DeleteCheckItemUseCase.Param(
                planId = state.planId,
                checkItemId = itemId,
            )
        )
        deleteItem.onComplete(
            doOnComplete = {},
            doOnError = {
                if (it is NullPointerException) {
                    //성공했을 때 응답값이 null로 내려옴
                    getChecklistDetail(state.planId, state.categoryId)
                } else {
                    setEffect { ChecklistDetailEffect.DeleteItemFailed }
                }
            },
            doOnSuccess = {
                getChecklistDetail(state.planId, state.categoryId)
            }
        )
    }

    private suspend fun addItem(title: String, memo: String, count: Int) {
        val state = state.value
        val addItem = postNewCheckItemUseCase(
            PostNewCheckItemUseCase.Param(
                planId = state.planId,
                categoryId = state.categoryId,
                content = title,
                memo = memo,
                quantity = count,
            )
        )
        addItem.onComplete(
            doOnComplete = {},
            doOnError = {
                if (it is NullPointerException) {
                    //성공했을 때 응답값이 null로 내려옴
                    getChecklistDetail(state.planId, state.categoryId)
                } else {
                    setEffect { ChecklistDetailEffect.AddItemFailed }
                }
            },
            doOnSuccess = {
                getChecklistDetail(state.planId, state.categoryId)
            }
        )
    }

    private suspend fun editItem(itemId: String, title: String, memo: String, count: Int) {
        val state = state.value
        val editItem = updateCheckItemUseCase(
            UpdateCheckItemUseCase.Param(
                planId = state.planId,
                checkItemId = itemId,
                content = title,
                memo = memo,
                quantity = count,
            )
        )
        editItem.onComplete(
            doOnComplete = {},
            doOnError = {
                if (it is NullPointerException) {
                    //성공했을 때 응답값이 null로 내려옴
                    getChecklistDetail(state.planId, state.categoryId)
                } else {
                    setEffect { ChecklistDetailEffect.EditItemFailed }
                }
            },
            doOnSuccess = {
                getChecklistDetail(state.planId, state.categoryId)
            }
        )
    }

    private fun sortItem(type: SortType) {
        _sortType.update { type }
    }
}