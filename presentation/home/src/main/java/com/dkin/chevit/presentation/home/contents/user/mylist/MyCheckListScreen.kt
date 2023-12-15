package com.dkin.chevit.presentation.home.contents.user.mylist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.dkin.chevit.presentation.home.HomeState
import com.dkin.chevit.presentation.home.contents.component.EmptyChecklist
import com.dkin.chevit.presentation.home.contents.component.MyChecklistItem
import com.dkin.chevit.presentation.home.model.CheckListItem
import com.dkin.chevit.presentation.resource.ChevitTheme
import com.dkin.chevit.presentation.resource.icon.ChevitIcon
import com.dkin.chevit.presentation.resource.icon.IconArrowLeftLine
import com.dkin.chevit.presentation.resource.util.clickableNoRipple

@Composable
fun MyCheckListScreen(
    onClickBack: () -> Unit,
    checkList: List<CheckListItem>,
    onClickChecklist: (id: String) -> Unit,
    onLongClickChecklist: (id: String, title: String) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
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
                text = "내 체크리스트",
                textAlign = TextAlign.Center,
                style = ChevitTheme.typhography.headlineMedium.copy(color = ChevitTheme.colors.textPrimary)
            )
        }
        if (checkList.isEmpty()) {
            EmptyChecklist(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            )
        } else {
            val listState = rememberLazyListState()
            Spacer(modifier = Modifier.height(24.dp))
            Row(
                modifier = Modifier.padding(horizontal = 24.dp)
            ) {
                Text(
                    text = "체크리스트",
                    textAlign = TextAlign.Start,
                    style = ChevitTheme.typhography.headlineMedium.copy(color = ChevitTheme.colors.textPrimary)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "${checkList.size}",
                    textAlign = TextAlign.Start,
                    style = ChevitTheme.typhography.headlineMedium.copy(color = ChevitTheme.colors.blue7)
                )
            }
            LazyColumn(
                state = listState,
                contentPadding = PaddingValues(top = 24.dp, bottom = 14.dp, start = 24.dp, end = 24.dp),
                verticalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                items(count = checkList.size) {
                    MyChecklistItem(
                        item = checkList[it],
                        onClickItem = { id -> onClickChecklist(id) },
                        onLongClickItem = { id, title -> onLongClickChecklist(id, title) }
                    )
                }
            }
        }

    }
}