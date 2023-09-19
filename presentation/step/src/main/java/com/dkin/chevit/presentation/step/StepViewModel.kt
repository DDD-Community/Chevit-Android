package com.dkin.chevit.presentation.step

import com.dkin.chevit.core.mvi.MVIViewModel
import com.dkin.chevit.presentation.step.model.CountryModel
import com.dkin.chevit.presentation.step.model.TravelWith
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class StepViewModel @Inject constructor() : MVIViewModel<StepIntent, StepState, StepEffect>() {
    private val _countryList: MutableStateFlow<List<CountryModel>> = MutableStateFlow(listOf())
    val countryList = _countryList.asStateFlow()

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
}