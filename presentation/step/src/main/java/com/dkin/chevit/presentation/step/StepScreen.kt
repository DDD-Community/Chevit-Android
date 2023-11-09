package com.dkin.chevit.presentation.step

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.dkin.chevit.presentation.resource.ChevitDialog
import com.dkin.chevit.presentation.resource.ChevitTheme
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
    val createLoadingState by viewModel.createLoadingVisible.collectAsState()
    val loadingState by viewModel.loadingVisible.collectAsState()
    var showDialog by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize()) {
        if (showDialog) {
            ChevitDialog(
                title = "체크리스트 생성 중단하기",
                body = "체크리스트 만들기를\n중단하고 나가시겠습니까?",
                onClickCancel = { showDialog = false },
                onClickConfirm = { onClickClose() },
                onDismissRequest = { showDialog = false }

            )
        }
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            var tabIndex by remember { mutableStateOf(0) }
            val tabs = listOf("Where", "When", "Who", "What")
            StepTopBar(
                modifier = Modifier.fillMaxWidth(),
                backButtonEnabled = tabIndex > 0,
                onClickBack = {
                    when (tabIndex) {
                        1 -> {
                            viewModel.clearCountry()
                            tabIndex = 0
                        }

                        2 -> {
                            viewModel.clearDate()
                            tabIndex = 1
                        }

                        3 -> {
                            viewModel.clearTravelWith()
                            tabIndex = 2
                        }
                    }
                },
                onClickClose = { showDialog = true }
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
                        viewModel = viewModel,
                        onClickNext = { tabIndex = 1 },
                    )

                    1 -> WhenContents(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f),
                        viewModel = viewModel,
                        onClickNext = { tabIndex = 2 }
                    )

                    2 -> WhoContents(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f),
                        viewModel = viewModel,
                        onClickNext = { tabIndex = 3 }
                    )

                    3 -> WhatContents(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f),
                        viewModel = viewModel,
                        onClickNext = { viewModel.createCheckList() }
                    )
                }
            }
        }
        if (loadingState) {
            Loading()
        }
        if (createLoadingState) {
            CreateCheckListLoading(nickname = viewModel.userNickname.collectAsState().value)
        }
    }

}

@Composable
fun CreateCheckListLoading(
    nickname: String
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = ChevitTheme.colors.white),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(com.dkin.chevit.presentation.resource.R.raw.checklist_making))
            LottieAnimation(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(94.dp),
                composition = composition,
                iterations = LottieConstants.IterateForever,
            )
            Spacer(Modifier.height(32.dp))
            Text(
                modifier = Modifier,
                text = "${nickname}님께\n딱맞는 체크리스트를\n만들고 있어요!",
                style = ChevitTheme.typhography.headlineLarge.copy(color = ChevitTheme.colors.textPrimary),
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun Loading() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0x66000000)),
        contentAlignment = Alignment.Center
    ) {
        val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(com.dkin.chevit.presentation.resource.R.raw.loading))
        LottieAnimation(
            modifier = Modifier.size(128.dp),
            composition = composition,
            iterations = LottieConstants.IterateForever,
        )
    }
}