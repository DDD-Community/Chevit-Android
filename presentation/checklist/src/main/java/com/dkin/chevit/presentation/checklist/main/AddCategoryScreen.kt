package com.dkin.chevit.presentation.checklist.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.dkin.chevit.presentation.checklist.model.CategoryType
import com.dkin.chevit.presentation.checklist.model.getCategoryIconResId
import com.dkin.chevit.presentation.resource.ChevitButtonFillMedium
import com.dkin.chevit.presentation.resource.ChevitTextField
import com.dkin.chevit.presentation.resource.ChevitTheme
import com.dkin.chevit.presentation.resource.icon.ChevitIcon
import com.dkin.chevit.presentation.resource.icon.IconArrowLeftLine
import com.dkin.chevit.presentation.resource.icon.IconCloseCircleFill
import com.dkin.chevit.presentation.resource.util.clickableNoRipple

@Composable
fun AddCategoryScreen(
    saveCategory: (title: String, category: CategoryType) -> Unit,
    onClickBack: () -> Unit,
) {
    var input by remember { mutableStateOf("") }
    var selectedCategory by remember { mutableStateOf<CategoryType?>(null) }
    var isValidInput by remember { mutableStateOf(true) }
    var saveable by remember { mutableStateOf(false) }

    LaunchedEffect(input) {
        isValidInput = input.length < 9
        saveable = input.isNotBlank() && isValidInput && (selectedCategory != null)
    }
    LaunchedEffect(selectedCategory) {
        saveable = input.isNotBlank() && isValidInput && (selectedCategory != null)
    }

    val categories = CategoryType.values()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        TopBar(modifier = Modifier.fillMaxWidth(), onClickBack = onClickBack)
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp),
        ) {
            Spacer(modifier = Modifier.height(25.dp))
            Text(
                text = "새 카테고리",
                style = ChevitTheme.typhography.headlineMedium.copy(color = ChevitTheme.colors.textPrimary),
            )
            Spacer(modifier = Modifier.height(18.dp))
            Text(
                text = "카테고리 제목을 입력해 주세요.",
                style = ChevitTheme.typhography.bodyMedium.copy(color = ChevitTheme.colors.grey6),
            )
            Spacer(modifier = Modifier.height(8.dp))
            ChevitTextField(
                modifier = Modifier.fillMaxWidth(),
                value = input,
                isInputError = !isValidInput,
                onValueChange = {
                    input = it
                },
                placeholder = {
                    Text(
                        modifier = Modifier,
                        text = "ex. 기내 아이템",
                        style = ChevitTheme.typhography.bodyLarge.copy(color = ChevitTheme.colors.grey4),
                    )
                },
                trailingIcon = {
                    if (input.isNotEmpty()) {
                        Icon(
                            modifier = Modifier
                                .size(20.dp)
                                .clickableNoRipple {
                                    input = ""
                                },
                            imageVector = ChevitIcon.IconCloseCircleFill,
                            contentDescription = "",
                        )
                    }
                }
            )
            if (!isValidInput) {
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp),
                    text = "최대 8글자까지 입력해주세요.",
                    style = ChevitTheme.typhography.bodySmall.copy(color = ChevitTheme.colors.statusError),
                )
            }
            Spacer(modifier = Modifier.height(32.dp))
            Text(
                text = "아이콘",
                style = ChevitTheme.typhography.headlineMedium.copy(color = ChevitTheme.colors.textPrimary),
            )
            LazyVerticalGrid(
                modifier = Modifier.weight(1f),
                columns = GridCells.Fixed(5),
                horizontalArrangement = Arrangement.spacedBy(22.dp),
                verticalArrangement = Arrangement.spacedBy(22.dp),
                contentPadding = PaddingValues(vertical = 18.dp)
            ) {
                items(categories) { category ->
                    val isSelected = category == selectedCategory
                    Box(
                        modifier = Modifier
                            .size(48.dp)
                            .background(color = ChevitTheme.colors.grey0, shape = CircleShape)
                            .border(
                                width = if (isSelected) 1.dp else (-1).dp,
                                color = ChevitTheme.colors.grey10,
                                shape = CircleShape,
                            )
                            .clickable { selectedCategory = category },
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = category.getCategoryIconResId()),
                            contentDescription = ""
                        )
                    }
                }
            }
            ChevitButtonFillMedium(
                modifier = Modifier.fillMaxWidth(),
                enabled = saveable,
                onClick = { selectedCategory?.let { saveCategory(input, it) } }
            ) {
                Text(text = "저장하기")
            }
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Composable
private fun TopBar(modifier: Modifier, onClickBack: () -> Unit) {
    Box(
        modifier = modifier
            .height(58.dp)
            .padding(vertical = 16.dp, horizontal = 24.dp),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            modifier = Modifier
                .align(Alignment.CenterStart)
                .clickableNoRipple { onClickBack() },
            imageVector = ChevitIcon.IconArrowLeftLine,
            contentDescription = "",
        )
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = "카테고리 추가하기",
            textAlign = TextAlign.Center,
            style = ChevitTheme.typhography.headlineMedium.copy(color = ChevitTheme.colors.textPrimary)
        )
    }
}
