package com.dkin.chevit.presentation.home.contents

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.dkin.chevit.presentation.home.TemplateState
import com.dkin.chevit.presentation.home.TemplateViewModel
import com.dkin.chevit.presentation.home.model.Template
import com.dkin.chevit.presentation.resource.ChevitButtonFillMedium
import com.dkin.chevit.presentation.resource.ChevitFloatingButton
import com.dkin.chevit.presentation.resource.ChevitTheme
import com.dkin.chevit.presentation.resource.R
import com.dkin.chevit.presentation.resource.icon.ChevitIcon
import com.dkin.chevit.presentation.resource.icon.IconFilterFill

@Composable
fun TemplateTabContents(
    modifier: Modifier = Modifier,
    templateViewModel: TemplateViewModel,
) {
    val state = templateViewModel.templateState.collectAsState().value

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
                modifier = Modifier.clickable { templateViewModel.onClickSortTemplate() },
                imageVector = ChevitIcon.IconFilterFill,
                contentDescription = "",
            )
        }
        when (state) {
            is TemplateState.Available -> {
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
                        contentPadding = PaddingValues(top = 30.dp, bottom = 14.dp),
                        verticalArrangement = Arrangement.spacedBy(24.dp)
                    ) {
                        items(count = templateList.size) {
                            TemplateItem(
                                template = templateList[it],
                                onClick = { id -> templateViewModel.onClickTemplate(id) })
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
                            onClick = { templateViewModel.onClickAddTemplate() }
                        )
                    }
                }
            }

            TemplateState.EMPTY -> {
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
                            text = "생성된 항목이 없어요\n나만의 템플릿을 만들어 보아요!",
                            textAlign = TextAlign.Center,
                            style = ChevitTheme.typhography.bodyLarge.copy(
                                color = ChevitTheme.colors.textSecondary
                            )
                        )
                        Spacer(modifier = Modifier.height(18.dp))
                        ChevitButtonFillMedium(
                            modifier = Modifier.size(width = 187.dp, height = 54.dp),
                            onClick = { templateViewModel.onClickAddTemplate() }
                        ) {
                            Text(text = "추가하기")
                        }
                    }

                }
            }
        }
    }
}


@Composable
private fun TemplateItem(
    template: Template,
    onClick: (id: Int) -> Unit
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

