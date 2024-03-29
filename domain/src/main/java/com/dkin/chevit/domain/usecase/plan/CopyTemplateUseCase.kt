package com.dkin.chevit.domain.usecase.plan

import com.dkin.chevit.domain.base.CoroutineDispatcherProvider
import com.dkin.chevit.domain.base.IOUseCase
import com.dkin.chevit.domain.model.Plan
import com.dkin.chevit.domain.model.Template
import com.dkin.chevit.domain.repository.PlanRepository

class CopyTemplateUseCase(
    coroutineDispatcherProvider: CoroutineDispatcherProvider,
    private val planRepository: PlanRepository
) : IOUseCase<CopyTemplateUseCase.Param, Template>(coroutineDispatcherProvider) {
    override suspend fun execute(params: Param): Template {
        return planRepository.copyTemplate(
            planId = params.planId, refPlanId = params.refPlanId
        )
    }

    data class Param(val planId: String, val refPlanId: String?)
}