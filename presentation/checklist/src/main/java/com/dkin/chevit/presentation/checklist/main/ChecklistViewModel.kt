package com.dkin.chevit.presentation.checklist.main

import androidx.lifecycle.viewModelScope
import com.dkin.chevit.core.mvi.MVIViewModel
import com.dkin.chevit.domain.base.get
import com.dkin.chevit.domain.base.getOrNull
import com.dkin.chevit.domain.base.onComplete
import com.dkin.chevit.domain.usecase.plan.DeleteCategoryUseCase
import com.dkin.chevit.domain.usecase.plan.GetChecklistUseCase
import com.dkin.chevit.domain.usecase.plan.GetNewsUseCase
import com.dkin.chevit.domain.usecase.plan.GetWeatherUseCase
import com.dkin.chevit.domain.usecase.plan.PostNewTemplateUseCase
import com.dkin.chevit.presentation.common.model.getCategoryTypeByName
import com.dkin.chevit.presentation.resource.TemplateColor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.awaitAll
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
            is ChecklistIntent.RefreshChecklist -> refreshChecklist(intent.planId)
        }
    }

    fun initChecklist(id: String) {
        viewModelScope.launch {
            val checklist = getChecklistUseCase(GetChecklistUseCase.Param(id)).get()
            setState {
                val currentState = state.value
                if (currentState is ChecklistState.Available) {
                    currentState.copy(
                        id = id,
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
                        id = id,
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
            getChecklistInfo(id)
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
                    refreshChecklist(planId)
                } else {
                    setEffect { ChecklistEffect.DeleteCategoryFailed }
                }
            },
            doOnSuccess = {
                refreshChecklist(planId)
            }
        )
    }

    private suspend fun getChecklistInfo(id: String) {
        val noticeAsync = async { getNewsUseCase(GetNewsUseCase.Param(id)) }
        val weatherAsync = async { getWeatherUseCase(GetWeatherUseCase.Param(id)) }
        listOf(noticeAsync, weatherAsync).awaitAll()
        val notice = noticeAsync.await().getOrNull()
        val weather = weatherAsync.await().getOrNull()
        setState {
            val currentState = state.value
            if (currentState is ChecklistState.Available) {
                currentState.copy(
                    notice = ChecklistState.Available.Notice(
                        title = notice?.title ?: "",
                        url = notice?.webUrl ?: ""
                    ),
                    weathers = weather?.weatherList?.map {
                        ChecklistState.Available.Weather(
                            date = it.formattedTime.formatted,
                            iconUrl = it.iconUrl,
                            temperature = it.temperature
                        )
                    } ?: listOf(),
                    weatherDetailUrl = weather?.webUrl ?: "",
                )
            } else {
                ChecklistState.Available(
                    notice = ChecklistState.Available.Notice(
                        title = notice?.title ?: "",
                        url = notice?.webUrl ?: ""
                    ),
                    weathers = weather?.weatherList?.map {
                        ChecklistState.Available.Weather(
                            date = it.formattedTime.formatted,
                            iconUrl = it.iconUrl,
                            temperature = it.temperature
                        )
                    } ?: listOf(),
                    weatherDetailUrl = weather?.webUrl ?: "",
                )
            }
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

    private fun refreshChecklist(planId: String) {
        viewModelScope.launch {
            val currentState = state.value
            val checklist = getChecklistUseCase(GetChecklistUseCase.Param(planId)).get()
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
    }
}
