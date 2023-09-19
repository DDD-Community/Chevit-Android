package com.dkin.chevit.presentation.step.contents

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dkin.chevit.presentation.resource.ChevitButtonFillLarge
import com.dkin.chevit.presentation.resource.ChevitTagLabel
import com.dkin.chevit.presentation.resource.ChevitTheme
import com.dkin.chevit.presentation.step.StepViewModel

@Composable
fun WhatContents(
    modifier: Modifier,
    viewModel: StepViewModel,
    onClickNext: () -> Unit
) {
    val stepState by viewModel.state.collectAsState()

    Column(modifier) {
        Spacer(modifier = Modifier.height(28.dp))
        Row {
            ChevitTagLabel(text = stepState.getWhereLabel())
            Spacer(Modifier.width(6.dp))
            ChevitTagLabel(text = stepState.getWhenLabel())
            Spacer(Modifier.width(6.dp))
            ChevitTagLabel(text = stepState.getWhoLabel())
        }
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            modifier = Modifier,
            text = "어떤 여행을 떠나시나요?",
            style = ChevitTheme.typhography.headlineLarge.copy(color = ChevitTheme.colors.textPrimary)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            modifier = Modifier,
            text = "여행 유형을 선택해 주세요.",
            style = ChevitTheme.typhography.bodyLarge.copy(color = ChevitTheme.colors.textSecondary)
        )
        Box(modifier = Modifier.weight(1f)){}
        ChevitButtonFillLarge(
            modifier = Modifier.fillMaxWidth(),
            onClick = onClickNext
        ) {
            Text(text = "다음")
        }
    }
}