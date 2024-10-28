package com.dkin.chevit.presentation.resource

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun ChevitInput(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    isInputError: Boolean = false,
    maxLines: Int = 1,
    placeholder: @Composable() (() -> Unit)? = null,
    trailingIcon: @Composable() (() -> Unit)? = null,
) {
    Column {
        TextFieldDefaults.colors(
            focusedTextColor = ChevitTheme.colors.grey10,
        )
        TextField(
            modifier = modifier,
            value = value,
            onValueChange = onValueChange,
            maxLines = maxLines,
            singleLine = true,
            shape = RoundedCornerShape(8.dp),
            textStyle = ChevitTheme.typography.bodyLarge.copy(color = ChevitTheme.colors.grey10),
            colors = TextFieldDefaults.colors(
                focusedTextColor = ChevitTheme.colors.grey10,
                unfocusedTextColor = ChevitTheme.colors.grey10,
                disabledTextColor = ChevitTheme.colors.grey10,
                focusedLeadingIconColor = ChevitTheme.colors.grey10,
                unfocusedLeadingIconColor = ChevitTheme.colors.grey4,
                disabledLeadingIconColor = ChevitTheme.colors.grey4,
                errorLeadingIconColor = ChevitTheme.colors.grey4,
                focusedTrailingIconColor = ChevitTheme.colors.grey4,
                unfocusedTrailingIconColor = ChevitTheme.colors.grey4,
                disabledTrailingIconColor = ChevitTheme.colors.grey4,
                errorTrailingIconColor = ChevitTheme.colors.grey4,
                focusedPlaceholderColor = ChevitTheme.colors.grey4,
                unfocusedPlaceholderColor = ChevitTheme.colors.grey4,
                disabledPlaceholderColor = ChevitTheme.colors.grey4,
                disabledContainerColor = ChevitTheme.colors.white,
                focusedContainerColor = ChevitTheme.colors.white,
                errorContainerColor = ChevitTheme.colors.white,
                unfocusedContainerColor = ChevitTheme.colors.white,
            ),
            placeholder = placeholder,
            trailingIcon = trailingIcon,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )
    }
}
