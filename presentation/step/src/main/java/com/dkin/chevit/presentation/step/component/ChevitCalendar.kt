package com.dkin.chevit.presentation.step.component

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.dkin.chevit.presentation.resource.ChevitTheme
import com.dkin.chevit.presentation.resource.icon.ChevitIcon
import com.dkin.chevit.presentation.resource.icon.IconArrowLeftLine
import com.dkin.chevit.presentation.resource.icon.IconArrowRight
import com.dkin.chevit.presentation.resource.util.clickableNoRipple
import com.dkin.chevit.presentation.step.StepState
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.YearMonth
import java.time.format.TextStyle
import java.util.Locale

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ChevitCalendar(
    modifier: Modifier,
    selectedDates: Pair<LocalDate?, LocalDate?>,
    setSelectDays: (Pair<LocalDate?, LocalDate?>) -> Unit
) {
    var monthState: YearMonth by remember { mutableStateOf(YearMonth.now()) }
    val daysOfWeek = remember { (DayOfWeek.values().takeLast(1) + DayOfWeek.values().dropLast(1)) }
    val pagerItemCount = 12 //1년만 가능
    val listState = rememberPagerState(initialPage = pagerItemCount)
    val weeks = monthState.getWeeks(
        firstDayOfTheWeek = daysOfWeek.first(),
        currentDay = LocalDate.now(),
        selectedDates = selectedDates
    )

    Column(modifier = modifier) {
        Box(
            modifier = Modifier.heightIn(min = 44.dp),
            contentAlignment = Alignment.Center
        ) {
            ChevitCalendarMonthHeader(
                month = monthState,
                onMonthChanged = { monthState = it }
            )
        }
        Row(
            modifier = Modifier.padding(vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            daysOfWeek.forEach { dayOfWeek ->
                Text(
                    modifier = Modifier
                        .weight(1f)
                        .padding(vertical = 12.dp),
                    text = dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.KOREA),
                    style = ChevitTheme.typhography.headlineSmall.copy(
                        color = when (dayOfWeek) {
                            DayOfWeek.SATURDAY -> ChevitTheme.colors.blue6
                            DayOfWeek.SUNDAY -> ChevitTheme.colors.statusCancel
                            else -> ChevitTheme.colors.textPrimary
                        }
                    ),
                    textAlign = TextAlign.Center
                )
            }
        }
        HorizontalPager(
            modifier = Modifier.fillMaxWidth(),
            state = listState,
            pageCount = pagerItemCount,
            userScrollEnabled = false
        ) {
            Column {
                weeks.forEach { week ->
                    ChevitCalendarWeekContent(
                        modifier = Modifier.fillMaxWidth(),
                        week = week
                    ) {
                        ChevitCalendarDayContent(it) { date ->
                            setSelectDays(getSelectedPeriod(selectedDates, date))
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun ChevitCalendarWeekContent(
    modifier: Modifier,
    week: ChevitWeek,
    dayContent: @Composable (ChevitDay) -> Unit = {}
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        horizontalArrangement = if (week.isFirstWeekOfMonth) Arrangement.End else Arrangement.Start
    ) {
        week.days.forEachIndexed { index, day ->
            Box(
                modifier = Modifier.fillMaxWidth(1f / (7 - index)),
                contentAlignment = Alignment.Center
            ) {
                dayContent(day)
            }
        }
    }
}


@Composable
private fun ChevitCalendarDayContent(
    day: ChevitDay,
    onClickItem: (LocalDate) -> Unit
) {
    val date = day.date
    val selectedDates = day.selectedDates
    val isStartSelected = selectedDates.first == date
    val isEndSelected = selectedDates.second == date
    val isSelectedPeriod = date.isInPeriod(selectedDates.first, selectedDates.second)
    val isPeriod = selectedDates.first != null && selectedDates.second != null
    val backgroundModifier = when {
        isSelectedPeriod -> {
            if (isPeriod) {
                if (isStartSelected && isEndSelected) {
                    Modifier
                        .size(32.dp)
                        .background(
                            shape = CircleShape,
                            color = ChevitTheme.colors.blue6
                        )
                } else if (isStartSelected) {
                    Modifier
                        .fillMaxWidth()
                        .background(
                            shape = RoundedCornerShape(topStart = 100.dp, bottomStart = 100.dp),
                            color = ChevitTheme.colors.blue6
                        )
                } else if (isEndSelected) {
                    Modifier
                        .fillMaxWidth()
                        .background(
                            shape = RoundedCornerShape(topEnd = 100.dp, bottomEnd = 100.dp),
                            color = ChevitTheme.colors.blue6
                        )
                } else {
                    Modifier
                        .fillMaxWidth()
                        .background(
                            color = ChevitTheme.colors.blue6
                        )
                }
            } else Modifier.fillMaxWidth()
        }

        isStartSelected -> Modifier
            .size(32.dp)
            .background(
                shape = CircleShape,
                color = ChevitTheme.colors.blue6
            )

        else -> Modifier.fillMaxWidth()
    }
    Box(modifier = Modifier.padding(vertical = 6.dp), contentAlignment = Alignment.Center) {
        Box(
            modifier = backgroundModifier.padding(vertical = 6.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                modifier = Modifier.clickableNoRipple { onClickItem(date) },
                text = date.dayOfMonth.toString(),
                color = if (isStartSelected || isSelectedPeriod || isEndSelected) ChevitTheme.colors.white else ChevitTheme.colors.black
            )
        }
    }
}

@Composable
private fun ChevitCalendarMonthHeader(
    month: YearMonth,
    modifier: Modifier = Modifier,
    onMonthChanged: (YearMonth) -> Unit = {}
) {
    val title = "${month.year}년 ${month.month.value}월"

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier.clickableNoRipple { onMonthChanged(month.minusMonths(1)) },
            imageVector = ChevitIcon.IconArrowLeftLine,
            contentDescription = "",
            tint = ChevitTheme.colors.blue7
        )
        Text(
            modifier = Modifier.weight(1f),
            text = title,
            textAlign = TextAlign.Center,
            style = ChevitTheme.typhography.headlineMedium.copy(color = ChevitTheme.colors.textPrimary)
        )
        Icon(
            modifier = Modifier.clickableNoRipple { onMonthChanged(month.plusMonths(1)) },
            imageVector = ChevitIcon.IconArrowRight,
            contentDescription = "",
            tint = ChevitTheme.colors.blue7
        )
    }
}

private fun YearMonth.getWeeks(
    firstDayOfTheWeek: DayOfWeek,
    currentDay: LocalDate,
    selectedDates: Pair<LocalDate?, LocalDate?>
): List<ChevitWeek> {
    val daysLength = lengthOfMonth()
    val start = atDay(1).dayOfWeek daysUntil firstDayOfTheWeek
    val end = 7 - (atDay(daysLength).dayOfWeek daysUntil firstDayOfTheWeek) - 1

    return (1 - start..daysLength + end).chunked(7).mapIndexed { index, days ->
        ChevitWeek(
            isFirstWeekOfMonth = index == 0,
            days = days.mapNotNull {
                val date = when (it) {
                    in Int.MIN_VALUE..0 -> return@mapNotNull null
                    in 1..daysLength -> atDay(it)
                    else -> return@mapNotNull null
                }
                ChevitDay(
                    selectedDates = selectedDates,
                    date = date,
                    isCurrentDay = date.equals(currentDay)
                )
            }
        )
    }
}

private infix fun DayOfWeek.daysUntil(other: DayOfWeek) = (7 + (value - other.value)) % 7

private fun LocalDate.isInPeriod(startDate: LocalDate?, endDate: LocalDate?): Boolean {
    return if (startDate == null || endDate == null) false
    else if (startDate == this) true
    else if (endDate == this) true
    else startDate.isBefore(this) && endDate.isAfter(this)
}

private fun getSelectedPeriod(
    selectedDates: Pair<LocalDate?, LocalDate?>,
    clickedDate: LocalDate
): Pair<LocalDate?, LocalDate?> {
    return if (selectedDates.first == null || selectedDates.first?.isAfter(clickedDate) == true) Pair(
        clickedDate,
        null
    )
    else if (selectedDates.second != null) Pair(clickedDate, null)
    else Pair(selectedDates.first, clickedDate)
}

@Stable
data class ChevitWeek(
    val isFirstWeekOfMonth: Boolean = false,
    val days: List<ChevitDay>
)

@Stable
data class ChevitDay(
    val selectedDates: Pair<LocalDate?, LocalDate?>,
    val date: LocalDate,
    val isCurrentDay: Boolean,
)