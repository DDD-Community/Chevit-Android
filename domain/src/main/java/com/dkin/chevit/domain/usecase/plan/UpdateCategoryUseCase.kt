package com.dkin.chevit.domain.usecase.plan

import com.dkin.chevit.domain.base.CoroutineDispatcherProvider
import com.dkin.chevit.domain.base.IOUseCase
import com.dkin.chevit.domain.model.Category
import com.dkin.chevit.domain.model.Plan
import com.dkin.chevit.domain.model.getCategoryIconTypeByName
import com.dkin.chevit.domain.model.getColorTypeByName
import com.dkin.chevit.domain.repository.PlanRepository

class UpdateCategoryUseCase(
    coroutineDispatcherProvider: CoroutineDispatcherProvider,
    private val planRepository: PlanRepository
) : IOUseCase<UpdateCategoryUseCase.Param, Category>(coroutineDispatcherProvider) {
    override suspend fun execute(params: Param): Category {
        return planRepository.updateCategory(
            planId = params.planId,
            categoryId = params.categoryId,
            subject = params.subject,
            iconType = params.iconType.getCategoryIconTypeByName(),
        )
    }

    data class Param(
        val planId: String,
        val categoryId: String,
        val subject: String,
        val iconType: String
    )
}
