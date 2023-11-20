package com.dkin.chevit.domain.model

import com.dkin.chevit.domain.base.DomainModel

data class TravelKind(
    val id: String,
    val name: String
) : DomainModel
