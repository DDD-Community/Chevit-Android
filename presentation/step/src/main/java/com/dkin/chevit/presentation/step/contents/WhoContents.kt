package com.dkin.chevit.presentation.step.contents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.dkin.chevit.presentation.resource.ChevitButtonChip
import com.dkin.chevit.presentation.resource.ChevitButtonFillLarge
import com.dkin.chevit.presentation.resource.ChevitButtonLineLarge
import com.dkin.chevit.presentation.resource.ChevitTagLabel
import com.dkin.chevit.presentation.resource.ChevitTheme
import com.dkin.chevit.presentation.resource.util.clickableNoRipple
import com.dkin.chevit.presentation.step.StepIntent
import com.dkin.chevit.presentation.step.StepViewModel
import com.dkin.chevit.presentation.step.model.TravelWith

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun WhoContents(
    modifier: Modifier,
    viewModel: StepViewModel,
    onClickNext: () -> Unit
) {
    val stepState by viewModel.state.collectAsState()
    var showList by remember { mutableStateOf(false) }

    Column(modifier) {
        Spacer(modifier = Modifier.height(28.dp))
        Row {
            ChevitTagLabel(text = stepState.getWhereLabel())
            Spacer(Modifier.width(6.dp))
            ChevitTagLabel(text = stepState.getWhenLabel())
        }
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            modifier = Modifier,
            text = "누구와 함께 떠나시나요?",
            style = ChevitTheme.typhography.headlineLarge.copy(color = ChevitTheme.colors.textPrimary)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            modifier = Modifier,
            text = "여행 인원을 선택해 주세요.",
            style = ChevitTheme.typhography.bodyLarge.copy(color = ChevitTheme.colors.textSecondary)
        )
        Spacer(modifier = Modifier.height(24.dp))
        ChevitButtonLineLarge(
            modifier = Modifier.fillMaxWidth(),
            enabled = true,
            selected = stepState.travelWith.indexOf(TravelWith.ALONE) > -1,
            onClick = {
                showList = false
                viewModel.setTravelWith(TravelWith.ALONE)
            }
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Start,
                text = "\uD83D\uDE4B 혼자 가요!",
                style = ChevitTheme.typhography.headlineSmall
            )
        }
        Spacer(modifier = Modifier.height(12.dp))
        ChevitButtonLineLarge(
            modifier = Modifier.fillMaxWidth(),
            enabled = true,
            selected = showList,
            onClick = {
                if (!showList) {
                    viewModel.clearTravelWith()
                }
                showList = true
            }
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Start,
                text = "\uD83D\uDC68\u200D\uD83D\uDC69\u200D\uD83D\uDC66 동반자가 있어요!",
                style = ChevitTheme.typhography.headlineSmall
            )
        }
        Spacer(modifier = Modifier.height(24.dp))
        Column(modifier = Modifier.weight(1f)) {
            if (showList) {
                FlowRow(modifier = Modifier.fillMaxWidth()) {
                    TravelWith.values().iterator().forEach {
                        if (it != TravelWith.ALONE) {
                            Row {
                                ChevitButtonChip(
                                    text = it.text,
                                    selected = stepState.travelWith.indexOf(it) > -1,
                                    onClick = { viewModel.setTravelWith(it) }
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                            }
                        }
                    }
                }
            }
        }
        Text(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .clickableNoRipple { viewModel.dispatch(StepIntent.CreateChecklist(false)) },
            text = "추천없이 만들기",
            style = ChevitTheme.typhography.bodyMedium.copy(color = ChevitTheme.colors.textCaption),
            textAlign = TextAlign.Center,
        )
        Spacer(modifier = Modifier.height(12.dp))
        ChevitButtonFillLarge(
            modifier = Modifier.fillMaxWidth(),
            onClick = onClickNext,
            enabled = stepState.travelWith.isNotEmpty()
        ) {
            Text(text = "다음")
        }
    }
}