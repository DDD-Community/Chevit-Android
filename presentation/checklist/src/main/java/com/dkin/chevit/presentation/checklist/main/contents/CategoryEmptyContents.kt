package com.dkin.chevit.presentation.checklist.main.contents

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
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
fun CategoryEmptyContents(
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