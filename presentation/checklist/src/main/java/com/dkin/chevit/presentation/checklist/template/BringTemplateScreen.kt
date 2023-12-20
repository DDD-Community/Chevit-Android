package com.dkin.chevit.presentation.checklist.template

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.dkin.chevit.presentation.resource.ChevitTheme
import com.dkin.chevit.presentation.resource.R
import com.dkin.chevit.presentation.resource.icon.ChevitIcon
import com.dkin.chevit.presentation.resource.icon.IconArrowLeftLine
import com.dkin.chevit.presentation.resource.util.clickableNoRipple

@Composable
fun BringTemplateScreen(
    modifier: Modifier = Modifier,
    viewModel: BringTemplateViewModel,
    onClickBack: () -> Unit,
    onClickTemplate: (templateId: String) -> Unit,
) {
    val state = viewModel.state.collectAsState().value

    Column(modifier = modifier) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
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
                text = "내 템플릿",
                textAlign = TextAlign.Center,
                style = ChevitTheme.typhography.headlineMedium.copy(color = ChevitTheme.colors.textPrimary)
            )
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(4.dp)
                .background(color = ChevitTheme.colors.grey0)
        )
        when (state) {
            BringTemplateState.Loading -> {
                Spacer(modifier = Modifier.height(24.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    contentAlignment = Alignment.TopCenter
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

            is BringTemplateState.Available -> {
                if (state.templateList.isEmpty()) {
                    Box(
                        Modifier
                            .fillMaxWidth()
                            .weight(1f), contentAlignment = Alignment.Center
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Image(
                                modifier = Modifier
                                    .size(140.dp),
                                painter = painterResource(id = R.drawable.ic_empty_template),
                                contentDescription = "",
                            )
                            Spacer(modifier = Modifier.height(12.dp))
                            Text(
                                text = "아직 생성된 템플릿이 없어요!\n나만의 템플릿을 만들고 추가해 보세요.",
                                textAlign = TextAlign.Center,
                                style = ChevitTheme.typhography.bodyLarge.copy(
                                    color = ChevitTheme.colors.textSecondary
                                )
                            )
                        }

                    }
                } else {
                    Spacer(modifier = Modifier.height(24.dp))
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 24.dp),
                        text = "원하는 템플릿을 선택해 주세요.",
                        style = ChevitTheme.typhography.headlineMedium.copy(color = ChevitTheme.colors.textPrimary),
                    )
                    Box(
                        modifier = modifier
                            .fillMaxWidth()
                            .weight(1f)
                            .padding(horizontal = 24.dp)
                    ) {
                        val listState = rememberLazyListState()
                        val templateList = state.templateList
                        LazyColumn(
                            state = listState,
                            contentPadding = PaddingValues(top = 28.dp, bottom = 14.dp),
                            verticalArrangement = Arrangement.spacedBy(24.dp)
                        ) {
                            items(count = templateList.size) {
                                TemplateItem(
                                    template = templateList[it],
                                    onClick = { id -> onClickTemplate(id) },
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun TemplateItem(
    template: BringTemplateState.Available.Template,
    onClick: (id: String) -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(90.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(color = template.colorType.color)
            .clickable { onClick(template.id) }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 14.5.dp)
                .align(Alignment.BottomStart)
        ) {
            Text(
                text = template.title,
                style = ChevitTheme.typhography.headlineSmall.copy(
                    color = ChevitTheme.colors.white
                ),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = "생성일:${template.date}",
                style = ChevitTheme.typhography.bodySmall.copy(
                    color = ChevitTheme.colors.white
                ),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(12.dp))
        }
        Box(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(end = 19.dp)
        ) {
            Image(imageVector = template.colorType.icon, contentDescription = "")
        }
    }
}
