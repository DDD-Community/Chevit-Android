package com.dkin.chevit.presentation.checklist.main.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.dkin.chevit.presentation.resource.ChevitTheme
import com.dkin.chevit.presentation.resource.icon.ChevitIcon
import com.dkin.chevit.presentation.resource.icon.IconArrowLeftLine
import com.dkin.chevit.presentation.resource.util.clickableNoRipple

@Composable
fun ChecklistTopBar(
    modifier: Modifier = Modifier,
    title: String,
    onClickBack: () -> Unit,
) {
    Box(
        modifier = modifier
            .height(58.dp)
            .padding(vertical = 16.dp, horizontal = 24.dp),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            modifier = Modifier
                .align(Alignment.CenterStart)
                .clickableNoRipple { onClickBack() },
            imageVector = ChevitIcon.IconArrowLeftLine,
            contentDescription = "",
        )
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = title,
            textAlign = TextAlign.Center,
            style = ChevitTheme.typhography.headlineMedium.copy(color = ChevitTheme.colors.textPrimary)
        )
    }
}