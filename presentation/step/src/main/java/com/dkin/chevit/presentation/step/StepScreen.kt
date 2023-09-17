package com.dkin.chevit.presentation.step

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.dkin.chevit.presentation.resource.ChevitTheme

@Composable
fun StepScreen(
    modifier: Modifier = Modifier,
    viewModel: StepViewModel
) {
    Column(
        modifier = modifier.fillMaxSize(),
    ) {
        Text(
            text = "새 체크리스트 ",
            style = ChevitTheme.typhography.bodySmall,
        )
    }
}