package com.dkin.chevit.presentation.step.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dkin.chevit.presentation.resource.ChevitTheme

@Composable
fun ChevitProgressBar(
    selectedTabIndex: Int,
    modifier: Modifier = Modifier,
    tabSize: Int
) {
    Row(modifier) {
        for (index in 0 until tabSize) {
            ChevitProgressItem(
                modifier = Modifier.weight(1f),
                isPassed = index <= selectedTabIndex
            )
            Spacer(Modifier.width(2.dp))
        }
    }
}

@Composable
fun ChevitProgressItem(
    modifier: Modifier,
    isPassed: Boolean
) {
    Box(
        modifier = modifier
            .height(4.dp)
            .background(color = if (isPassed) ChevitTheme.colors.blue7 else ChevitTheme.colors.grey2)
    )
}

@Preview
@Composable
fun ChevitProgressBarPreview() {
    ChevitProgressBar(selectedTabIndex = 0, tabSize = 4)
}
