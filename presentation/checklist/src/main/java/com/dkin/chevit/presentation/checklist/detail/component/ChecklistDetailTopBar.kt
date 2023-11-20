package com.dkin.chevit.presentation.checklist.detail.component

import androidx.compose.foundation.layout.Row
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
import com.dkin.chevit.presentation.resource.icon.IconFilterFill
import com.dkin.chevit.presentation.resource.util.clickableNoRipple

@Composable
fun  ChecklistDetailTopBar(
    modifier: Modifier = Modifier,
    title: String,
    onClickBack: () -> Unit,
    onClickFilter: () -> Unit,
) {
    Row(
        modifier = modifier
            .height(58.dp)
            .padding(vertical = 16.dp, horizontal = 24.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier.clickableNoRipple { onClickBack() },
            imageVector = ChevitIcon.IconArrowLeftLine,
            contentDescription = "",
        )
        Text(
            modifier = Modifier.weight(1f),
            text = title,
            textAlign = TextAlign.Center,
            style = ChevitTheme.typhography.headlineMedium.copy(color = ChevitTheme.colors.textPrimary)
        )
        Icon(
            modifier = Modifier.clickableNoRipple { onClickFilter() },
            imageVector = ChevitIcon.IconFilterFill,
            contentDescription = "",
        )
    }
}