package com.dkin.chevit.presentation.home.contents.template.detail

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.dkin.chevit.presentation.common.model.CategoryType
import com.dkin.chevit.presentation.resource.ChevitButtonFillMedium
import com.dkin.chevit.presentation.resource.ChevitFloatingButton
import com.dkin.chevit.presentation.resource.ChevitTheme
import com.dkin.chevit.presentation.resource.R
import com.dkin.chevit.presentation.resource.getCategoryIconResId
import com.dkin.chevit.presentation.resource.icon.ChevitIcon
import com.dkin.chevit.presentation.resource.icon.IconArrowLeftLine
import com.dkin.chevit.presentation.resource.icon.TemplateCheckOff
import com.dkin.chevit.presentation.resource.icon.TemplateCheckOn
import com.dkin.chevit.presentation.resource.util.clickableNoRipple

@Composable
fun TemplateDetailScreen(
    modifier: Modifier,
    viewModel: TemplateDetailViewModel,
    onClickBack: () -> Unit,
    openCategoryMoreSheet: (id: String, title: String, type: CategoryType) -> Unit,
) {
    val state by viewModel.state.collectAsState()

    Column(
        modifier = modifier.fillMaxSize()
    ) {
        TopBar(modifier = Modifier.fillMaxWidth(), title = state.title, onClickBack = onClickBack)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(4.dp)
                .background(color = ChevitTheme.colors.grey0)
        )
        Spacer(Modifier.height(24.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp), verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.weight(1f),
                text = "체크리스트 템플릿",
                style = ChevitTheme.typhography.headlineMedium.copy(color = ChevitTheme.colors.textPrimary),
            )
            if (state.categories.isNotEmpty()) {
                Text(
                    text = "공개",
                    style = ChevitTheme.typhography.bodyMedium.copy(color = ChevitTheme.colors.textSecondary),
                )
                Spacer(modifier = Modifier.width(6.dp))
                Switch(
                    modifier = Modifier.size(width = 48.dp, height = 24.dp),
                    checked = state.isTemplateOpen,
                    onCheckedChange = {
                        viewModel.dispatch(
                            TemplateDetailIntent.ChangeTemplateOpenSetting(
                                it
                            )
                        )
                    },
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
        }
        Spacer(modifier = Modifier.height(20.dp))
        if (state.categories.isEmpty()) {
            CategoryEmptyContents(
                addCategory = { viewModel.onClickAddCategory() }
            )
        } else {
            Box(modifier = Modifier.weight(1f)) {
                CategoryListContents(
                    categories = state.categories,
                    onClickCategory = { id -> viewModel.onClickCategory(id) },
                    onLongClickCategory = openCategoryMoreSheet
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 24.dp, end = 24.dp)
                        .align(Alignment.BottomEnd)
                ) {
                    ChevitFloatingButton(
                        modifier = Modifier.align(Alignment.BottomEnd),
                        onClick = { viewModel.onClickAddCategory() }
                    )
                }
            }
        }
    }
}

@Composable
private fun TopBar(modifier: Modifier, title: String, onClickBack: () -> Unit) {
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
            text = title,
            textAlign = TextAlign.Center,
            style = ChevitTheme.typhography.headlineMedium.copy(color = ChevitTheme.colors.textPrimary)
        )
    }
}

@Composable
private fun CategoryEmptyContents(
    addCategory: () -> Unit
) {
    Column(
        Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(8.dp))
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                modifier = Modifier
                    .size(130.dp),
                painter = painterResource(id = R.drawable.ic_empty_checklist_template),
                contentDescription = "",
            )
            Text(
                text = "카테고리를 추가하여\n체크리스트를 만들어 볼까요?",
                textAlign = TextAlign.Center,
                style = ChevitTheme.typhography.bodyLarge.copy(
                    color = ChevitTheme.colors.textSecondary
                )
            )
            Spacer(modifier = Modifier.height(18.dp))
            ChevitButtonFillMedium(
                modifier = Modifier.size(width = 147.dp, height = 54.dp),
                onClick = { addCategory() }
            ) {
                Text(text = "추가하기")
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun CategoryListContents(
    categories: List<TemplateDetailState.Category>,
    onClickCategory: (categoryId: String) -> Unit,
    onLongClickCategory: (id: String, title: String, type: CategoryType) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp),
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            horizontalArrangement = Arrangement.spacedBy(14.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp),
            contentPadding = PaddingValues(bottom = 15.dp)
        ) {
            items(categories) { category ->
                val completed = category.checked == category.total
                Column(
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .background(color = if (completed) ChevitTheme.colors.grey0 else ChevitTheme.colors.grey1)
                        .combinedClickable(
                            onClick = { onClickCategory(category.categoryId) },
                            onLongClick = {
                                onLongClickCategory(
                                    category.categoryId,
                                    category.title,
                                    category.categoryType
                                )
                            }
                        )
                        .padding(vertical = 12.dp, horizontal = 12.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        modifier = Modifier
                            .size(48.dp)
                            .background(color = ChevitTheme.colors.white, shape = CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = category.categoryType.getCategoryIconResId()),
                            contentDescription = ""
                        )
                    }
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = category.title,
                        style = ChevitTheme.typhography.bodyMedium.copy(color = ChevitTheme.colors.grey10),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        if (completed) {
                            Image(
                                modifier = Modifier.size(12.dp),
                                imageVector = ChevitIcon.TemplateCheckOn,
                                contentDescription = "",
                            )
                        } else {
                            Image(
                                modifier = Modifier.size(12.dp),
                                imageVector = ChevitIcon.TemplateCheckOff,
                                contentDescription = "",
                            )
                        }
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "${category.checked}",
                            style = ChevitTheme.typhography.caption
                                .copy(color = ChevitTheme.colors.grey10)
                        )
                        Text(
                            text = "/${category.total}",
                            style = ChevitTheme.typhography.caption
                                .copy(color = if (completed) ChevitTheme.colors.grey10 else ChevitTheme.colors.grey5)
                        )
                    }
                }
            }
        }
    }
}
