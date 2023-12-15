package com.dkin.chevit.domain.usecase.plan

import com.dkin.chevit.domain.base.CoroutineDispatcherProvider
import com.dkin.chevit.domain.base.IOUseCase
import com.dkin.chevit.domain.model.Plan
import com.dkin.chevit.domain.model.PlanType
import com.dkin.chevit.domain.model.Template
import com.dkin.chevit.domain.repository.PlanRepository

class GetTemplateUseCase(
    coroutineDispatcherProvider: CoroutineDispatcherProvider,
    private val planRepository: PlanRepository,
) : IOUseCase<GetTemplateUseCase.Param, Template>(coroutineDispatcherProvider) {
    override suspend fun execute(params: Param): Template {
        return planRepository.fetchTemplate(params.planId)
    }

    data class Param(
        val planId: String
    )
}