package com.dkin.chevit.presentation.checklist.detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier

@Composable
fun ChecklistDetailScreen(
    viewModel: ChecklistDetailViewModel,
    onClickBack: () -> Boolean,
    navigateAddItem: () -> Unit,
    navigateEditItem: () -> Unit,
    openSortSheet: () -> Unit,
    openEditSheet: () -> Unit,
) {
    val detailState by viewModel.state.collectAsState()

    Box(modifier = Modifier.fillMaxSize()) {

    }
}