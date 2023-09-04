package com.dkin.chevit.presentation.home.contents

import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.dkin.chevit.presentation.home.HomeViewModel
import com.dkin.chevit.presentation.resource.ChevitButtonChip
import com.dkin.chevit.presentation.resource.ChevitTheme
import com.dkin.chevit.presentation.resource.icon.ChevitIcon
import com.dkin.chevit.presentation.resource.icon.IconArrowRight
import com.dkin.chevit.presentation.resource.icon.IconWarningFill

@Composable
fun UserTabContents(
    modifier: Modifier = Modifier,
    homeViewModel: HomeViewModel,
    versionName: String,
) {
    val scrollState = rememberScrollState()
    val homeState = homeViewModel.state.collectAsState().value

    Column(modifier = modifier) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .height(58.dp)
                .padding(vertical = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "마이페이지",
                style = ChevitTheme.typhography.headlineMedium.copy(
                    color = ChevitTheme.colors.textPrimary,
                ),
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(scrollState),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier.height(20.dp))
            Box(
                modifier = Modifier
                    .size(128.dp)
                    .background(color = ChevitTheme.colors.grey2, shape = CircleShape),
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "${homeState.userName} 님",
                style = ChevitTheme.typhography.headlineMedium.copy(
                    color = ChevitTheme.colors.textPrimary,
                ),
            )
            Spacer(modifier = Modifier.height(12.dp))
            ChevitButtonChip(
                onClick = { homeViewModel.onClickProfileSetting() },
                text = "프로필 설정",
            )
            Spacer(modifier = Modifier.height(52.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(4.dp)
                    .background(color = ChevitTheme.colors.grey0),
            )

            UserItem(
                title = "내 체크리스트",
                onClickItem = { homeViewModel.onClickMyCheckList() }
            ) {
                Icon(
                    imageVector = ChevitIcon.IconArrowRight,
                    contentDescription = "",
                    tint = ChevitTheme.colors.grey10,
                )
            }
            UserItem(title = "버전정보") {
                Text(
                    text = versionName,
                    style = ChevitTheme.typhography.headlineSmall.copy(color = ChevitTheme.colors.grey8),
                )
            }
            AlarmSetting(
                checked = homeState.alarmEnabled,
                onClickItem = { homeViewModel.onClickAlarmEnabled(it) },
                onClickNotificationSetting = { homeViewModel.onClickNotificationSetting() }
            )
            UserItem(
                title = "이용약관",
                onClickItem = { homeViewModel.onClickTerms() }
            ) {
                Icon(
                    imageVector = ChevitIcon.IconArrowRight,
                    contentDescription = "",
                    tint = ChevitTheme.colors.grey10,
                )
            }
            UserItem(
                title = "로그아웃",
                onClickItem = { homeViewModel.onClickLogout() }
            ) {
                Icon(
                    imageVector = ChevitIcon.IconArrowRight,
                    contentDescription = "",
                    tint = ChevitTheme.colors.grey10,
                )
            }
            UserItem(
                title = "탈퇴하기",
                onClickItem = { homeViewModel.onClickWithdraw() },
                isLastItem = true
            ) {
                Icon(
                    imageVector = ChevitIcon.IconArrowRight,
                    contentDescription = "",
                    tint = ChevitTheme.colors.grey10,
                )
            }
        }
    }
}

@Composable
private fun UserItem(
    title: String,
    isLastItem: Boolean = false,
    onClickItem: () -> Unit = {},
    tailContent: @Composable RowScope.() -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(73.dp)
            .clickable { onClickItem() }
            .padding(top = 24.dp, bottom = 24.dp, start = 24.dp, end = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            modifier = Modifier.weight(1f),
            text = title,
            style = ChevitTheme.typhography.bodyLarge.copy(
                color = ChevitTheme.colors.grey10,
            ),
        )
        tailContent()
    }
    if (!isLastItem) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(color = ChevitTheme.colors.grey3),
        )
    }
}

@Composable
private fun AlarmSetting(
    checked: Boolean,
    onClickItem: (checked: Boolean) -> Unit = {},
    onClickNotificationSetting: () -> Unit = {},
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(73.dp)
                .padding(top = 24.dp, bottom = 24.dp, start = 24.dp, end = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                modifier = Modifier.weight(1f),
                text = "알림설정",
                style = ChevitTheme.typhography.bodyLarge.copy(
                    color = ChevitTheme.colors.grey10,
                ),
            )
            Switch(
                modifier = Modifier.size(width = 48.dp, height = 24.dp),
                checked = checked,
                onCheckedChange = { onClickItem(it) },
                colors = SwitchDefaults.colors(
                    checkedThumbColor = ChevitTheme.colors.white,
                    checkedTrackColor = ChevitTheme.colors.blue7,
                    checkedBorderColor = Color.Unspecified,
                    uncheckedThumbColor = ChevitTheme.colors.white,
                    uncheckedTrackColor = ChevitTheme.colors.grey2,
                    uncheckedBorderColor = Color.Unspecified,
                ),
            )
        }
        if (!areNotificationsEnabled(LocalContext.current)) {
            Box(modifier = Modifier.padding(start = 24.dp, end = 24.dp, bottom = 24.dp)) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            color = ChevitTheme.colors.grey0,
                            shape = RoundedCornerShape(6.dp)
                        )
                        .padding(12.dp)
                ) {
                    Icon(
                        imageVector = ChevitIcon.IconWarningFill,
                        contentDescription = "",
                        tint = ChevitTheme.colors.blue7,
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Column {
                        Text(
                            text = "기기 알림이 꺼져있어요!",
                            style = ChevitTheme.typhography.bodyMedium.copy(
                                color = ChevitTheme.colors.textPrimary
                            )
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            text = "설정에서 알림을 켜주세요.",
                            style = ChevitTheme.typhography.bodyMedium.copy(
                                color = ChevitTheme.colors.textSecondary
                            )
                        )
                        Spacer(modifier = Modifier.height(9.dp))
                        Row(
                            modifier = Modifier.clickable { onClickNotificationSetting() },
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "기기 알림 설정하러 가기",
                                style = ChevitTheme.typhography.bodySmall.copy(
                                    color = ChevitTheme.colors.blue5
                                )
                            )
                            Spacer(modifier = Modifier.width(3.dp))
                            Icon(
                                imageVector = ChevitIcon.IconArrowRight,
                                contentDescription = "",
                                tint = ChevitTheme.colors.blue5,
                            )
                        }
                    }
                }
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(color = ChevitTheme.colors.grey3),
        )
    }
}

private fun areNotificationsEnabled(context: Context): Boolean {
    val notificationManager =
        context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    return when {
        notificationManager.areNotificationsEnabled().not() -> false
        Build.VERSION.SDK_INT >= Build.VERSION_CODES.O -> {
            notificationManager.notificationChannels.firstOrNull { channel ->
                channel.importance == NotificationManager.IMPORTANCE_NONE
            } == null
        }

        else -> true
    }
}