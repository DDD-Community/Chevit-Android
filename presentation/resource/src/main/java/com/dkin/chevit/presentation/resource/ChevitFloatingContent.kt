package com.dkin.chevit.presentation.resource

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

@Composable
fun ChevitFloatingContent(
    contentList: List<FloatingContentItem>
) {
    Column(
        modifier = Modifier
            .widthIn(max = 186.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(
                color = ChevitTheme.colors.white,
                shape = RoundedCornerShape(12.dp),
            )
    ) {
        contentList.forEachIndexed { index, item ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { item.onClick() }
                    .padding(horizontal = 18.dp, vertical = 14.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = item.icon,
                    contentDescription = item.title,
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = item.title,
                    style = ChevitTheme.typhography.bodyMedium.copy(color = ChevitTheme.colors.textPrimary),
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1
                )
            }
            if (index + 1 < contentList.size) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(color = ChevitTheme.colors.grey1)
                )
            }
        }
    }
}

data class FloatingContentItem(
    val icon: ImageVector,
    val title: String,
    val onClick: () -> Unit
)