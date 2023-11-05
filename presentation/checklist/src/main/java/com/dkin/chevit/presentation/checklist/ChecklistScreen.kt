package com.dkin.chevit.presentation.checklist

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.dkin.chevit.presentation.checklist.component.ChecklistTopBar
import com.dkin.chevit.presentation.checklist.component.CountryInfo
import com.dkin.chevit.presentation.checklist.contents.CategoryEmptyContents
import com.dkin.chevit.presentation.checklist.contents.CategoryListContents
import com.dkin.chevit.presentation.resource.ChevitTheme
import com.dkin.chevit.presentation.resource.icon.ChevitIcon
import com.dkin.chevit.presentation.resource.icon.IconArrowDownLine
import com.dkin.chevit.presentation.resource.icon.IconArrowUpLine

@Composable
fun ChecklistScreen(
    viewModel: ChecklistViewModel,
    onClickBack: () -> Unit
) {
    val checklistState by viewModel.state.collectAsState()
    var showCountryInfo by remember { mutableStateOf(true) }

    Column(
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
        Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            if (showCountryInfo) {
                Icon(
                    modifier = Modifier.clickable { showCountryInfo = false },
                    imageVector = ChevitIcon.IconArrowUpLine,
                    contentDescription = "",
                    tint = ChevitTheme.colors.grey10,
                )
                Spacer(modifier = Modifier.height(12.dp))
            } else {
                Icon(
                    modifier = Modifier.clickable { showCountryInfo = true },
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
        Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 24.dp), verticalAlignment = Alignment.CenterVertically) {
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
            CategoryEmptyContents()
        } else {
            CategoryListContents(
                categories = checklistState.categories,
                onClickCategory = { id -> viewModel.onClickCategory(id) },
            )
        }
    }
}
