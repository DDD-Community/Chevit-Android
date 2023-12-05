package com.dkin.chevit.domain.usecase.plan

import com.dkin.chevit.domain.base.CoroutineDispatcherProvider
import com.dkin.chevit.domain.base.IOUseCase
import com.dkin.chevit.domain.model.CheckItem
import com.dkin.chevit.domain.repository.PlanRepository

class UpdateCheckItemUseCase(
    coroutineDispatcherProvider: CoroutineDispatcherProvider,
    private val planRepository: PlanRepository
) : IOUseCase<UpdateCheckItemUseCase.Param, CheckItem>(coroutineDispatcherProvider) {
    override suspend fun execute(params: Param): CheckItem {
        return planRepository.updateCheckItem(
            planId = params.planId,
            checkItemId = params.checkItemId,
            content = params.content,
            memo = params.memo,
            quantity = params.quantity
        )
    }

    data class Param(
        val planId: String,
        val checkItemId: String,
        val content: String,
        val memo: String,
        val quantity: Int
    )
}
