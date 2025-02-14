package com.dkin.chevit.presentation.home.contents.notification

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.dkin.chevit.presentation.home.contents.component.ErrorContent
import com.dkin.chevit.presentation.home.model.NotificationItem
import com.dkin.chevit.presentation.resource.ChevitTheme
import com.dkin.chevit.presentation.resource.R
import com.dkin.chevit.presentation.resource.icon.ChevitIcon
import com.dkin.chevit.presentation.resource.icon.IconArrowLeftLine
import com.dkin.chevit.presentation.resource.util.clickableNoRipple

@Composable
fun NotificationListScreen(
    state: NotificationListState,
    onClickBack: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        TopBar(modifier = Modifier.fillMaxWidth(), onClickBack = onClickBack)
        when (state) {
            NotificationListState.Loading -> {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    contentAlignment = Alignment.Center
                ) {
                    val composition by rememberLottieComposition(
                        LottieCompositionSpec.RawRes(
                            R.raw.loading
                        )
                    )
                    LottieAnimation(
                        modifier = Modifier.size(128.dp),
                        composition = composition,
                        iterations = LottieConstants.IterateForever,
                    )
                }
            }

            is NotificationListState.Stable -> {
                if (state.notificationList.isEmpty()) {
                    EmptyNotificationList(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                    )
                } else {
                    val listState = rememberLazyListState()
                    LazyColumn(
                        state = listState,
                        contentPadding = PaddingValues(
                            top = 20.dp,
                            bottom = 20.dp,
                            start = 24.dp,
                            end = 24.dp
                        ),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        items(count = state.notificationList.size) {
                            NotificationListItem(
                                item = state.notificationList[it],
                            )
                        }
                    }
                }
            }

            is NotificationListState.Error -> {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    contentAlignment = Alignment.Center
                ) {
                    ErrorContent()
                }
            }
        }
    }
}

@Composable
private fun TopBar(modifier: Modifier, onClickBack: () -> Unit) {
    Box(
        modifier = modifier
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
            text = "알림",
            textAlign = TextAlign.Center,
            style = ChevitTheme.typography.headlineMedium.copy(color = ChevitTheme.colors.textPrimary)
        )
    }
}

@Composable
private fun EmptyNotificationList(modifier: Modifier) {
    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(
            modifier = modifier.fillMaxWidth()
        ) {
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                Image(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .size(130.dp),
                    painter = painterResource(id = R.drawable.ic_empty_notification),
                    contentDescription = "",
                )
            }
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "아직 받은 알림이 없어요!",
                style = ChevitTheme.typography.bodyLarge.copy(
                    color = ChevitTheme.colors.textSecondary,
                ),
                textAlign = TextAlign.Center,
            )
        }
    }
}

@Composable
private fun NotificationListItem(item: NotificationItem) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = ChevitTheme.colors.backgroundContents,
                shape = RoundedCornerShape(12.dp)
            )
            .padding(vertical = 18.dp, horizontal = 14.dp),
    ) {
        Row(
            verticalAlignment = Alignment.Top
        ) {
            Text(
                text = "☑\uFE0F"
            )
            Spacer(Modifier.width(8.dp))
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = item.subject,
                    style = ChevitTheme.typography.bodySmall.copy(
                        color = ChevitTheme.colors.textSecondary,
                    ),
                )
                Spacer(Modifier.height(6.dp))
                Text(
                    text = item.text,
                    style = ChevitTheme.typography.bodyLarge.copy(
                        color = ChevitTheme.colors.textPrimary,
                    ),
                )
            }
            Spacer(Modifier.width(8.dp))
            Text(
                text = item.time.formatted,
                style = ChevitTheme.typography.caption.copy(
                    color = ChevitTheme.colors.textCaption,
                ),
            )
        }
    }
}