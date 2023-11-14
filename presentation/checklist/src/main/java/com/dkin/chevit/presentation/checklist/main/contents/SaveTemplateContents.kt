package com.dkin.chevit.presentation.checklist.main.contents

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
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
import com.dkin.chevit.presentation.resource.ChevitButtonFillLarge
import com.dkin.chevit.presentation.resource.ChevitTextField
import com.dkin.chevit.presentation.resource.ChevitTheme
import com.dkin.chevit.presentation.resource.TemplateColor
import com.dkin.chevit.presentation.resource.icon.ChevitIcon
import com.dkin.chevit.presentation.resource.icon.IconCloseCircleFill
import com.dkin.chevit.presentation.resource.icon.IconCloseFill
import com.dkin.chevit.presentation.resource.icon.IconCheckFill
import com.dkin.chevit.presentation.resource.util.clickableNoRipple

@Composable
fun SaveTemplateContents(
    saveTemplate: (title: String, color: TemplateColor) -> Unit,
    onClose: () -> Unit
) {
    var input by remember { mutableStateOf("") }
    var isValidInput by remember { mutableStateOf(false) }
    var selectedColor by remember { mutableStateOf(TemplateColor.DAWN) }

    LaunchedEffect(input) {
        isValidInput = input.isNotBlank() && input.length < 18
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp))
                .background(color = ChevitTheme.colors.white)
                .padding(horizontal = 24.dp, vertical = 30.dp)
        ) {
            Icon(
                modifier = Modifier
                    .align(Alignment.End)
                    .clickableNoRipple { onClose() },
                imageVector = ChevitIcon.IconCloseFill,
                contentDescription = "",
            )
            Text(
                text = "템플릿으로 저장하기",
                style = ChevitTheme.typhography.headlineMedium.copy(color = ChevitTheme.colors.textPrimary),
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "템플릿 제목을 입력해 주세요.",
                style = ChevitTheme.typhography.bodyMedium.copy(color = ChevitTheme.colors.grey6),
            )
            Spacer(modifier = Modifier.height(8.dp))
            ChevitTextField(
                modifier = Modifier.fillMaxWidth(),
                value = input,
                onValueChange = {
                    input = it
                },
                placeholder = {
                    Text(
                        modifier = Modifier,
                        text = "ex. 자주 빠뜨리는 것",
                        style = ChevitTheme.typhography.bodyLarge.copy(color = ChevitTheme.colors.grey4),
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

            Spacer(modifier = Modifier.height(32.dp))
            Text(
                text = "템플릿 색상을 선택해 주세요.",
                style = ChevitTheme.typhography.bodyMedium.copy(color = ChevitTheme.colors.grey6),
            )
            Spacer(modifier = Modifier.height(12.dp))

            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(TemplateColor.values()) {
                    val isSelected = selectedColor == it
                    Box(
                        modifier = Modifier
                            .size(42.dp)
                            .clip(CircleShape)
                            .background(color = it.color, shape = CircleShape)
                            .clickableNoRipple {
                                selectedColor = it
                            }
                    ) {
                        if (isSelected) {
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .clip(CircleShape)
                                    .background(color = ChevitTheme.colors.dimThin),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = ChevitIcon.IconCheckFill,
                                    contentDescription = "",
                                    tint = ChevitTheme.colors.white
                                )
                            }
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(30.dp))
            ChevitButtonFillLarge(
                modifier = Modifier.fillMaxWidth(),
                enabled = isValidInput,
                onClick = { saveTemplate(input, selectedColor) }
            ) {
                Text(text = "확인")
            }
        }
    }
}