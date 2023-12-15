package com.dkin.chevit.domain.usecase.plan

import com.dkin.chevit.domain.base.CoroutineDispatcherProvider
import com.dkin.chevit.domain.base.DomainListModel
import com.dkin.chevit.domain.base.IOUseCase
import com.dkin.chevit.domain.model.Plan
import com.dkin.chevit.domain.model.PlanType
import com.dkin.chevit.domain.model.Template
import com.dkin.chevit.domain.repository.PlanRepository

class GetMyTemplateListUseCase(
    coroutineDispatcherProvider: CoroutineDispatcherProvider,
    private val planRepository: PlanRepository,
) : IOUseCase<Unit, DomainListModel<Template>>(coroutineDispatcherProvider) {
    override suspend fun execute(params: Unit): DomainListModel<Template> {
        return planRepository.fetchMyTemplateList()
    }
}