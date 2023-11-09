package com.dkin.chevit.presentation.resource

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.dkin.chevit.presentation.resource.icon.ChevitIcon
import com.dkin.chevit.presentation.resource.icon.IconAddFill
import com.dkin.chevit.presentation.resource.icon.IconCloseFill

@Composable
fun ChevitFloatingButton(
    modifier: Modifier = Modifier,
    isOpened: Boolean = false,
    onClick: () -> Unit = {},
    floatingContent: @Composable () -> Unit = {}
) {
    if (isOpened) {
        Column(
            horizontalAlignment = Alignment.End
        ) {
            floatingContent()
            Spacer(modifier = Modifier.height(12.dp))
            Box(
                modifier = modifier
                    .size(50.dp)
                    .clip(CircleShape)
                    .background(color = ChevitTheme.colors.white)
                    .clickable { onClick() },
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    modifier = Modifier.size(30.dp),
                    imageVector = ChevitIcon.IconCloseFill,
                    contentDescription = "",
                    tint = ChevitTheme.colors.grey10,
                )
            }
        }

    } else {
        Box(
            modifier = modifier
                .size(50.dp)
                .clip(CircleShape)
                .background(color = ChevitTheme.colors.blue7)
                .clickable { onClick() },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                modifier = Modifier.size(30.dp),
                imageVector = ChevitIcon.IconAddFill,
                contentDescription = "",
                tint = ChevitTheme.colors.white,
            )
        }
    }
}