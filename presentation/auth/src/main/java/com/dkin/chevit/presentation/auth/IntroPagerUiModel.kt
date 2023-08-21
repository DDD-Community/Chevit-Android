package com.dkin.chevit.presentation.auth

import androidx.annotation.DrawableRes

data class IntroPagerUiModel(
    val id: Int,
    @DrawableRes val imageRes: Int,
    val title: String,
    val description: String,
)
