package com.dkin.chevit.domain.model

import com.dkin.chevit.domain.base.DomainModel

data class FormattedTime(val unixMillis: Long, val formatted: String) : DomainModel
