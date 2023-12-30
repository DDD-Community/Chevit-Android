package com.dkin.chevit.presentation.checklist.main

import androidx.lifecycle.viewModelScope
import com.dkin.chevit.core.mvi.MVIViewModel
import com.dkin.chevit.domain.base.get
import com.dkin.chevit.domain.base.onComplete
import com.dkin.chevit.domain.usecase.plan.DeleteCategoryUseCase
import com.dkin.chevit.domain.usecase.plan.GetChecklistUseCase
import com.dkin.chevit.domain.usecase.plan.GetNewsUseCase
import com.dkin.chevit.domain.usecase.plan.GetWeatherUseCase
import com.dkin.chevit.domain.usecase.plan.PostNewTemplateUseCase
import com.dkin.chevit.presentation.common.model.getCategoryTypeByName
import com.dkin.chevit.presentation.resource.TemplateColor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChecklistViewModel @Inject constructor(
    private val getChecklistUseCase: GetChecklistUseCase,
    private val getNewsUseCase: GetNewsUseCase,
    private val getWeatherUseCase: GetWeatherUseCase,
    private val deleteCategoryUseCase: DeleteCategoryUseCase,
    private val postNewTemplateUseCase: PostNewTemplateUseCase,
) : MVIViewModel<ChecklistIntent, ChecklistState, ChecklistEffect>() {
    private val _saveTemplateSuccess: MutableSharedFlow<Boolean> = MutableSharedFlow()
    val saveTemplateSuccess = _saveTemplateSuccess.asSharedFlow()

    override fun createInitialState(): ChecklistState = ChecklistState.Loading

    override suspend fun processIntent(intent: ChecklistIntent) {
        when (intent) {
            is ChecklistIntent.ChangeTemplateOpenSetting -> {
                //todo
            }

            is ChecklistIntent.DeleteCategory -> deleteCategory(intent.planId, intent.categoryId)
            is ChecklistIntent.SaveTemplate -> saveTemplate(intent.title, intent.color)
            is ChecklistIntent.RefreshChecklist -> getChecklist(intent.planId)
        }
    }

    fun getChecklist(planId: String, isInit: Boolean = false) {
        viewModelScope.launch {
            val currentState = state.value
            val checklistUsecase = getChecklistUseCase(GetChecklistUseCase.Param(planId))
            checklistUsecase.onComplete(
                doOnComplete = {
                    if (isInit) {
                        getWeather(planId)
                        getNotice(planId)
                    }
                },
                doOnError = {
                    setEffect { ChecklistEffect.GetChecklistFailed }
                },
                doOnSuccess = {
                    val checklist = this
                    setState {
                        if (currentState is ChecklistState.Available) {
                            currentState.copy(
                                title = checklist.schedule.country.name,
                                date = "${checklist.schedule.startTime.formatted} ~ ${checklist.schedule.endTime.formatted}",
                                categories = checklist.categoryList.map {
                                    ChecklistState.Available.Category(
                                        categoryId = it.id,
                                        title = it.subject,
                                        categoryType = getCategoryTypeByName(it.icon.name),
                                        checked = it.checkedCount,
                                        total = it.checkList.size
                                    )
                                },
                                isTemplateOpen = checklist.isPublic,
                            )
                        } else {
                            ChecklistState.Available(
                                id = planId,
                                title = checklist.schedule.country.name,
                                date = "${checklist.schedule.startTime.formatted} ~ ${checklist.schedule.endTime.formatted}",
                                categories = checklist.categoryList.map {
                                    ChecklistState.Available.Category(
                                        categoryId = it.id,
                                        title = it.subject,
                                        categoryType = getCategoryTypeByName(it.icon.name),
                                        checked = it.checkedCount,
                                        total = it.checkList.size
                                    )
                                },
                                isTemplateOpen = checklist.isPublic,
                            )
                        }
                    }
                }
            )
        }
    }

    fun onClickUrl(url: String) {
        setEffect { ChecklistEffect.NavigateToLink(url) }
    }

    fun onClickCategory(id: String) {
        setEffect { ChecklistEffect.NavigateToCategory(id) }
    }

    fun bringTemplate() {
        setEffect { ChecklistEffect.NavigateToBringTemplate }
    }

    private suspend fun deleteCategory(planId: String, categoryId: String) {
        val deleteCategory = deleteCategoryUseCase(DeleteCategoryUseCase.Param(planId, categoryId))
        deleteCategory.onComplete(
            doOnComplete = {},
            doOnError = {
                if (it is NullPointerException) {
                    //성공했을 때 응답값이 null로 내려옴
                    getChecklist(planId)
                } else {
                    setEffect { ChecklistEffect.DeleteCategoryFailed }
                }
            },
            doOnSuccess = {
                getChecklist(planId)
            }
        )
    }

    private fun getNotice(id: String) {
        viewModelScope.launch {
            val notice = getNewsUseCase(GetNewsUseCase.Param(id))
            notice.onComplete(
                doOnComplete = {},
                doOnError = {},
                doOnSuccess = {
                    val result = this
                    setState {
                        val currentState = state.value
                        if (currentState is ChecklistState.Available) {
                            currentState.copy(
                                notice = ChecklistState.Available.Notice(
                                    title = result.title,
                                    url = result.webUrl
                                ),
                            )
                        } else {
                            ChecklistState.Available(
                                notice = ChecklistState.Available.Notice(
                                    title = result.title,
                                    url = result.webUrl
                                ),
                            )
                        }
                    }
                }
            )
        }
    }

    private fun getWeather(id: String) {
        viewModelScope.launch {
            val weather = getWeatherUseCase(GetWeatherUseCase.Param(id))
            weather.onComplete(
                doOnComplete = {},
                doOnError = {},
                doOnSuccess = {
                    val weathers = this
                    setState {
                        val currentState = state.value
                        if (currentState is ChecklistState.Available) {
                            currentState.copy(
                                weathers = weathers.weatherList.map {
                                    ChecklistState.Available.Weather(
                                        date = it.formattedTime.formatted,
                                        iconUrl = it.iconUrl,
                                        temperature = it.temperature
                                    )
                                },
                                weatherDetailUrl = weathers.webUrl,
                            )
                        } else {
                            ChecklistState.Available(
                                weathers = weathers.weatherList.map {
                                    ChecklistState.Available.Weather(
                                        date = it.formattedTime.formatted,
                                        iconUrl = it.iconUrl,
                                        temperature = it.temperature
                                    )
                                },
                                weatherDetailUrl = weathers.webUrl,
                            )
                        }
                    }
                }
            )
        }
    }

    private suspend fun saveTemplate(title: String, color: TemplateColor) {
        val currentState = state.value
        if (currentState is ChecklistState.Available) {
            val id = currentState.id
            val saveTemplate =
                postNewTemplateUseCase(PostNewTemplateUseCase.Param(title, color.name, id))
            saveTemplate.onComplete(
                doOnComplete = {},
                doOnError = {
                    setEffect { ChecklistEffect.SaveTemplateFailed }
                },
                doOnSuccess = {
                    viewModelScope.launch {
                        _saveTemplateSuccess.emit(true)
                    }
                }
            )
        }
    }
}
