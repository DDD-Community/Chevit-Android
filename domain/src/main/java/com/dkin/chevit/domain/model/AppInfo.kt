package com.dkin.chevit.domain.model

import com.dkin.chevit.domain.base.DomainModel

data class AppInfo(
    val termsOfServiceWebUrl: String,
    val privacyPolicyWebUrl: String
) : DomainModel
