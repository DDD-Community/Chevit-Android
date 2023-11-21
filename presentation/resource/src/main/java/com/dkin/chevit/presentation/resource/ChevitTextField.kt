package com.dkin.chevit.presentation.resource

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChevitTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    isInputError: Boolean = false,
    maxLines: Int = 1,
    placeholder: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
) {
    OutlinedTextField(
        modifier = modifier,
        value = value,
        onValueChange = onValueChange,
        maxLines = maxLines,
        shape = RoundedCornerShape(8.dp),
        textStyle = ChevitTheme.typhography.bodyLarge.copy(color = ChevitTheme.colors.grey10),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedTextColor = ChevitTheme.colors.grey10,
            unfocusedTextColor = ChevitTheme.colors.grey10,
            disabledTextColor = ChevitTheme.colors.grey10,
            focusedBorderColor = if (isInputError) ChevitTheme.colors.statusError else ChevitTheme.colors.grey4,
            unfocusedBorderColor = if (isInputError) ChevitTheme.colors.statusError else ChevitTheme.colors.grey4,
            disabledBorderColor = if (isInputError) ChevitTheme.colors.statusError else ChevitTheme.colors.grey4,
            errorBorderColor = if (isInputError) ChevitTheme.colors.statusError else ChevitTheme.colors.grey4,
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
        ),
        placeholder = placeholder,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
    )
}
