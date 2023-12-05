package com.dkin.chevit.domain.usecase.plan

import com.dkin.chevit.domain.base.CoroutineDispatcherProvider
import com.dkin.chevit.domain.base.IOUseCase
import com.dkin.chevit.domain.model.CheckItem
import com.dkin.chevit.domain.repository.PlanRepository

class UpdateCheckItemCheckedUseCase(
    coroutineDispatcherProvider: CoroutineDispatcherProvider,
    private val planRepository: PlanRepository
) : IOUseCase<UpdateCheckItemCheckedUseCase.Param, CheckItem>(coroutineDispatcherProvider) {

    override suspend fun execute(params: Param): CheckItem {
        return planRepository.checkCheckItem(
            planId = params.planId,
            checkItemId = params.checkItemId,
            checked = params.checked
        )
    }

    data class Param(
        val planId: String,
        val checkItemId: String,
        val checked: Boolean
    )
}