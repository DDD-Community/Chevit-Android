package com.dkin.chevit.presentation.resource

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Composable
fun ChevitDialog(
    title: String = "",
    body: String = "",
    cancelBtnText: String = "취소",
    confirmBtnText: String = "확인",
    onClickCancel: () -> Unit = {},
    onClickConfirm: () -> Unit = {},
    onDismissRequest: () -> Unit = {},
) {
    Dialog(onDismissRequest = onDismissRequest) {
        Surface(
            modifier = Modifier.wrapContentSize(),
            shape = RoundedCornerShape(12.dp),
            color = ChevitTheme.colors.white
        ) {
            Column(modifier = Modifier.padding(horizontal = 20.dp, vertical = 24.dp)) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = title,
                    style = ChevitTheme.typhography.headlineMedium.copy(color = ChevitTheme.colors.textPrimary),
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(8.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(min = 60.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = body,
                        style = ChevitTheme.typhography.bodyMedium.copy(color = ChevitTheme.colors.textSecondary),
                        textAlign = TextAlign.Center
                    )
                }
                Spacer(modifier = Modifier.height(24.dp))
                Row {
                    ChevitButtonLineMedium(
                        modifier = Modifier.weight(1f),
                        onClick = onClickCancel
                    ) {
                        Text(
                            text = cancelBtnText,
                            textAlign = TextAlign.Center
                        )
                    }
                    Spacer(modifier = Modifier.width(12.dp))
                    ChevitButtonFillMedium(
                        modifier = Modifier.weight(1f),
                        onClick = onClickConfirm
                    ) {
                        Text(
                            text = confirmBtnText,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    }
}