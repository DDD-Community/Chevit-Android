package com.dkin.chevit.presentation.home.contents.template.detail

import androidx.lifecycle.viewModelScope
import com.dkin.chevit.core.mvi.MVIViewModel
import com.dkin.chevit.domain.base.onComplete
import com.dkin.chevit.domain.usecase.plan.DeleteCategoryUseCase
import com.dkin.chevit.domain.usecase.plan.GetTemplateUseCase
import com.dkin.chevit.presentation.common.model.getCategoryTypeByName
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TemplateDetailViewModel @Inject constructor(
    private val getTemplateUseCase: GetTemplateUseCase,
    private val deleteCategoryUseCase: DeleteCategoryUseCase
) :
    MVIViewModel<TemplateDetailIntent, TemplateDetailState, TemplateDetailEffect>() {
    override fun createInitialState(): TemplateDetailState = TemplateDetailState.Loading

    override suspend fun processIntent(intent: TemplateDetailIntent) {
        when (intent) {
            TemplateDetailIntent.NavigateToAddCategory -> onClickAddCategory()
            is TemplateDetailIntent.InitTemplateDetail -> initTemplateDetail(intent.planId)
            is TemplateDetailIntent.ChangeTemplateOpenSetting -> changeTemplateOpenSetting(intent.isOpen)
            is TemplateDetailIntent.ClickCategory -> onClickCategory(intent.categoryId)
            is TemplateDetailIntent.DeleteCategory -> deleteCategory(intent.categoryId)
        }
    }

    private fun initTemplateDetail(templateId: String) {
        viewModelScope.launch {
            val templateUseCase = getTemplateUseCase(GetTemplateUseCase.Param(templateId))
            templateUseCase.onComplete(
                doOnComplete = {},
                doOnError = {
                    setEffect { TemplateDetailEffect.GetTemplateFail }
                },
                doOnSuccess = {
                    val template = this
                    setState {
                        TemplateDetailState.Available(
                            planId = templateId,
                            title = template.template.subject,
                            categories = template.categoryList.map {
                                TemplateDetailState.Available.Category(
                                    categoryId = it.id,
                                    title = it.subject,
                                    categoryType = getCategoryTypeByName(it.icon.name),
                                    checked = it.checkedCount,
                                    total = it.checkList.size
                                )
                            },
                            isTemplateOpen = template.isPublic
                        )
                    }
                }
            )
        }
    }

    private fun onClickAddCategory() {
        setEffect { TemplateDetailEffect.NavigateToAddCategory }
    }

    private fun onClickCategory(id: String) {
        setEffect { TemplateDetailEffect.NavigateToChecklistDetail(id) }
    }

    private suspend fun deleteCategory(categoryId: String) {
        val currentState = state.value
        if (currentState is TemplateDetailState.Available) {
            val planId = currentState.planId
            val deleteCategory = deleteCategoryUseCase(DeleteCategoryUseCase.Param(planId, categoryId))
            deleteCategory.onComplete(
                doOnComplete = {},
                doOnError = {
                    if (it is NullPointerException) {
                        //성공했을 때 응답값이 null로 내려옴
                        initTemplateDetail(planId)
                    } else {
                        setEffect { TemplateDetailEffect.DeleteCategoryFailed }
                    }
                },
                doOnSuccess = {
                    initTemplateDetail(planId)
                }
            )
        } else {
            setEffect { TemplateDetailEffect.DeleteCategoryFailed }
        }
    }

    private suspend fun changeTemplateOpenSetting(isOpen: Boolean) {
        //todo
    }

}