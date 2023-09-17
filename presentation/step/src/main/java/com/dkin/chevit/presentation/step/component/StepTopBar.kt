package com.dkin.chevit.presentation.step.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.dkin.chevit.presentation.resource.ChevitTheme
import com.dkin.chevit.presentation.resource.icon.ChevitIcon
import com.dkin.chevit.presentation.resource.icon.IconCloseFill

@Composable
fun StepTopBar(
    modifier: Modifier = Modifier,
    onClickClose: () -> Unit
) {
    Box(
        modifier = modifier
            .height(58.dp)
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = "새 체크리스트",
            textAlign = TextAlign.Center,
            style = ChevitTheme.typhography.headlineMedium.copy(color = ChevitTheme.colors.textPrimary)
        )
        Icon(
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .clickable(
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() },
                    onClick = { onClickClose() }
                ),
            imageVector = ChevitIcon.IconCloseFill,
            contentDescription = "",
        )
    }
}
