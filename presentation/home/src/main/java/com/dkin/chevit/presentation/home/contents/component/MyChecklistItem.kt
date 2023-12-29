package com.dkin.chevit.presentation.home.contents.component

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import com.dkin.chevit.presentation.home.model.CheckListItem
import com.dkin.chevit.presentation.resource.ChevitTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MyChecklistItem(
    item: CheckListItem,
    onClickItem: (id: String) -> Unit,
    onLongClickItem: (id: String, title: String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(90.dp)
            .clip(RoundedCornerShape(12.dp))
            .combinedClickable(
                onClick = { onClickItem(item.id) },
                onLongClick = { onLongClickItem(item.id, item.title) }
            ),
        contentAlignment = Alignment.Center
    ) {
        AsyncImage(
            modifier = Modifier.fillMaxSize(),
            model = ImageRequest.Builder(LocalContext.current)
                .data(item.backgroundUrl)
                .crossfade(true)
                .build(),
            contentDescription = "",
            contentScale = ContentScale.FillBounds
        )
        Box(
            modifier = modifier
                .fillMaxSize()
                .background(color = ChevitTheme.colors.dimThin)
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
            Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Bottom) {
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
}
