package com.dkin.chevit.presentation.step.contents

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import com.dkin.chevit.presentation.resource.util.clickableNoRipple
import com.dkin.chevit.presentation.resource.ChevitButtonFillLarge
import com.dkin.chevit.presentation.resource.ChevitTextField
import com.dkin.chevit.presentation.resource.ChevitTheme
import com.dkin.chevit.presentation.resource.icon.ChevitIcon
import com.dkin.chevit.presentation.resource.icon.IconCloseCircleFill
import com.dkin.chevit.presentation.resource.icon.IconMapPinFill
import com.dkin.chevit.presentation.resource.icon.IconSearch
import com.dkin.chevit.presentation.step.StepIntent
import com.dkin.chevit.presentation.step.StepViewModel
import com.dkin.chevit.presentation.step.model.CountryModel
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.debounce

@OptIn(ExperimentalComposeUiApi::class, FlowPreview::class)
@Composable
fun WhereContents(
    modifier: Modifier,
    viewModel: StepViewModel,
    onClickNext: () -> Unit
) {
    val stepState by viewModel.state.collectAsState()
    val countryList by viewModel.countryList.collectAsState()
    var input by remember { mutableStateOf("") }
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current
    val searchEvent = remember {
        MutableSharedFlow<String>(
            replay = 0,
            extraBufferCapacity = 1,
            onBufferOverflow = BufferOverflow.DROP_OLDEST
        )
    }

    LaunchedEffect(input) {
        if (input.isNotBlank()) {
            searchEvent.tryEmit(input)
        }
    }

    LaunchedEffect(true) {
        searchEvent
            .debounce(300L)
            .collect { input ->
                viewModel.dispatch(StepIntent.SearchCountry(input))
            }
    }

    Column(modifier) {
        Spacer(modifier = Modifier.height(50.dp))
        WhereTitle(modifier = Modifier, countryText = stepState.country?.text)
        Spacer(modifier = Modifier.height(24.dp))
        ChevitTextField(
            modifier = Modifier.fillMaxWidth(),
            value = input,
            onValueChange = {
                input = it
            },
            placeholder = {
                Text(
                    modifier = Modifier,
                    text = "도시를 입력해주세요.",
                    style = ChevitTheme.typhography.bodyLarge.copy(color = ChevitTheme.colors.grey4),
                )
            },
            leadingIcon = {
                Icon(
                    modifier = Modifier.size(24.dp),
                    imageVector = ChevitIcon.IconSearch,
                    contentDescription = "",
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
        Spacer(modifier = Modifier.height(11.dp))
        Box(modifier = Modifier.weight(1f)) {
            CountryList(
                modifier = Modifier.fillMaxWidth(),
                countryList = countryList,
                onClick = { country ->
                    keyboardController?.hide()
                    focusManager.clearFocus()
                    input = country.text
                    viewModel.onClickCountry(country)
                }
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        ChevitButtonFillLarge(
            modifier = Modifier.fillMaxWidth(),
            enabled = stepState.country != null,
            onClick = onClickNext
        ) {
            Text(text = "다음")
        }
    }
}

@Composable
fun WhereTitle(
    modifier: Modifier,
    countryText: String?
) {
    Text(
        modifier = modifier,
        text = "어디로 떠나시나요?",
        style = ChevitTheme.typhography.headlineLarge.copy(color = ChevitTheme.colors.textPrimary)
    )
    Spacer(modifier = Modifier.height(8.dp))
    if (countryText.isNullOrEmpty()) {
        Text(
            modifier = Modifier,
            text = "여행가고자 하는 도시를 검색 목록에서 선택해 주세요",
            style = ChevitTheme.typhography.bodyLarge.copy(color = ChevitTheme.colors.textSecondary)
        )
    } else {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                modifier = Modifier.size(20.dp),
                imageVector = ChevitIcon.IconMapPinFill,
                contentDescription = "",
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                modifier = Modifier,
                text = countryText,
                style = ChevitTheme.typhography.bodyLarge.copy(color = ChevitTheme.colors.textSecondary),
            )
        }
    }
}

@Composable
fun CountryList(
    modifier: Modifier,
    countryList: List<CountryModel>,
    onClick: (country: CountryModel) -> Unit
) {
    LazyColumn(
        modifier = modifier
            .clip(RoundedCornerShape(4.dp))
            .border(
                width = 1.dp,
                color = ChevitTheme.colors.grey3,
                shape = RoundedCornerShape(4.dp)
            )
    ) {
        items(countryList) { item ->
            CountryItem(
                modifier = Modifier.fillMaxWidth(),
                country = item,
                onClick = onClick
            )
        }
    }
}

@Composable
fun CountryItem(
    modifier: Modifier,
    country: CountryModel,
    onClick: (country: CountryModel) -> Unit
) {
    Column(
        modifier
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = rememberRipple(color = ChevitTheme.colors.blue2),
            ) { onClick(country) }
            .padding(horizontal = 12.dp, vertical = 18.dp)
    ) {
        Text(
            modifier = Modifier,
            text = country.text,
            style = ChevitTheme.typhography.bodyLarge.copy(color = ChevitTheme.colors.textPrimary),
        )
    }
}