package com.dkin.chevit.data.model.mapper

import com.dkin.chevit.data.model.response.AppInfoResponse
import com.dkin.chevit.domain.model.AppInfo

internal object AppInfoMapper : Mapper<AppInfoResponse, AppInfo> {
    override fun mapDomain(input: AppInfoResponse): AppInfo = with(input) {
        AppInfo(
            termsOfServiceWebUrl = termsOfServiceLink,
            privacyPolicyWebUrl = privacyPolicyLink
        )
    }
}
