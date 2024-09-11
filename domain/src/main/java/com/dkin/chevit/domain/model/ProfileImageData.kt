package com.dkin.chevit.domain.model

import com.dkin.chevit.domain.base.DomainModel

data class ProfileImageData(
    val uploadMethod: String,
    val uploadURL: String,
    val uploadHeaders: String,
    val imageURL: String
) : DomainModel