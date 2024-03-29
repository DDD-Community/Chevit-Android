package com.dkin.chevit.domain.usecase.plan

import com.dkin.chevit.domain.base.CoroutineDispatcherProvider
import com.dkin.chevit.domain.base.DomainListModel
import com.dkin.chevit.domain.base.IOUseCase
import com.dkin.chevit.domain.model.Plan
import com.dkin.chevit.domain.model.PlanType
import com.dkin.chevit.domain.repository.PlanRepository

class GetMyChecklistUseCase(
    coroutineDispatcherProvider: CoroutineDispatcherProvider,
    private val planRepository: PlanRepository,
) : IOUseCase<Unit, DomainListModel<Plan>>(coroutineDispatcherProvider) {
    override suspend fun execute(params: Unit): DomainListModel<Plan> {
        return planRepository.fetchMyPlanList()
    }
}