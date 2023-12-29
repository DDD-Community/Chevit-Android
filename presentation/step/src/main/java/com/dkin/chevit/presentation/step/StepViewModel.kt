package com.dkin.chevit.presentation.step

import com.dkin.chevit.core.mvi.MVIViewModel
import com.dkin.chevit.domain.base.get
import com.dkin.chevit.domain.base.onComplete
import com.dkin.chevit.domain.model.Country
import com.dkin.chevit.domain.usecase.plan.GetTravelKindsListUseCase
import com.dkin.chevit.domain.usecase.plan.GetTravelWithListUseCase
import com.dkin.chevit.domain.usecase.plan.PostNewScheduleUseCase
import com.dkin.chevit.domain.usecase.plan.SearchCountryListUseCase
import com.dkin.chevit.presentation.common.ext.unixMillis
import com.dkin.chevit.presentation.step.model.CountryModel
import com.dkin.chevit.presentation.step.model.TravelKind
import com.dkin.chevit.presentation.step.model.TravelWith
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class StepViewModel @Inject constructor(
    private val getTravelKindsListUseCase: GetTravelKindsListUseCase,
    private val getTravelWithListUseCase: GetTravelWithListUseCase,
    private val searchCountryListUseCase: SearchCountryListUseCase,
    private val postNewScheduleUseCase: PostNewScheduleUseCase,
) : MVIViewModel<StepIntent, StepState, StepEffect>() {
    private val _countryList: MutableStateFlow<List<CountryModel>> = MutableStateFlow(listOf())
    val countryList = _countryList.asStateFlow()
    private val _createLoadingVisible: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val createLoadingVisible = _createLoadingVisible.asStateFlow()
    private val _loadingVisible: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val loadingVisible = _loadingVisible.asStateFlow()
    private val _userNickname: MutableStateFlow<String> = MutableStateFlow("")
    val userNickname = _userNickname.asStateFlow()

    override fun createInitialState(): StepState = StepState.empty()

    override suspend fun processIntent(intent: StepIntent) {
        when (intent) {
            is StepIntent.SearchCountry -> searchCountryList(intent.keyword)
            is StepIntent.CreateChecklist -> createCheckList(intent.useRecommend)
        }
    }

    fun setNickname(name: String) {
        _userNickname.value = name
    }

    fun clearCountry() {
        _countryList.value = listOf()
        setState {
            copy(
                country = null
            )
        }
    }

    fun clearDate() {
        setState {
            copy(
                startDate = null,
                endDate = null
            )
        }
    }

    fun clearTravelWith() {
        setState {
            copy(
                travelWith = listOf()
            )
        }
    }

    fun onClickCountry(countryModel: CountryModel) {
        setState {
            copy(
                country = countryModel
            )
        }
    }

    fun setTravelWhen(dates: Pair<LocalDate?, LocalDate?>) {
        setState {
            copy(
                startDate = dates.first,
                endDate = dates.second
            )
        }
    }

    fun setTravelWith(with: TravelWith) {
        val currentList = state.value.travelWith.toMutableList()
        val itemIndex = currentList.indexOf(with)
        val newList = if (with == TravelWith.ALONE) {
            listOf(TravelWith.ALONE)
        } else if (itemIndex > -1) {
            currentList.remove(with)
            currentList
        } else {
            currentList.add(with)
            currentList
        }
        setState {
            copy(
                travelWith = newList
            )
        }
    }

    fun setTravelKind(kind: TravelKind) {
        val currentList = state.value.travelKind.toMutableList()
        val itemIndex = currentList.indexOf(kind)
        val newList = if (itemIndex > -1) {
            currentList.remove(kind)
            currentList
        } else {
            currentList.add(kind)
            currentList
        }
        setState {
            copy(
                travelKind = newList
            )
        }
    }

    private suspend fun searchCountryList(input: String) {
        val countries = searchCountryListUseCase(SearchCountryListUseCase.Param(input))
        countries.onComplete(
            doOnComplete = {},
            doOnError = {
                _countryList.value = listOf()
            },
            doOnSuccess = {
                _countryList.value = this.list.map {
                    CountryModel(
                        it.id,
                        it.name
                    )
                }
            }
        )
    }

    private suspend fun createCheckList(useRecommend: Boolean = true) {
        if (useRecommend) {
            _createLoadingVisible.value = true
        } else {
            _loadingVisible.value = true
        }

        val delayAsync = async { delay(2000L) }
        val newScheduleAsync = async {
            val stepState = state.value
            postNewScheduleUseCase(
                PostNewScheduleUseCase.Param(
                    country = Country(
                        id = stepState.country?.id ?: "",
                        name = stepState.country?.text ?: ""
                    ),
                    scheduleStartTime = stepState.startDate?.unixMillis() ?: 0,
                    scheduleEndTime = stepState.endDate?.unixMillis() ?: 0,
                    travelWith = stepState.travelWith.filter { it.key.isNotBlank() }
                        .map { it.key },
                    travelKind = stepState.travelKind.map { it.key },
                )
            ).get()
        }
        listOf(delayAsync, newScheduleAsync).awaitAll()
        val id = newScheduleAsync.await().id
        setEffect {
            StepEffect.NavigateToCheckList(id)
        }
    }
}