package com.dkin.chevit.domain.usecase.plan

import com.dkin.chevit.domain.base.CoroutineDispatcherProvider
import com.dkin.chevit.domain.base.IOUseCase
import com.dkin.chevit.domain.base.None
import com.dkin.chevit.domain.repository.PlanRepository

class DeleteCheckItemUseCase(
    coroutineDispatcherProvider: CoroutineDispatcherProvider,
    private val planRepository: PlanRepository
) : IOUseCase<DeleteCheckItemUseCase.Param, None>(coroutineDispatcherProvider) {
    override suspend fun execute(params: Param): None {
        return planRepository.deleteCheckItem(params.planId, params.checkItemId)
    }

    data class Param(
        val planId: String,
        val checkItemId: String
    )
}