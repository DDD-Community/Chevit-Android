package com.dkin.chevit.presentation.checklist.main.contents

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dkin.chevit.presentation.resource.ChevitFloatingButton
import com.dkin.chevit.presentation.resource.ChevitFloatingContent
import com.dkin.chevit.presentation.resource.FloatingContentItem
import com.dkin.chevit.presentation.resource.icon.ChevitIcon
import com.dkin.chevit.presentation.resource.icon.IconEditBoxFill
import com.dkin.chevit.presentation.resource.icon.IconFolderReceivedFill
import com.dkin.chevit.presentation.resource.icon.IconSuitcaseFill
import com.dkin.chevit.presentation.resource.util.clickableNoRipple

@Composable
fun FloatingContents(
    onClose: () -> Unit,
    onClickAddCategory: () -> Unit,
    onClickSaveTemplate: () -> Unit,
    onClickBringTemplate: () -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .clickableNoRipple { onClose() },
    ) {
        Box(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(end = 24.5.dp, bottom = 24.5.dp),
        ) {
            ChevitFloatingButton(
                isOpened = true,
                onClick = { onClose() },
                floatingContent = {
                    ChevitFloatingContent(
                        contentList = listOf(
                            FloatingContentItem(
                                icon = ChevitIcon.IconSuitcaseFill,
                                title = "카테고리 추가하기",
                                onClick = {
                                    onClose()
                                    onClickAddCategory()
                                }),
                            FloatingContentItem(
                                icon = ChevitIcon.IconFolderReceivedFill,
                                title = "템플릿에서 불러오기",
                                onClick = {
                                    onClose()
                                    onClickBringTemplate()
                                }),
                            FloatingContentItem(
                                icon = ChevitIcon.IconEditBoxFill,
                                title = "템플릿으로 저장하기",
                                onClick = {
                                    onClose()
                                    onClickSaveTemplate()
                                })
                        )
                    )
                }
            )
        }
    }
}