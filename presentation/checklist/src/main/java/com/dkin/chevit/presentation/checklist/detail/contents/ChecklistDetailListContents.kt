package com.dkin.chevit.presentation.checklist.detail.contents

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.dkin.chevit.presentation.checklist.detail.ChecklistDetailState
import com.dkin.chevit.presentation.resource.ChevitFloatingButton
import com.dkin.chevit.presentation.resource.ChevitTheme
import com.dkin.chevit.presentation.resource.icon.ChevitIcon
import com.dkin.chevit.presentation.resource.icon.IconCheckboxCheckedBlue
import com.dkin.chevit.presentation.resource.icon.IconCheckboxUncheckedGrey
import com.dkin.chevit.presentation.resource.icon.IconMoreLine
import com.dkin.chevit.presentation.resource.util.clickableNoRipple

@Composable
fun ChecklistDetailListContents(
    detailItems: List<ChecklistDetailState.ChecklistDetailItem>,
    checkUnCompleted: Boolean,
    onClickItem: (itemId: String) -> Unit,
    navigateAddItem: () -> Unit,
    openMoreSheet: (itemId: String, title: String, memo: String, count: Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val detailList = if (checkUnCompleted) {
        detailItems.filter { !it.checked }
    } else {
        detailItems
    }
    val listState = rememberLazyListState()
    Column(modifier = modifier.fillMaxWidth()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(4.dp)
                .background(color = ChevitTheme.colors.grey0)
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            LazyColumn(
                state = listState,
                contentPadding = PaddingValues(bottom = 10.dp),
            ) {
                items(
                    count = detailList.size
                ) {
                    DetailItem(item = detailList[it], onClickItem, openMoreSheet)
                    DetailItemDivider()
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 24.dp, end = 24.dp)
                    .align(Alignment.BottomEnd)
            ) {
                ChevitFloatingButton(
                    modifier = Modifier.align(Alignment.BottomEnd),
                    onClick = { navigateAddItem() }
                )
            }
        }
    }
}

@Composable
private fun DetailItem(
    item: ChecklistDetailState.ChecklistDetailItem,
    onClickItem: (itemId: String) -> Unit,
    openMoreSheet: (itemId: String, title: String, memo: String, count: Int) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 20.dp),
        verticalAlignment = Alignment.Top
    ) {
        Box(
            modifier = Modifier
                .size(24.dp)
                .clip(CircleShape)
                .clickable { onClickItem(item.id) },
            contentAlignment = Alignment.Center
        ) {
            Image(
                modifier = Modifier.fillMaxSize(),
                imageVector = if (item.checked) ChevitIcon.IconCheckboxCheckedBlue else ChevitIcon.IconCheckboxUncheckedGrey,
                contentDescription = "",
            )
        }
        Spacer(modifier = Modifier.width(10.dp))
        Column(Modifier.weight(1f)) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = if (item.count > 1) "${item.title} ${item.count}" else item.title,
                style = ChevitTheme.typhography.bodyLarge.copy(color = ChevitTheme.colors.textPrimary),
                overflow = TextOverflow.Ellipsis,
                maxLines = 1
            )
            if (item.memo.isNotBlank()) {
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = item.memo,
                    style = ChevitTheme.typhography.bodySmall.copy(color = ChevitTheme.colors.grey5),
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1
                )
            }
        }
        Spacer(modifier = Modifier.width(12.dp))
        Icon(
            modifier = Modifier
                .size(24.dp)
                .clickableNoRipple { openMoreSheet(item.id, item.title, item.memo, item.count) },
            imageVector = ChevitIcon.IconMoreLine,
            contentDescription = item.title,
        )
        Spacer(modifier = Modifier.width(6.dp))
    }
}

@Composable
private fun DetailItemDivider() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(1.dp)
            .background(color = ChevitTheme.colors.grey3)
    )
}