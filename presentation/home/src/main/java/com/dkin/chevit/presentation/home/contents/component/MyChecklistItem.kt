package com.dkin.chevit.presentation.home.contents.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.dkin.chevit.presentation.home.HomeState
import com.dkin.chevit.presentation.resource.ChevitTheme

@Composable
fun MyChecklistItem(
    item: HomeState.CheckListItem,
    onClickItem: (id: String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .clip(RoundedCornerShape(12.dp))
        .background(color = ChevitTheme.colors.grey4)
        .clickable { onClickItem(item.id) }
    ) {
        AsyncImage(
            modifier = Modifier.fillMaxWidth(),
            model = ImageRequest.Builder(LocalContext.current)
                .data(item.backgroundUrl)
                .crossfade(true)
                .build(),
            contentDescription = "",
            contentScale = ContentScale.FillWidth
        )
        Column(
            modifier = modifier
                .fillMaxWidth()
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
    }
}
