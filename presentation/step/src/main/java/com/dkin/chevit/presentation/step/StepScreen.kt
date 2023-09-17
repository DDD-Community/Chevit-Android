package com.dkin.chevit.presentation.step

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dkin.chevit.presentation.step.component.ChevitProgressBar
import com.dkin.chevit.presentation.step.component.StepTopBar
import com.dkin.chevit.presentation.step.contents.WhatContents
import com.dkin.chevit.presentation.step.contents.WhenContents
import com.dkin.chevit.presentation.step.contents.WhereContents
import com.dkin.chevit.presentation.step.contents.WhoContents

@Composable
fun StepScreen(
    viewModel: StepViewModel,
    onClickClose: () -> Unit
) {
    Column(
        modifier = Modifier
    ) {
        var tabIndex by remember { mutableStateOf(0) }
        val tabs = listOf("Where", "When", "Who", "What")
        StepTopBar(
            modifier = Modifier.fillMaxWidth(),
            onClickClose = onClickClose
        )
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(start = 24.dp, end = 24.dp, bottom = 24.dp)
        ) {
            Spacer(modifier = Modifier.height(6.dp))
            ChevitProgressBar(
                modifier = Modifier.fillMaxWidth(),
                selectedTabIndex = tabIndex,
                tabSize = tabs.size
            )
            when (tabIndex) {
                0 -> WhereContents(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    onClickNext = { tabIndex = 1 }
                )

                1 -> WhenContents(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    onClickNext = { tabIndex = 2 }
                )

                2 -> WhoContents(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    onClickNext = { tabIndex = 3 }
                )

                3 -> WhatContents(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    onClickNext = { viewModel.createCheckList() }
                )
            }
        }
    }
}

