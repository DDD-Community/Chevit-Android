package com.dkin.chevit.domain.usecase.plan

import com.dkin.chevit.domain.base.CoroutineDispatcherProvider
import com.dkin.chevit.domain.base.IOUseCase
import com.dkin.chevit.domain.base.None
import com.dkin.chevit.domain.repository.PlanRepository

class DeleteCategoryUseCase(
    coroutineDispatcherProvider: CoroutineDispatcherProvider,
    private val planRepository: PlanRepository
) : IOUseCase<DeleteCategoryUseCase.Param, None>(coroutineDispatcherProvider) {
    override suspend fun execute(params: Param): None {
        return planRepository.deleteCategory(params.planId, params.categoryId)
    }

    data class Param(
        val planId: String,
        val categoryId: String
    )
}