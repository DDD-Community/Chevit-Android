package com.dkin.chevit.domain.repository

import com.dkin.chevit.domain.model.AppInfo

interface ServiceRepository {
    suspend fun getAppInfo(): AppInfo
}
