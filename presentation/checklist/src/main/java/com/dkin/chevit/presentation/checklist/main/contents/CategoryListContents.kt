package com.dkin.chevit.presentation.checklist.main.contents

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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.dkin.chevit.presentation.checklist.main.ChecklistState
import com.dkin.chevit.presentation.common.model.CategoryType
import com.dkin.chevit.presentation.resource.ChevitTheme
import com.dkin.chevit.presentation.resource.getCategoryIconResId
import com.dkin.chevit.presentation.resource.icon.ChevitIcon
import com.dkin.chevit.presentation.resource.icon.TemplateCheckOff
import com.dkin.chevit.presentation.resource.icon.TemplateCheckOn

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CategoryListContents(
    modifier: Modifier = Modifier,
    categories: List<ChecklistState.Category>,
    onClickCategory: (categoryId: String) -> Unit,
    onLongClickCategory: (categoryId: String, title: String, type: CategoryType) -> Unit = { _, _, _ -> }
) {
    Column(
        modifier = modifier
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
