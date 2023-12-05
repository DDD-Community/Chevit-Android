package com.dkin.chevit.domain.usecase.plan

import com.dkin.chevit.domain.base.CoroutineDispatcherProvider
import com.dkin.chevit.domain.base.IOUseCase
import com.dkin.chevit.domain.model.Plan
import com.dkin.chevit.domain.model.getColorTypeByName
import com.dkin.chevit.domain.repository.PlanRepository

class UpdateTemplateUseCase(
    coroutineDispatcherProvider: CoroutineDispatcherProvider,
    private val planRepository: PlanRepository
) : IOUseCase<UpdateTemplateUseCase.Param, Plan>(coroutineDispatcherProvider) {
    override suspend fun execute(params: Param): Plan {
        return planRepository.updateTemplate(
            planId = params.planId,
            subject = params.subject,
            color = params.color.getColorTypeByName()
        )
    }

    data class Param(
        val planId: String,
        val subject: String,
        val color: String
    )
}
