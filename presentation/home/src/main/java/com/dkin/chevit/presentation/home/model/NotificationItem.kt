package com.dkin.chevit.presentation.home.model

import androidx.compose.runtime.Stable
import com.dkin.chevit.domain.model.FormattedTime

@Stable
data class NotificationItem(
    val id: Long,
    val subject: String,
    val text: String,
    val time: FormattedTime,
)
