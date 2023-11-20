package com.dkin.chevit.presentation.checklist.detail.contents

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.dkin.chevit.presentation.resource.ChevitBottomsheet
import com.dkin.chevit.presentation.resource.ChevitTheme
import com.dkin.chevit.presentation.resource.icon.ChevitIcon
import com.dkin.chevit.presentation.resource.icon.IconCheckboxCheckedBlue
import com.dkin.chevit.presentation.resource.icon.IconCheckboxCheckedGrey
import com.dkin.chevit.presentation.resource.icon.IconCheckboxCircleFill

@Composable
fun ChecklistDetailMoreContents(
    title: String,
    navigateEditItem: () -> Unit,
    deleteItem: () -> Unit,
    onClose: () -> Unit
) {
    ChevitBottomsheet(
        modifier = Modifier.fillMaxSize(),
        onClickBackground = onClose
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    imageVector = ChevitIcon.IconCheckboxCircleFill,
                    contentDescription = "",
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = title,
                    style = ChevitTheme.typhography.headlineMedium.copy(color = ChevitTheme.colors.textPrimary),
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            Column(
                modifier = Modifier.clickable { navigateEditItem() }
            ) {
                Text(
                    text = "수정하기",
                    style = ChevitTheme.typhography.bodyLarge.copy(color = ChevitTheme.colors.textPrimary),
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1
                )
                Spacer(modifier = Modifier.height(16.dp))
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(color = ChevitTheme.colors.grey0)
            )
            Column(
                modifier = Modifier.clickable { deleteItem() }
            ) {
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "삭제하기",
                    style = ChevitTheme.typhography.bodyLarge.copy(color = ChevitTheme.colors.textPrimary),
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1
                )
                Spacer(modifier = Modifier.height(16.dp))
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(color = ChevitTheme.colors.grey0)
            )
        }
    }
}