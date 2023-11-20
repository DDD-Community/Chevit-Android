package com.dkin.chevit.domain.usecase.service

import com.dkin.chevit.domain.base.CoroutineDispatcherProvider
import com.dkin.chevit.domain.base.IOUseCase
import com.dkin.chevit.domain.model.AppInfo
import com.dkin.chevit.domain.repository.ServiceRepository

class GetAppInfoUseCase(
    coroutineDispatcherProvider: CoroutineDispatcherProvider,
    private val serviceRepository: ServiceRepository
) : IOUseCase<Unit, AppInfo>(coroutineDispatcherProvider) {
    override suspend fun execute(params: Unit): AppInfo {
        return serviceRepository.getAppInfo()
    }
}
