package com.dkin.chevit.presentation.checklist.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.unit.dp
import com.dkin.chevit.presentation.checklist.detail.component.ChecklistDetailEditTopBar
import com.dkin.chevit.presentation.resource.ChevitButtonFillMedium
import com.dkin.chevit.presentation.resource.ChevitTextField
import com.dkin.chevit.presentation.resource.ChevitTheme
import com.dkin.chevit.presentation.resource.icon.ChevitIcon
import com.dkin.chevit.presentation.resource.icon.IconAddFill
import com.dkin.chevit.presentation.resource.icon.IconCloseCircleFill
import com.dkin.chevit.presentation.resource.icon.IconMinusFill
import com.dkin.chevit.presentation.resource.util.clickableNoRipple

@Composable
fun EditItemScreen(
    viewModel: ChecklistDetailViewModel,
    onClickBack: () -> Unit,
    itemId: String,
    savedTitle: String,
    savedMemo: String,
    savedCount: Int
) {
    var title by remember { mutableStateOf(savedTitle) }
    var memo by remember { mutableStateOf(savedMemo) }
    var count by remember { mutableStateOf(savedCount) }
    var isValidInput by remember { mutableStateOf(false) }

    LaunchedEffect(title) {
        isValidInput = title.isNotBlank() && title.length < 16 && memo.length < 21
    }

    Column(modifier = Modifier.fillMaxSize()) {
        ChecklistDetailEditTopBar(
            modifier = Modifier.fillMaxWidth(),
            title = "체크리스트 수정하기",
            onClickBack = onClickBack,
        )
        Spacer(modifier = Modifier.height(25.dp))
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 24.dp)
        ) {
            Text(
                text = "아이템",
                style = ChevitTheme.typhography.headlineMedium.copy(color = ChevitTheme.colors.textPrimary),
            )
            Spacer(modifier = Modifier.height(18.dp))
            Text(
                text = "챙겨야 할 아이템을 입력해 주세요.",
                style = ChevitTheme.typhography.bodyMedium.copy(color = ChevitTheme.colors.grey6),
            )
            Spacer(modifier = Modifier.height(8.dp))
            ChevitTextField(
                modifier = Modifier.fillMaxWidth(),
                value = title,
                onValueChange = {
                    title = it
                },
                placeholder = {
                    Text(
                        modifier = Modifier,
                        text = "ex. 여권 (최대 15글자)",
                        style = ChevitTheme.typhography.bodyLarge.copy(color = ChevitTheme.colors.grey4),
                    )
                },
                trailingIcon = {
                    if (title.isNotEmpty()) {
                        Icon(
                            modifier = Modifier
                                .size(20.dp)
                                .clickableNoRipple {
                                    title = ""
                                },
                            imageVector = ChevitIcon.IconCloseCircleFill,
                            contentDescription = "",
                        )
                    }
                }
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "메모",
                style = ChevitTheme.typhography.headlineMedium.copy(color = ChevitTheme.colors.textPrimary),
            )
            Spacer(modifier = Modifier.height(18.dp))
            Text(
                text = "필요시, 기억해야할 내용을 입력해 주세요.",
                style = ChevitTheme.typhography.bodyMedium.copy(color = ChevitTheme.colors.grey6),
            )
            Spacer(modifier = Modifier.height(8.dp))
            ChevitTextField(
                modifier = Modifier.fillMaxWidth(),
                value = memo,
                maxLines = 2,
                onValueChange = {
                    memo = it
                },
                placeholder = {
                    Text(
                        modifier = Modifier,
                        text = "ex. 프린트하기 (최대 20글자)",
                        style = ChevitTheme.typhography.bodyLarge.copy(color = ChevitTheme.colors.grey4),
                    )
                },
                trailingIcon = {
                    if (memo.isNotEmpty()) {
                        Icon(
                            modifier = Modifier
                                .size(20.dp)
                                .clickableNoRipple {
                                    memo = ""
                                },
                            imageVector = ChevitIcon.IconCloseCircleFill,
                            contentDescription = "",
                        )
                    }
                }
            )

            Spacer(modifier = Modifier.height(32.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    modifier = Modifier.weight(1f),
                    text = "수량",
                    style = ChevitTheme.typhography.headlineMedium.copy(color = ChevitTheme.colors.textPrimary),
                )
                Row(
                    modifier = Modifier
                        .clip(RoundedCornerShape(6.dp))
                        .background(color = ChevitTheme.colors.grey0)
                        .padding(1.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .padding(3.dp)
                            .clickableNoRipple { if (count > 1) count -= 1 }
                    ) {
                        Icon(
                            modifier = Modifier.size(24.dp),
                            imageVector = ChevitIcon.IconMinusFill,
                            contentDescription = "",
                            tint = ChevitTheme.colors.grey3,
                        )
                    }
                    Spacer(modifier = Modifier.width(1.dp))
                    Box(
                        modifier = Modifier
                            .heightIn(min = 32.dp)
                            .background(color = ChevitTheme.colors.white)
                            .padding(horizontal = 19.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "$count",
                            style = ChevitTheme.typhography.bodyLarge.copy(color = ChevitTheme.colors.textSecondary),
                        )
                    }
                    Spacer(modifier = Modifier.width(1.dp))
                    Box(
                        modifier = Modifier
                            .padding(3.dp)
                            .clickableNoRipple { if (count < 1000) count += 1 }
                    ) {
                        Icon(
                            modifier = Modifier.size(24.dp),
                            imageVector = ChevitIcon.IconAddFill,
                            contentDescription = "",
                            tint = ChevitTheme.colors.grey3,
                        )
                    }
                }
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
        ) {
            ChevitButtonFillMedium(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(54.dp),
                enabled = isValidInput,
                onClick = {
                    viewModel.editItem(
                        itemId = itemId,
                        title = title,
                        memo = memo,
                        count = count
                    )
                }
            ) {
                Text(text = "수정하기")
            }
        }
        Spacer(modifier = Modifier.height(24.dp))
    }
}