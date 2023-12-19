package com.dkin.chevit.presentation.home.contents.template

import androidx.lifecycle.viewModelScope
import com.dkin.chevit.core.mvi.MVIViewModel
import com.dkin.chevit.domain.base.onComplete
import com.dkin.chevit.domain.usecase.plan.DeletePlanUseCase
import com.dkin.chevit.domain.usecase.plan.GetMyTemplateListUseCase
import com.dkin.chevit.domain.usecase.plan.PostNewTemplateUseCase
import com.dkin.chevit.domain.usecase.plan.UpdateTemplateUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import com.dkin.chevit.presentation.common.model.SortType
import com.dkin.chevit.presentation.home.contents.template.model.Template
import com.dkin.chevit.presentation.resource.TemplateColor
import com.dkin.chevit.presentation.resource.getTemplateColorByName
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TemplateViewModel @Inject constructor(
    private val getMyTemplateListUseCase: GetMyTemplateListUseCase,
    private val deletePlanUseCase: DeletePlanUseCase,
    private val postNewTemplateUseCase: PostNewTemplateUseCase,
    private val updateTemplateUseCase: UpdateTemplateUseCase
) : MVIViewModel<TemplateIntent, TemplateState, TemplateEffect>() {

    private val _sortType: MutableStateFlow<SortType> = MutableStateFlow(SortType.NEW)
    val sortType = _sortType.asStateFlow()
    private val _progress: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val progress = _progress.asStateFlow()

    override fun createInitialState(): TemplateState = TemplateState.Loading

    override suspend fun processIntent(intent: TemplateIntent) {
        when (intent) {
            TemplateIntent.GetTemplateList -> getTemplateList()
            is TemplateIntent.ClickTemplate -> onClickTemplate(intent.id)
            is TemplateIntent.RemoveTemplate -> removeTemplate(intent.planId)
            is TemplateIntent.SaveTemplate -> saveTemplate(intent.title, intent.color)
            is TemplateIntent.SortTemplate -> sortTemplate(intent.type)
            is TemplateIntent.UpdateTemplate -> updateTemplate(
                intent.id,
                intent.title,
                intent.color
            )
        }
    }

    private fun getTemplateList() {
        viewModelScope.launch {
            val listUseCase = getMyTemplateListUseCase(Unit)
            listUseCase.onComplete(
                doOnComplete = {},
                doOnError = {
                    setEffect { TemplateEffect.GetTemplateListFail }
                },
                doOnSuccess = {
                    val plan = this.list
                    setState {
                        TemplateState.Available(
                            templateList = plan.map {
                                Template(
                                    id = it.id,
                                    title = it.template.subject,
                                    date = it.createdTime.formatted,
                                    colorType = getTemplateColorByName(it.template.colorType.name)
                                )
                            }
                        )
                    }
                }
            )
        }
    }

    private fun onClickTemplate(id: String) {
        setEffect { TemplateEffect.NavigateToTemplate(id) }
    }

    private fun sortTemplate(type: SortType) {
        _sortType.update { type }
    }

    private suspend fun removeTemplate(planId: String) {
        _progress.update { true }
        val deleteItem = deletePlanUseCase(DeletePlanUseCase.Param(planId = planId))
        deleteItem.onComplete(
            doOnComplete = {
                _progress.update { false }
            },
            doOnError = {
                if (it is NullPointerException) {
                    //성공했을 때 응답값이 null로 내려옴
                    getTemplateList()
                } else {
                    setEffect { TemplateEffect.DeleteTemplateFail }
                }
            },
            doOnSuccess = {
                getTemplateList()
            }
        )
    }

    private suspend fun saveTemplate(title: String, color: TemplateColor) {
        _progress.update { true }
        val saveTemplate = postNewTemplateUseCase(
            PostNewTemplateUseCase.Param(
                subject = title,
                color = color.name,
                refPlanId = ""
            )
        )
        saveTemplate.onComplete(
            doOnComplete = {
                _progress.update { false }
            },
            doOnError = {
                if (it is NullPointerException) {
                    //성공했을 때 응답값이 null로 내려옴
                    getTemplateList()
                } else {
                    setEffect { TemplateEffect.SaveTemplateFail }
                }
            },
            doOnSuccess = {
                setEffect { TemplateEffect.NavigateToAddCategory(this.id) }
            }
        )
    }

    private suspend fun updateTemplate(id: String, title: String, color: TemplateColor) {
        _progress.update { true }
        val saveTemplate = updateTemplateUseCase(
            UpdateTemplateUseCase.Param(
                planId = id,
                subject = title,
                color = color.name,
            )
        )
        saveTemplate.onComplete(
            doOnComplete = {
                _progress.update { false }
            },
            doOnError = {
                if (it is NullPointerException) {
                    //성공했을 때 응답값이 null로 내려옴
                    getTemplateList()
                } else {
                    setEffect { TemplateEffect.SaveTemplateFail }
                }
            },
            doOnSuccess = {
                getTemplateList()
            }
        )
    }
}