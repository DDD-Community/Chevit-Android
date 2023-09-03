package com.dkin.chevit.presentation.resource

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
internal fun ChevitLabel(
    text: String,
    backgroundColor: Color,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .padding(horizontal = 14.dp, vertical = 4.dp)
            .background(color = backgroundColor, shape = RoundedCornerShape(100.dp))
            .clickable { onClick() }
    ) {
        Text(
            text = text,
            style = ChevitTheme.typhography.bodySmall.copy(color = ChevitTheme.colors.white)
        )
    }
}