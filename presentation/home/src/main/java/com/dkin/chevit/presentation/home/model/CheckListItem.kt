package com.dkin.chevit.presentation.home.model

import androidx.compose.runtime.Stable

@Stable
data class CheckListItem(
    val id: String,
    val title: String,
    val date: String,
    val isProgress: Boolean,
    val backgroundUrl: String,
)
