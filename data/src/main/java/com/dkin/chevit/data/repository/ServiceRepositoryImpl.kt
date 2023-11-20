package com.dkin.chevit.data.repository

import com.dkin.chevit.data.model.mapper.AppInfoMapper
import com.dkin.chevit.data.remote.ServiceAPI
import com.dkin.chevit.domain.model.AppInfo
import com.dkin.chevit.domain.repository.ServiceRepository
import javax.inject.Inject

internal class ServiceRepositoryImpl @Inject constructor(
    private val serviceAPI: ServiceAPI
) : ServiceRepository {
    override suspend fun getAppInfo(): AppInfo {
        return serviceAPI.getAppInfo().let(AppInfoMapper::mapDomain)
    }
}
