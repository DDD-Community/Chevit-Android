package com.dkin.chevit.domain.usecase.plan

import com.dkin.chevit.domain.base.CoroutineDispatcherProvider
import com.dkin.chevit.domain.base.IOUseCase
import com.dkin.chevit.domain.model.Country
import com.dkin.chevit.domain.model.Plan
import com.dkin.chevit.domain.repository.PlanRepository

class PostNewScheduleUseCase(
    coroutineDispatcherProvider: CoroutineDispatcherProvider,
    private val planRepository: PlanRepository
) : IOUseCase<PostNewScheduleUseCase.Param, Plan>(coroutineDispatcherProvider) {
    override suspend fun execute(params: Param): Plan {
        return planRepository.postNewSchedule(
            country = params.country,
            scheduleStartTime = params.scheduleStartTime,
            scheduleEndTime = params.scheduleEndTime,
            travelWith = params.travelWith,
            travelKind = params.travelKind,
            refPlanId = params.refPlanId
        )
    }

    data class Param(
        val country: Country,
        val scheduleStartTime: Long,
        val scheduleEndTime: Long,
        val travelWith: List<String>,
        val travelKind: List<String>,
        val refPlanId: String? = ""
    )
}
