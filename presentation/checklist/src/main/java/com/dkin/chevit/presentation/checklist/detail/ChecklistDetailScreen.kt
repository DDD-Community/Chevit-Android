package com.dkin.chevit.presentation.checklist.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.dkin.chevit.presentation.checklist.detail.component.ChecklistDetailTopBar
import com.dkin.chevit.presentation.checklist.detail.contents.ChecklistDetailEmptyContents
import com.dkin.chevit.presentation.checklist.detail.contents.ChecklistDetailListContents
import com.dkin.chevit.presentation.resource.ChevitTextField
import com.dkin.chevit.presentation.resource.ChevitTheme
import com.dkin.chevit.presentation.resource.icon.ChevitIcon
import com.dkin.chevit.presentation.resource.icon.IconCheckboxCheckedBlue
import com.dkin.chevit.presentation.resource.icon.IconCheckboxCheckedGrey
import com.dkin.chevit.presentation.resource.icon.IconCloseCircleFill
import com.dkin.chevit.presentation.resource.icon.IconSearch
import com.dkin.chevit.presentation.resource.util.clickableNoRipple

@Composable
fun ChecklistDetailScreen(
    viewModel: ChecklistDetailViewModel,
    onClickBack: () -> Boolean,
    navigateAddItem: () -> Unit,
    openSortSheet: () -> Unit,
    openMoreSheet: (itemId: String, title: String) -> Unit,
) {
    val detailState by viewModel.state.collectAsState()
    var input by remember { mutableStateOf("") }
    var checkUnCompleted by rememberSaveable { mutableStateOf(false) }

    LaunchedEffect(input) {
        viewModel.searchItem(input)
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            ChecklistDetailTopBar(
                title = detailState.title,
                onClickBack = { onClickBack() },
                onClickFilter = { openSortSheet() }
            )
            Spacer(modifier = Modifier.height(20.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
            ) {
                ChevitTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = input,
                    onValueChange = {
                        detailState.detailItems.isNotEmpty()
                        input = it
                    },
                    placeholder = {
                        Text(
                            modifier = Modifier,
                            text = "찾고싶은 아이템을 검색해 보세요.",
                            style = ChevitTheme.typhography.bodyLarge.copy(color = ChevitTheme.colors.grey4),
                        )
                    },
                    leadingIcon = {
                        Icon(
                            modifier = Modifier.size(24.dp),
                            imageVector = ChevitIcon.IconSearch,
                            contentDescription = "",
                        )
                    },
                    trailingIcon = {
                        if (input.isNotEmpty()) {
                            Icon(
                                modifier = Modifier
                                    .size(20.dp)
                                    .clickableNoRipple {
                                        input = ""
                                    },
                                imageVector = ChevitIcon.IconCloseCircleFill,
                                contentDescription = "",
                            )
                        }
                    }
                )
                if (detailState.detailItems.isNotEmpty()) {

                }
            }
            if (detailState.detailItems.isEmpty()) {
                Spacer(modifier = Modifier.height(56.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(4.dp)
                        .background(color = ChevitTheme.colors.grey0)
                )
                ChecklistDetailEmptyContents(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                )
            } else {
                Spacer(modifier = Modifier.height(20.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(20.dp)
                            .clip(CircleShape)
                            .clickable {
                                checkUnCompleted = !checkUnCompleted
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            modifier = Modifier.fillMaxSize(),
                            imageVector = if (checkUnCompleted) ChevitIcon.IconCheckboxCheckedBlue else ChevitIcon.IconCheckboxCheckedGrey,
                            contentDescription = "",
                        )
                    }
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "미달성 항목만 보기",
                        style = ChevitTheme.typhography.bodySmall.copy(color = ChevitTheme.colors.textSecondary),
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                ChecklistDetailListContents(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    detailItems = detailState.detailItems,
                    checkUnCompleted = checkUnCompleted,
                    onClickItem = { itemId -> viewModel.checkItem(itemId) },
                    navigateAddItem = navigateAddItem,
                    openMoreSheet = openMoreSheet
                )
            }
        }
    }
}
