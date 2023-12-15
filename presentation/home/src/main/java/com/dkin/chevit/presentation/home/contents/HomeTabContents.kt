package com.dkin.chevit.presentation.home.contents

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.dkin.chevit.presentation.home.HomeViewModel
import com.dkin.chevit.presentation.home.component.HomeTopBar
import com.dkin.chevit.presentation.home.contents.component.EmptyChecklist
import com.dkin.chevit.presentation.home.contents.component.MyChecklistItem
import com.dkin.chevit.presentation.resource.ChevitButtonFillLarge
import com.dkin.chevit.presentation.resource.ChevitTheme
import com.dkin.chevit.presentation.resource.R
import com.dkin.chevit.presentation.resource.icon.ChevitIcon
import com.dkin.chevit.presentation.resource.icon.IconAddCircleLine

@Composable
fun HomeTabContents(
    modifier: Modifier = Modifier,
    homeViewModel: HomeViewModel,
) {
    val scrollState = rememberScrollState()
    val homeState = homeViewModel.state.collectAsState().value

    Column(modifier = modifier.fillMaxWidth()) {
        HomeTopBar()
        Column(modifier = Modifier.verticalScroll(scrollState)) {
            Spacer(Modifier.height(24.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Column(
                        modifier = Modifier.weight(1f),
                        horizontalAlignment = Alignment.Start,
                    ) {
                        Text(
                            text = "${homeState.userName}님!",
                            style = ChevitTheme.typhography.headlineLarge.copy(
                                color = ChevitTheme.colors.textPrimary,
                            ),
                        )
                        Text(
                            text = "여행 준비를 시작해볼까요?",
                            style = ChevitTheme.typhography.headlineMedium.copy(
                                color = ChevitTheme.colors.textPrimary,
                            ),
                        )
                    }
                    Box(
                        modifier = Modifier
                            .size(58.dp)
                            .clip(CircleShape)
                    ) {
                        AsyncImage(
                            modifier = Modifier.fillMaxWidth(),
                            model = ImageRequest.Builder(LocalContext.current)
                                .data(homeState.profileUrl)
                                .crossfade(true)
                                .build(),
                            contentDescription = "",
                            contentScale = ContentScale.Fit,
                            error = painterResource(id = R.drawable.ic_profile_empty)
                        )
                    }
                }
                Spacer(Modifier.height(32.dp))
                Text(
                    text = "준비물을 빼먹지 않도록,\n채빗이 필수 아이템을 추천해 드려요.",
                    style = ChevitTheme.typhography.bodyLarge.copy(
                        color = ChevitTheme.colors.textPrimary,
                    ),
                )
                Spacer(Modifier.height(24.dp))
                ChevitButtonFillLarge(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = { homeViewModel.onClickAddChecklist() },
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Icon(
                            imageVector = ChevitIcon.IconAddCircleLine,
                            contentDescription = "",
                            tint = ChevitTheme.colors.white,
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text("여행 추가하기")
                    }
                }
            }

            Spacer(Modifier.height(40.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(4.dp)
                    .background(color = ChevitTheme.colors.grey0),
            )

            Spacer(Modifier.height(24.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
            ) {
                Text(
                    text = "나의 체크리스트",
                    style = ChevitTheme.typhography.headlineMedium.copy(
                        color = ChevitTheme.colors.textPrimary,
                    ),
                )
                val checkList = homeState.checkList
                if (checkList.isEmpty()) {
                    Spacer(Modifier.height(24.dp))
                    EmptyChecklist(modifier = Modifier.fillMaxWidth())
                } else {
                    Spacer(Modifier.height(20.dp))
                    checkList.forEach {
                        MyChecklistItem(
                            item = it,
                            onClickItem = { id -> homeViewModel.onClickChecklist(id) },
                            onLongClickItem = { _, _ -> },
                            modifier = Modifier.fillMaxWidth(),
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                    }
                }
                Spacer(modifier = Modifier.height(36.dp))
            }
        }
    }
}
