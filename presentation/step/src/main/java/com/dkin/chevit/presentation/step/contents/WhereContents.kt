package com.dkin.chevit.presentation.step.contents

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dkin.chevit.presentation.resource.ChevitButtonFillLarge
import com.dkin.chevit.presentation.resource.ChevitTheme

@Composable
fun WhereContents(
    modifier: Modifier,
    onClickNext: () -> Unit
) {
    Column(modifier) {
        Spacer(modifier = Modifier.height(50.dp))
        Text(
            modifier = Modifier,
            text = "어디로 떠나시나요?",
            style = ChevitTheme.typhography.headlineLarge.copy(color = ChevitTheme.colors.textPrimary)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            modifier = Modifier,
            text = "여행가고자 하는 도시를 검색 목록에서 선택해 주세요",
            style = ChevitTheme.typhography.bodyLarge.copy(color = ChevitTheme.colors.textSecondary)
        )
        Spacer(modifier = Modifier.height(24.dp))

        Box(modifier = Modifier.weight(1f)){}
        ChevitButtonFillLarge(
            modifier = Modifier.fillMaxWidth(),
            onClick = onClickNext
        ) {
            Text(text = "다음")
        }
    }
}