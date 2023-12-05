package com.dkin.chevit.domain.usecase.plan

import com.dkin.chevit.domain.base.CoroutineDispatcherProvider
import com.dkin.chevit.domain.base.IOUseCase
import com.dkin.chevit.domain.model.Plan
import com.dkin.chevit.domain.repository.PlanRepository

class GetPlanUseCase(
    coroutineDispatcherProvider: CoroutineDispatcherProvider,
    private val planRepository: PlanRepository
) : IOUseCase<GetPlanUseCase.Param, Plan>(coroutineDispatcherProvider) {
    override suspend fun execute(params: Param): Plan {
        return planRepository.fetchPlan(params.planId)
    }

    data class Param(
        val planId: String
    )
}