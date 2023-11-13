package com.dkin.chevit.presentation.step

import androidx.lifecycle.viewModelScope
import com.dkin.chevit.core.mvi.MVIViewModel
import com.dkin.chevit.presentation.step.model.CountryModel
import com.dkin.chevit.presentation.step.model.TravelKind
import com.dkin.chevit.presentation.step.model.TravelWith
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StepViewModel @Inject constructor() : MVIViewModel<StepIntent, StepState, StepEffect>() {
    private val _countryList: MutableStateFlow<List<CountryModel>> = MutableStateFlow(listOf())
    val countryList = _countryList.asStateFlow()
    private val _createLoadingVisible: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val createLoadingVisible = _createLoadingVisible.asStateFlow()
    private val _loadingVisible: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val loadingVisible = _loadingVisible.asStateFlow()
    private val _userNickname: MutableStateFlow<String> = MutableStateFlow("")
    val userNickname = _userNickname.asStateFlow()

    init {
        //TODO 닉네임 datastore에서 가져오기
        _userNickname.value = "민지"
    }

    override fun createInitialState(): StepState = StepState.empty()

    override suspend fun processIntent(intent: StepIntent) {
        when (intent) {
            else -> {}
        }
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

    fun searchCountryList(input: String) {
        //TODO api
        _countryList.value = listOf(
            CountryModel(
                name = "PARIS",
                text = "파리, 프랑스"
            ),
            CountryModel(
                name = "NEWYORK",
                text = "뉴욕, 미국"
            )
        )
    }

    fun onClickCountry(countryModel: CountryModel) {
        setState {
            copy(
                country = countryModel
            )
        }
    }

    fun createCheckList(useRecommend: Boolean = true) {
        if (useRecommend) {
            _createLoadingVisible.value = true
            viewModelScope.launch {
                delay(2000L)
                //TODO call api
                setEffect {
                    StepEffect.NavigateToCheckList("testId")
                }
            }
        } else {
            _loadingVisible.value = true
            viewModelScope.launch {
                delay(2000L)
                //TODO call api
                setEffect {
                    StepEffect.NavigateToCheckList("testId")
                }
            }
        }
    }

    fun setTravelWith(with: TravelWith) {
        //TODO move to composable
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
}