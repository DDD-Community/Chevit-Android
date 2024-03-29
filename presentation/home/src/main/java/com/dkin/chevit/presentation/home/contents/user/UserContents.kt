package com.dkin.chevit.presentation.home.contents.user

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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.request.ImageRequest.Builder
import com.dkin.chevit.presentation.home.contents.user.MyPageIntent.AlarmSwitchClicked
import com.dkin.chevit.presentation.home.contents.user.MyPageIntent.NotificationSettingClicked
import com.dkin.chevit.presentation.home.contents.user.MyPageIntent.ProfileSettingClicked
import com.dkin.chevit.presentation.home.contents.user.MyPageIntent.TermsClicked
import com.dkin.chevit.presentation.resource.ChevitButtonChip
import com.dkin.chevit.presentation.resource.ChevitTheme
import com.dkin.chevit.presentation.resource.R
import com.dkin.chevit.presentation.resource.R.drawable
import com.dkin.chevit.presentation.resource.icon.ChevitIcon
import com.dkin.chevit.presentation.resource.icon.IconArrowRight
import com.dkin.chevit.presentation.resource.icon.IconWarningFill
import com.dkin.chevit.presentation.resource.util.rememberLifecycleEvent

@Composable
fun UserContents(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    myViewModel: MyPageViewModel,
    versionName: String,
    myPageState: MyPageState,
    onClickMyCheckList: () -> Unit,
    onClickSignOut: () -> Unit,
    onClickWithdraw: () -> Unit,
) {
    val scrollState = rememberScrollState()

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
                    .clip(CircleShape)
            ) {
                AsyncImage(
                    modifier = Modifier.fillMaxWidth(),
                    model = Builder(LocalContext.current)
                        .data(myPageState.profileUrl)
                        .crossfade(true)
                        .build(),
                    contentDescription = "",
                    contentScale = ContentScale.Fit,
                    error = painterResource(id = drawable.ic_profile_empty)
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "${myPageState.userName} 님",
                style = ChevitTheme.typhography.headlineMedium.copy(
                    color = ChevitTheme.colors.textPrimary,
                ),
            )
            Spacer(modifier = Modifier.height(12.dp))
            ChevitButtonChip(
                onClick = { myViewModel.dispatch(ProfileSettingClicked) },
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
                onClickItem = { onClickMyCheckList() }
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
                checked = myPageState.notificationEnabled,
                onClickItem = { myViewModel.dispatch(AlarmSwitchClicked(it)) },
                onClickNotificationSetting = {
                    myViewModel.dispatch(NotificationSettingClicked)
                }
            )
            UserItem(
                title = "이용약관",
                onClickItem = {  navController.navigate("terms") }
            ) {
                Icon(
                    imageVector = ChevitIcon.IconArrowRight,
                    contentDescription = "",
                    tint = ChevitTheme.colors.grey10,
                )
            }
            UserItem(
                title = "로그아웃",
                onClickItem = { onClickSignOut() }
            ) {
                Icon(
                    imageVector = ChevitIcon.IconArrowRight,
                    contentDescription = "",
                    tint = ChevitTheme.colors.grey10,
                )
            }
            UserItem(
                title = "탈퇴하기",
                onClickItem = { onClickWithdraw() },
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
    val systemNotificationEnabled = remember { mutableStateOf(false) }
    val context = LocalContext.current
    val lifecycle = rememberLifecycleEvent()

    LaunchedEffect(lifecycle) {
        when (lifecycle) {
            Lifecycle.Event.ON_RESUME -> {
                systemNotificationEnabled.value = !areNotificationsEnabled(context)
            }

            else -> {}
        }
    }

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
