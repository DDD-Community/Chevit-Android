package com.dkin.chevit.presentation.checklist.detail.contents

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.dkin.chevit.presentation.resource.ChevitButtonFillMedium
import com.dkin.chevit.presentation.resource.ChevitTheme
import com.dkin.chevit.presentation.resource.R

@Composable
fun ChecklistDetailEmptyContents(
    modifier: Modifier,
    onClickAddItem: () -> Unit
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                modifier = Modifier
                    .size(130.dp),
                painter = painterResource(id = R.drawable.ic_empty_checklist_detail),
                contentDescription = "",
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "체크리스트 항목이 없어요.\n챙겨야 할 체크리스트를 추가해 보아요!",
                textAlign = TextAlign.Center,
                style = ChevitTheme.typhography.bodyLarge.copy(
                    color = ChevitTheme.colors.textSecondary
                )
            )
            Spacer(modifier = Modifier.height(18.dp))
            ChevitButtonFillMedium(
                modifier = Modifier.size(width = 187.dp, height = 54.dp),
                onClick = { onClickAddItem() }
            ) {
                Text(text = "추가하기")
            }
        }
    }
}