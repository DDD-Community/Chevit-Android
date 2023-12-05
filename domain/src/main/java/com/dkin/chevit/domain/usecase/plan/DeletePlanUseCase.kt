package com.dkin.chevit.domain.usecase.plan

import com.dkin.chevit.domain.base.CoroutineDispatcherProvider
import com.dkin.chevit.domain.base.IOUseCase
import com.dkin.chevit.domain.base.None
import com.dkin.chevit.domain.repository.PlanRepository

class DeletePlanUseCase(
    coroutineDispatcherProvider: CoroutineDispatcherProvider,
    private val planRepository: PlanRepository
) : IOUseCase<DeletePlanUseCase.Param, None>(coroutineDispatcherProvider) {
    override suspend fun execute(params: Param): None {
        return planRepository.deletePlan(params.planId)
    }

    data class Param(
        val planId: String
    )
}