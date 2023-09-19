package com.dkin.chevit.presentation.resource

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.dkin.chevit.presentation.resource.util.textDp

@Composable
fun ChevitTagLabel(
    modifier: Modifier = Modifier,
    text: String
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(2.dp))
            .background(color = Color.Transparent)
            .border(1.dp, ChevitTheme.colors.grey3)
            .padding(horizontal = 8.dp, vertical = 1.dp)
    ) {
        Text(
            text = text,
            fontSize = 11.textDp,
            fontWeight = FontWeight.Normal,
            color = ChevitTheme.colors.textSecondary,
            lineHeight = 18.textDp
        )
    }
}

@Composable
internal fun ChevitLabel(
    text: String,
    backgroundColor: Color,
    onClick: () -> Unit,
) {
    Box(
        modifier = Modifier
            .padding(horizontal = 14.dp, vertical = 4.dp)
            .background(color = backgroundColor, shape = RoundedCornerShape(100.dp))
            .clickable { onClick() },
    ) {
        Text(
            text = text,
            style = ChevitTheme.typhography.bodySmall.copy(color = ChevitTheme.colors.white),
        )
    }
}
