package com.dkin.chevit.presentation.checklist.main

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.dkin.chevit.presentation.checklist.main.component.ChecklistTopBar
import com.dkin.chevit.presentation.checklist.main.component.CountryInfo
import com.dkin.chevit.presentation.checklist.main.contents.CategoryEmptyContents
import com.dkin.chevit.presentation.checklist.main.contents.CategoryListContents
import com.dkin.chevit.presentation.resource.ChevitFloatingButton
import com.dkin.chevit.presentation.resource.ChevitFloatingContent
import com.dkin.chevit.presentation.resource.ChevitTheme
import com.dkin.chevit.presentation.resource.FloatingContentItem
import com.dkin.chevit.presentation.resource.icon.ChevitIcon
import com.dkin.chevit.presentation.resource.icon.IconArrowDownLine
import com.dkin.chevit.presentation.resource.icon.IconArrowUpLine
import com.dkin.chevit.presentation.resource.icon.IconEditBoxFill
import com.dkin.chevit.presentation.resource.icon.IconFolderReceivedFill
import com.dkin.chevit.presentation.resource.icon.IconSuitcaseFill
import com.dkin.chevit.presentation.resource.util.clickableNoRipple

@Composable
fun ChecklistScreen(
    viewModel: ChecklistViewModel,
    onClickBack: () -> Unit,
    navigateAddCategory: () -> Unit,
    navigateSaveTemplate: () -> Unit
) {
    val checklistState by viewModel.state.collectAsState()
    var showCountryInfo by remember { mutableStateOf(true) }
    var floatingButtonOpened by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ChecklistTopBar(
                    modifier = Modifier.fillMaxWidth(),
                    title = checklistState.title,
                    onClickBack = onClickBack
                )
                Text(
                    text = checklistState.date,
                    style = ChevitTheme.typhography.bodyLarge.copy(color = ChevitTheme.colors.textCaption),
                )
                Spacer(modifier = Modifier.height(16.dp))
                if (showCountryInfo) {
                    CountryInfo(
                        notice = checklistState.notice,
                        weathers = checklistState.weathers,
                        weatherDetailUrl = checklistState.weatherDetailUrl,
                        onClickUrl = { url -> viewModel.onClickUrl(url) }
                    )
                }
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    if (showCountryInfo) {
                        Icon(
                            modifier = Modifier
                                .clip(RoundedCornerShape(8.dp))
                                .clickable { showCountryInfo = false },
                            imageVector = ChevitIcon.IconArrowUpLine,
                            contentDescription = "",
                            tint = ChevitTheme.colors.grey10,
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                    } else {
                        Icon(
                            modifier = Modifier
                                .clip(RoundedCornerShape(8.dp))
                                .clickable { showCountryInfo = true },
                            imageVector = ChevitIcon.IconArrowDownLine,
                            contentDescription = "",
                            tint = ChevitTheme.colors.grey10,
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                    }
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(4.dp)
                        .background(color = ChevitTheme.colors.grey0)
                )
                Spacer(modifier = Modifier.height(24.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp), verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        modifier = Modifier.weight(1f),
                        text = "체크리스트 템플릿",
                        style = ChevitTheme.typhography.headlineMedium.copy(color = ChevitTheme.colors.textPrimary),
                    )
                    if (checklistState.categories.isNotEmpty()) {
                        Text(
                            text = "공개",
                            style = ChevitTheme.typhography.bodyMedium.copy(color = ChevitTheme.colors.textSecondary),
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Switch(
                            modifier = Modifier.size(width = 48.dp, height = 24.dp),
                            checked = checklistState.isTemplateOpen,
                            onCheckedChange = {
                                viewModel.dispatch(
                                    ChecklistIntent.ChangeTemplateOpenSetting(
                                        it
                                    )
                                )
                            },
                            colors = SwitchDefaults.colors(
                                checkedThumbColor = ChevitTheme.colors.white,
                                checkedTrackColor = ChevitTheme.colors.blue7,
                                checkedBorderColor = Color.Unspecified,
                                uncheckedThumbColor = ChevitTheme.colors.white,
                                uncheckedTrackColor = ChevitTheme.colors.grey2,
                                uncheckedBorderColor = Color.Unspecified,
                            ),
                        )
                    }
                }
                Spacer(modifier = Modifier.height(24.dp))
                if (checklistState.categories.isEmpty()) {
                    CategoryEmptyContents(
                        addCategory = { navigateAddCategory() }
                    )
                } else {
                    CategoryListContents(
                        categories = checklistState.categories,
                        onClickCategory = { id -> viewModel.onClickCategory(id) },
                    )
                }
            }
        }

        //dim
        if (floatingButtonOpened) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color(0x66000000))
                    .clickableNoRipple { }
            )
        }
        //floating button
        Box(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(end = 24.5.dp, bottom = 24.5.dp),
        ) {
            ChevitFloatingButton(
                isOpened = floatingButtonOpened,
                onClick = { floatingButtonOpened = !floatingButtonOpened },
                floatingContent = {
                    ChevitFloatingContent(
                        contentList = listOf(
                            FloatingContentItem(
                                icon = ChevitIcon.IconSuitcaseFill,
                                title = "카테고리 추가하기",
                                onClick = { navigateAddCategory() }),
                            FloatingContentItem(
                                icon = ChevitIcon.IconFolderReceivedFill,
                                title = "템플릿에서 불러오기",
                                onClick = { viewModel.bringTemplate() }),
                            FloatingContentItem(
                                icon = ChevitIcon.IconEditBoxFill,
                                title = "템플릿으로 저장하기",
                                onClick = {navigateSaveTemplate()})
                        )
                    )
                }
            )
        }
    }
}
