package com.dkin.chevit.domain.usecase.plan

import com.dkin.chevit.domain.base.CoroutineDispatcherProvider
import com.dkin.chevit.domain.base.IOUseCase
import com.dkin.chevit.domain.model.Plan
import com.dkin.chevit.domain.model.Template
import com.dkin.chevit.domain.model.getColorTypeByName
import com.dkin.chevit.domain.repository.PlanRepository

class PostNewTemplateUseCase(
    coroutineDispatcherProvider: CoroutineDispatcherProvider,
    private val planRepository: PlanRepository
) : IOUseCase<PostNewTemplateUseCase.Param, Template>(coroutineDispatcherProvider) {
    override suspend fun execute(params: Param): Template {
        return planRepository.newTemplate(
            subject = params.subject,
            color = params.color.getColorTypeByName(),
            refPlanId = params.refPlanId
        )
    }

    data class Param(
        val subject: String,
        val color: String,
        val refPlanId: String
    )
}
