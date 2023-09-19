package com.dkin.chevit.presentation.step

import androidx.compose.runtime.Stable
import com.dkin.chevit.core.mvi.ViewEffect
import com.dkin.chevit.core.mvi.ViewIntent
import com.dkin.chevit.core.mvi.ViewState
import com.dkin.chevit.presentation.step.model.CountryModel
import com.dkin.chevit.presentation.step.model.TravelWith
import java.time.LocalDate

sealed interface StepIntent : ViewIntent {
}

@Stable
data class StepState(
    val country: CountryModel? = null,
    val startDate: LocalDate? = null,
    val endDate: LocalDate? = null,
    val travelWith: List<TravelWith> = listOf(),
    val travelKind: String? = null
) : ViewState {
    fun getWhereLabel(): String = country?.text?.split(",")?.getOrNull(0) ?: ""
    fun getWhenLabel(): String {
        val startMonth = startDate?.month?.value.toString()
        val startDay = startDate?.month?.value.toString()
        val endMonth = startDate?.dayOfMonth.toString()
        val endDay = startDate?.dayOfMonth.toString()
        return "${startMonth}/${startDay}~${endMonth}/${endDay}"
    }
    fun getWhoLabel(): String {
        return when (travelWith.getOrNull(0)) {
            null -> ""
            TravelWith.ALONE -> TravelWith.ALONE.text
            else -> "동반자와"
        }
    }
    companion object {
        fun empty(): StepState = StepState()
    }
}

sealed interface StepEffect : ViewEffect {
}
