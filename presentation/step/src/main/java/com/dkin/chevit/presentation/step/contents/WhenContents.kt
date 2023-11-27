package com.dkin.chevit.presentation.step.contents

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.unit.dp
import com.dkin.chevit.presentation.resource.ChevitButtonFillLarge
import com.dkin.chevit.presentation.resource.ChevitTagLabel
import com.dkin.chevit.presentation.resource.ChevitTheme
import com.dkin.chevit.presentation.resource.icon.ChevitIcon
import com.dkin.chevit.presentation.resource.icon.IconCheckboxCircleFill
import com.dkin.chevit.presentation.step.StepViewModel
import com.dkin.chevit.presentation.step.component.ChevitCalendar
import java.time.LocalDate

@Composable
fun WhenContents(
    modifier: Modifier,
    viewModel: StepViewModel,
    onClickNext: () -> Unit
) {
    val stepState by viewModel.state.collectAsState()
    var selectedDates: Pair<LocalDate?, LocalDate?> by remember { mutableStateOf(Pair(null, null)) }

    Column(modifier) {
        Spacer(modifier = Modifier.height(28.dp))
        ChevitTagLabel(text = stepState.getWhereLabel())
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            modifier = Modifier,
            text = if (selectedDates.first == null) "언제 떠나시나요?" else "언제 돌아오시나요?",
            style = ChevitTheme.typhography.headlineLarge.copy(color = ChevitTheme.colors.textPrimary)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            if (selectedDates.first != null) {
                Image(
                    modifier = Modifier.size(20.dp),
                    imageVector = ChevitIcon.IconCheckboxCircleFill,
                    contentDescription = "",
                )
                Spacer(modifier = Modifier.width(4.dp))
            }
            Text(
                modifier = Modifier,
                text = getWhenText(selectedDates.first, selectedDates.second),
                style = ChevitTheme.typhography.bodyLarge.copy(color = ChevitTheme.colors.textSecondary)
            )
        }

        Spacer(Modifier.height(42.dp))

        Box(modifier = Modifier.weight(1f)) {
            ChevitCalendar(modifier.fillMaxWidth(), selectedDates) {
                selectedDates = it
            }
        }
        ChevitButtonFillLarge(
            modifier = Modifier.fillMaxWidth(),
            enabled = selectedDates.first != null && selectedDates.second != null,
            onClick = {
                viewModel.setTravelWhen(selectedDates)
                onClickNext()
            }
        ) {
            Text(text = "다음")
        }
    }
}

private fun getWhenText(startDate: LocalDate?, endDate: LocalDate?): String {
    return if (startDate == null) {
        "여행 일정을 선택해 주세요."
    } else if (endDate == null) {
        val startYear = startDate.year.toString()
        val startMonth = startDate.month?.value.toString()
        val startDay = startDate.dayOfMonth.toString()
        "${startYear}.${startMonth}.${startDay}"
    } else {
        val startYear = startDate.year.toString()
        val startMonth = startDate.month?.value.toString()
        val startDay = startDate.dayOfMonth.toString()
        val endYear = endDate.year.toString()
        val endMonth = endDate.month?.value.toString()
        val endDay = endDate.dayOfMonth.toString()
        "${startYear}.${startMonth}.${startDay} ~ ${endYear}.${endMonth}.${endDay}"
    }
}