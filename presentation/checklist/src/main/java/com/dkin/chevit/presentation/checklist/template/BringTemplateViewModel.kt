package com.dkin.chevit.presentation.checklist.template

import androidx.lifecycle.viewModelScope
import com.dkin.chevit.core.mvi.MVIViewModel
import com.dkin.chevit.domain.base.onComplete
import com.dkin.chevit.domain.usecase.plan.CopyTemplateUseCase
import com.dkin.chevit.domain.usecase.plan.GetCategoryUseCase
import com.dkin.chevit.domain.usecase.plan.GetMyTemplateListUseCase
import com.dkin.chevit.domain.usecase.plan.GetTemplateUseCase
import com.dkin.chevit.presentation.checklist.detail.ChecklistDetailState
import com.dkin.chevit.presentation.checklist.main.ChecklistState
import com.dkin.chevit.presentation.checklist.template.model.TemplateCategoryDetailState
import com.dkin.chevit.presentation.checklist.template.model.TemplateDetailState
import com.dkin.chevit.presentation.common.model.getCategoryTypeByName
import com.dkin.chevit.presentation.resource.getTemplateColorByName
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BringTemplateViewModel @Inject constructor(
    private val getMyTemplateListUseCase: GetMyTemplateListUseCase,
    private val getTemplateUseCase: GetTemplateUseCase,
    private val getCategoryUseCase: GetCategoryUseCase,
    private val copyTemplateUseCase: CopyTemplateUseCase
) : MVIViewModel<BringTemplateIntent, BringTemplateState, BringTemplateEffect>() {

    private val _templateState: MutableStateFlow<TemplateDetailState> =
        MutableStateFlow(TemplateDetailState.empty())
    val templateState = _templateState.asStateFlow()
    private val _detailState: MutableStateFlow<TemplateCategoryDetailState> =
        MutableStateFlow(TemplateCategoryDetailState.empty())
    val detailState = _detailState.asStateFlow()
    override fun createInitialState() = BringTemplateState.empty()

    override suspend fun processIntent(intent: BringTemplateIntent) {
        when (intent) {
            is BringTemplateIntent.GetTemplate -> getTemplate(intent.templateId)
            is BringTemplateIntent.GetCategory -> getChecklistDetailItems(
                intent.templateId,
                intent.categoryId
            )

            is BringTemplateIntent.BringTemplate -> bringTemplate(intent.templateId)
        }
    }

    fun initTemplateList(planId: String) {
        viewModelScope.launch {
            val listUseCase = getMyTemplateListUseCase(Unit)
            listUseCase.onComplete(
                doOnComplete = {},
                doOnError = {
                    setEffect { BringTemplateEffect.GetTemplateListFail }
                },
                doOnSuccess = {
                    val plan = this.list
                    setState {
                        copy(
                            planId = planId,
                            templateList = plan.map {
                                BringTemplateState.Template(
                                    id = it.id,
                                    title = it.template.subject,
                                    date = it.createdTime.formatted,
                                    colorType = getTemplateColorByName(it.template.colorType.name)
                                )
                            },
                        )
                    }
                }
            )
        }
    }

    private suspend fun getTemplate(templateId: String) {
        val templateUseCase = getTemplateUseCase(GetTemplateUseCase.Param(templateId))
        templateUseCase.onComplete(
            doOnComplete = {},
            doOnError = {
                setEffect { BringTemplateEffect.GetTemplateFail }
            },
            doOnSuccess = {
                val template = this
                _templateState.update {
                    TemplateDetailState(
                        templateName = template.template.subject,
                        categories = template.categoryList.map {
                            ChecklistState.Category(
                                categoryId = it.id,
                                title = it.subject,
                                categoryType = getCategoryTypeByName(it.icon.name),
                                checked = it.checkedCount,
                                total = it.checkList.size
                            )
                        },
                    )
                }
            }
        )
    }

    private suspend fun getChecklistDetailItems(
        templateId: String,
        categoryId: String
    ) {
        val detailUseCase = getCategoryUseCase(
            GetCategoryUseCase.Param(planId = templateId, categoryId = categoryId)
        )
        detailUseCase.onComplete(
            doOnComplete = {},
            doOnError = {
                setEffect { BringTemplateEffect.GetCategoryFail }
            },
            doOnSuccess = {
                val category = this
                _detailState.update {
                    TemplateCategoryDetailState(
                        categoryName = category.subject,
                        detailItems = category.checkList.map {
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

    private suspend fun bringTemplate(templateId: String) {
        val planId = state.value.planId
        val templateUseCase = copyTemplateUseCase(CopyTemplateUseCase.Param(planId = planId, refPlanId = templateId))
        templateUseCase.onComplete(
            doOnComplete = {},
            doOnError = {
                setEffect { BringTemplateEffect.BringTemplateFail }
            },
            doOnSuccess = {
                setEffect { BringTemplateEffect.BringTemplateSuccess }
            }
        )
    }
}