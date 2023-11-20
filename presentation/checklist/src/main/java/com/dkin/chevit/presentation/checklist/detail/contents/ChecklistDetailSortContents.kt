package com.dkin.chevit.presentation.checklist.detail.contents

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.dkin.chevit.presentation.checklist.detail.model.SortType
import com.dkin.chevit.presentation.resource.ChevitBottomsheet
import com.dkin.chevit.presentation.resource.ChevitTheme
import com.dkin.chevit.presentation.resource.icon.ChevitIcon
import com.dkin.chevit.presentation.resource.icon.IconCheckFill

@Composable
fun ChecklistDetailSortContents(
    selectedType: SortType,
    onClickType: (type: SortType) -> Unit,
    onClose: () -> Unit
) {
    ChevitBottomsheet(
        modifier = Modifier.fillMaxSize(),
        onClickBackground = onClose
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            SortType.values().forEach {
                SortItem(type = it, selected = selectedType == it, onClickType = onClickType)
            }
        }
    }
}

@Composable
private fun SortItem(type: SortType, selected: Boolean, onClickType: (type: SortType) -> Unit) {
    Column(modifier = Modifier.clickable { onClickType(type) }) {
        Spacer(modifier = Modifier.height(16.dp))
        Row {
            Text(
                modifier = Modifier.weight(1f),
                text = type.title,
                style = if (selected) {
                    ChevitTheme.typhography.headlineSmall.copy(color = ChevitTheme.colors.textPrimary)
                } else {
                    ChevitTheme.typhography.bodyLarge.copy(color = ChevitTheme.colors.textCaption)
                },
                overflow = TextOverflow.Ellipsis,
                maxLines = 1
            )
            if (selected) {
                Icon(
                    imageVector = ChevitIcon.IconCheckFill,
                    contentDescription = "",
                    tint = ChevitTheme.colors.black
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(1.dp)
            .background(color = ChevitTheme.colors.grey0)
    )
}