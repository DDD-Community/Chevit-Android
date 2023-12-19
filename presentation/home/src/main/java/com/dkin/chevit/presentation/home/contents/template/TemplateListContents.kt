package com.dkin.chevit.presentation.home.contents.template

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.dkin.chevit.presentation.common.model.SortType
import com.dkin.chevit.presentation.home.contents.template.model.Template
import com.dkin.chevit.presentation.resource.ChevitButtonFillMedium
import com.dkin.chevit.presentation.resource.ChevitFloatingButton
import com.dkin.chevit.presentation.resource.ChevitTheme
import com.dkin.chevit.presentation.resource.R
import com.dkin.chevit.presentation.resource.TemplateColor
import com.dkin.chevit.presentation.resource.icon.ChevitIcon
import com.dkin.chevit.presentation.resource.icon.IconFilterFill
import com.dkin.chevit.presentation.resource.util.clickableNoRipple
import kotlinx.coroutines.launch

@Composable
fun TemplateListContents(
    modifier: Modifier,
    templateViewModel: TemplateViewModel,
    navigateToAddTemplate: () -> Unit,
    navigateToSortTemplate: () -> Unit,
    openEditBottomSheet: (id: String, title: String, color: TemplateColor) -> Unit
) {
    val state = templateViewModel.state.collectAsState().value
    val sortType by templateViewModel.sortType.collectAsState()
    val progress by templateViewModel.progress.collectAsState()
    val scope = rememberCoroutineScope()
    val composition by rememberLottieComposition(
        LottieCompositionSpec.RawRes(
            R.raw.loading
        )
    )

    LaunchedEffect(Unit) {
        scope.launch {
            templateViewModel.dispatch(TemplateIntent.GetTemplateList)
        }
    }

    Column(modifier = modifier) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .height(58.dp)
                .padding(start = 24.dp, end = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.weight(1f),
                text = "내 템플릿",
                style = ChevitTheme.typhography.headlineMedium.copy(
                    color = ChevitTheme.colors.textPrimary,
                ),
            )
            Icon(
                modifier = Modifier.clickableNoRipple { navigateToSortTemplate() },
                imageVector = ChevitIcon.IconFilterFill,
                contentDescription = "",
            )
        }
        when (state) {
            is TemplateState.Available -> {
                if (state.templateList.isEmpty()) {
                    TemplateEmpty(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f),
                        navigateToAddTemplate = navigateToAddTemplate
                    )
                } else {
                    Box(
                        modifier = modifier
                            .fillMaxWidth()
                            .weight(1f),
                        contentAlignment = Alignment.Center
                    ) {
                        TemplateAvailable(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(horizontal = 24.dp),
                            templateList = state.templateList,
                            sortType = sortType,
                            onClickTemplate = { id ->
                                templateViewModel.dispatch(
                                    TemplateIntent.ClickTemplate(id)
                                )
                            },
                            openEditBottomSheet = openEditBottomSheet,
                            navigateToAddTemplate = navigateToAddTemplate
                        )
                        if (progress) {
                            LottieAnimation(
                                modifier = Modifier.size(128.dp),
                                composition = composition,
                                iterations = LottieConstants.IterateForever,
                            )
                        }
                    }
                }
            }

            TemplateState.Loading -> {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    contentAlignment = Alignment.Center
                ) {
                    LottieAnimation(
                        modifier = Modifier.size(128.dp),
                        composition = composition,
                        iterations = LottieConstants.IterateForever,
                    )
                }
            }
        }
    }
}

@Composable
private fun TemplateAvailable(
    modifier: Modifier,
    templateList: List<Template>,
    sortType: SortType,
    onClickTemplate: (id: String) -> Unit,
    openEditBottomSheet: (id: String, title: String, color: TemplateColor) -> Unit,
    navigateToAddTemplate: () -> Unit
) {
    Box(modifier = modifier) {
        val listState = rememberLazyListState()
        LazyColumn(
            state = listState,
            contentPadding = PaddingValues(top = 30.dp, bottom = 14.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp),
            reverseLayout = sortType == SortType.OLD,
        ) {
            items(count = templateList.size) {
                TemplateItem(
                    template = templateList[it],
                    onClick = { id -> onClickTemplate(id) },
                    onLongClick = { id, title, color ->
                        openEditBottomSheet(
                            id,
                            title,
                            color
                        )
                    }
                )
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp)
                .align(Alignment.BottomEnd)
        ) {
            ChevitFloatingButton(
                modifier = Modifier.align(Alignment.BottomEnd),
                onClick = navigateToAddTemplate
            )
        }
    }
}

@Composable
private fun TemplateEmpty(
    modifier: Modifier,
    navigateToAddTemplate: () -> Unit
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
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
                text = "생성된 항목이 없어요\n나만의 템플릿을 만들어 보아요!",
                textAlign = TextAlign.Center,
                style = ChevitTheme.typhography.bodyLarge.copy(
                    color = ChevitTheme.colors.textSecondary
                )
            )
            Spacer(modifier = Modifier.height(18.dp))
            ChevitButtonFillMedium(
                modifier = Modifier.size(width = 187.dp, height = 54.dp),
                onClick = { navigateToAddTemplate() }
            ) {
                Text(text = "추가하기")
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun TemplateItem(
    template: Template,
    onClick: (id: String) -> Unit,
    onLongClick: (id: String, title: String, color: TemplateColor) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(90.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(color = template.colorType.color)
            .combinedClickable(
                onClick = { onClick(template.id) },
                onLongClick = {
                    onLongClick(template.id, template.title, template.colorType)
                }
            )
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
                text = "생성일 : ${template.date}",
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
