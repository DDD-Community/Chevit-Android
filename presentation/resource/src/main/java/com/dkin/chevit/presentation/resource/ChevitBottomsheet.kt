package com.dkin.chevit.presentation.resource

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.dkin.chevit.presentation.resource.util.clickableNoRipple

@Composable
fun ChevitBottomsheet(
    modifier: Modifier,
    onClickBackground: () -> Unit = {},
    content: @Composable () -> Unit,
) {
    Box(
        modifier = modifier.fillMaxSize().clickableNoRipple { onClickBackground() },
        contentAlignment = Alignment.BottomCenter
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp))
                .background(color = ChevitTheme.colors.white)
                .clickableNoRipple {}
                .padding(horizontal = 24.dp, vertical = 32.dp)
        ) {
            content()
        }
    }
}