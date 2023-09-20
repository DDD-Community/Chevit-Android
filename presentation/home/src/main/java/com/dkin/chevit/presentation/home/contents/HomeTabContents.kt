package com.dkin.chevit.presentation.home.contents

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.dkin.chevit.presentation.home.HomeState
import com.dkin.chevit.presentation.home.HomeViewModel
import com.dkin.chevit.presentation.home.component.HomeTopBar
import com.dkin.chevit.presentation.resource.ChevitButtonFillLarge
import com.dkin.chevit.presentation.resource.ChevitTheme
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
                            .background(color = ChevitTheme.colors.grey2, shape = CircleShape),
                    )
                }
                Spacer(Modifier.height(32.dp))
                Text(
                    text = "준비물을 빼먹지 않도록 Chevit과 함께\n체크리스트를 작성해 보아요!",
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
                    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                        Image(
                            modifier = Modifier
                                .align(Alignment.Center)
                                .size(130.dp),
                            painter = painterResource(id = com.dkin.chevit.presentation.resource.R.drawable.ic_empty_checklist),
                            contentDescription = "",
                        )
                    }
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "생성된 체크리스트가 없어요\n여행 일정을 추가해서 만들어 보아요!",
                        style = ChevitTheme.typhography.bodyLarge.copy(
                            color = ChevitTheme.colors.textSecondary,
                        ),
                        textAlign = TextAlign.Center,
                    )
                } else {
                    Spacer(Modifier.height(20.dp))
                    checkList.forEach {
                        CheckListContents(
                            item = it,
                            onClickLink = { id -> homeViewModel.onClickChecklist(id) },
                            modifier = Modifier.fillMaxWidth(),
                        )
                    }
                }
                Spacer(modifier = Modifier.height(36.dp))
            }
        }
    }
}

@Composable
private fun CheckListContents(
    item: HomeState.CheckListItem,
    onClickLink: (id: String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            // Todo 이미지로 배경 변경
            .background(color = Color.Gray)
            .padding(vertical = 12.5.dp, horizontal = 14.5.dp),
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 26.dp),
            contentAlignment = Alignment.CenterEnd,
        ) {
            if (item.isProgress) {
                Box(
                    modifier = Modifier
                        .clickable { onClickLink(item.id) }
                        .background(
                            color = ChevitTheme.colors.grey10,
                            shape = RoundedCornerShape(100.dp),
                        )
                        .border(
                            width = 1.dp,
                            color = ChevitTheme.colors.grey4,
                            shape = RoundedCornerShape(100.dp),
                        )
                        .padding(horizontal = 14.dp, vertical = 4.dp),
                    contentAlignment = Alignment.Center,
                ) {
                    Text(
                        text = "진행중",
                        style = ChevitTheme.typhography.bodySmall.copy(color = ChevitTheme.colors.white),
                    )
                }
            }
        }
        Text(
            text = item.title,
            style = ChevitTheme.typhography.headlineSmall.copy(color = ChevitTheme.colors.white),
        )
        Text(
            text = item.date,
            style = ChevitTheme.typhography.bodySmall.copy(color = ChevitTheme.colors.white),
        )
    }
    Spacer(modifier = Modifier.height(20.dp))
}
