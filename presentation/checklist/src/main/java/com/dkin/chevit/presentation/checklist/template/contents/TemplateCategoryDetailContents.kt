package com.dkin.chevit.presentation.checklist.template.contents

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.dkin.chevit.presentation.checklist.detail.ChecklistDetailState
import com.dkin.chevit.presentation.checklist.template.model.TemplateCategoryDetailState
import com.dkin.chevit.presentation.resource.ChevitTextField
import com.dkin.chevit.presentation.resource.ChevitTheme
import com.dkin.chevit.presentation.resource.R
import com.dkin.chevit.presentation.resource.icon.ChevitIcon
import com.dkin.chevit.presentation.resource.icon.IconArrowLeftLine
import com.dkin.chevit.presentation.resource.icon.IconCheckboxCheckedBlue
import com.dkin.chevit.presentation.resource.icon.IconCheckboxUncheckedGrey
import com.dkin.chevit.presentation.resource.icon.IconCloseCircleFill
import com.dkin.chevit.presentation.resource.icon.IconMoreLine
import com.dkin.chevit.presentation.resource.icon.IconSearch
import com.dkin.chevit.presentation.resource.util.clickableNoRipple

@Composable
fun TemplateCategoryDetailContents(
    categoryDetail: TemplateCategoryDetailState,
    onClickBack: () -> Unit
) {
    var input by remember { mutableStateOf("") }
    var detailList by remember {
        mutableStateOf(categoryDetail.detailItems)
    }

    LaunchedEffect(input) {
        detailList = if (input.isNotBlank()) {
            categoryDetail.detailItems.filter { it.title.contains(input) }
        } else {
            categoryDetail.detailItems
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
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
                    text = categoryDetail.categoryName,
                    textAlign = TextAlign.Center,
                    style = ChevitTheme.typhography.headlineMedium.copy(color = ChevitTheme.colors.textPrimary)
                )
            }
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
                        categoryDetail.detailItems.isNotEmpty()
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
            }
            Spacer(modifier = Modifier.height(20.dp))
            if (detailList.isEmpty()) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(4.dp)
                        .background(color = ChevitTheme.colors.grey0)
                )
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Image(
                            modifier = Modifier
                                .size(130.dp),
                            painter = painterResource(id = R.drawable.ic_empty_checklist_detail),
                            contentDescription = "",
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                        Text(
                            text = "체크리스트 항목이 없어요.\n챙겨야 할 체크리스트를 추가해 보아요!",
                            textAlign = TextAlign.Center,
                            style = ChevitTheme.typhography.bodyLarge.copy(
                                color = ChevitTheme.colors.textSecondary
                            )
                        )
                    }
                }
            } else {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(4.dp)
                        .background(color = ChevitTheme.colors.grey0)
                )
                LazyColumn(
                    contentPadding = PaddingValues(bottom = 10.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                ) {
                    items(
                        count = detailList.size
                    ) {
                        DetailItem(item = detailList[it])
                    }
                }
            }
        }
    }
}

@Composable
private fun DetailItem(
    item: ChecklistDetailState.ChecklistDetailItem,
) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 20.dp),
            verticalAlignment = Alignment.Top
        ) {
            Box(
                modifier = Modifier
                    .size(24.dp)
                    .clip(CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    modifier = Modifier.fillMaxSize(),
                    imageVector = ChevitIcon.IconCheckboxUncheckedGrey,
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
                modifier = Modifier.size(24.dp),
                imageVector = ChevitIcon.IconMoreLine,
                contentDescription = item.title,
            )
            Spacer(modifier = Modifier.width(6.dp))
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(color = ChevitTheme.colors.grey3)
        )
    }
}