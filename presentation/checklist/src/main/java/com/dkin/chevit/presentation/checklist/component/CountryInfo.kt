package com.dkin.chevit.presentation.checklist.component

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.dkin.chevit.presentation.checklist.ChecklistState
import com.dkin.chevit.presentation.resource.ChevitTheme
import com.dkin.chevit.presentation.resource.util.clickableNoRipple

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CountryInfo(
    notice: ChecklistState.Notice,
    weathers: List<ChecklistState.Weather>,
    weatherDetailUrl: String,
    onClickUrl: (url: String) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (notice.title.isNotBlank()) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
                    .background(
                        color = ChevitTheme.colors.white,
                        shape = RoundedCornerShape(12.dp),
                    )
                    .border(
                        width = 1.dp,
                        color = ChevitTheme.colors.grey2,
                        shape = RoundedCornerShape(12.dp),
                    )
                    .clickable { onClickUrl(notice.url) }
                    .padding(horizontal = 24.dp, vertical = 14.dp)
            ) {
                Notice(notice.title)
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        if (weathers.isNotEmpty()) {
            val pagerState = rememberPagerState(initialPage = 0)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
                    .background(
                        color = ChevitTheme.colors.white,
                        shape = RoundedCornerShape(12.dp),
                    )
                    .border(
                        width = 1.dp,
                        color = ChevitTheme.colors.grey2,
                        shape = RoundedCornerShape(12.dp),
                    )
                    .padding(horizontal = 22.dp, vertical = 13.dp),
                contentAlignment = Alignment.Center
            ) {
                HorizontalPager(
                    modifier = Modifier,
                    state = pagerState,
                    pageSpacing = 28.dp,
                    pageSize = PageSize.Fixed(50.dp),
                    pageCount = weathers.size
                ) {
                    Weather(weathers[it])
                }
            }
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                modifier = Modifier.clickableNoRipple { onClickUrl(weatherDetailUrl) },
                text = "날씨 정보 더보기",
                style = ChevitTheme.typhography.bodySmall.copy(color = ChevitTheme.colors.textCaption)
            )
        }
        Spacer(modifier = Modifier.height(24.dp))
    }
}

@Composable
private fun Notice(title: String) {
    Text(
        text = "\uD83D\uDCE2",
        style = ChevitTheme.typhography.headlineSmall,
    )
    Spacer(modifier = Modifier.width(10.dp))
    Text(
        text = title,
        style = ChevitTheme.typhography.headlineSmall.copy(color = ChevitTheme.colors.textPrimary),
        overflow = TextOverflow.Ellipsis,
        maxLines = 1
    )
}

@Composable
private fun Weather(weather: ChecklistState.Weather) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = weather.date,
            style = ChevitTheme.typhography.bodyMedium.copy(color = ChevitTheme.colors.textSecondary)
        )
        Spacer(modifier = Modifier.height(6.dp))
        Box(
            modifier = Modifier
                .size(50.dp)
                .background(color = ChevitTheme.colors.white, shape = CircleShape)
                .border(
                    width = 1.dp,
                    color = ChevitTheme.colors.blue1,
                    shape = CircleShape,
                )
        ) {
            AsyncImage(
                modifier = Modifier.size(40.dp),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(weather.iconUrl)
                    .crossfade(true)
                    .build(),
                contentDescription = ""
            )
        }
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            text = weather.temperature,
            style = ChevitTheme.typhography.bodyMedium.copy(color = ChevitTheme.colors.textSecondary)
        )
    }
}