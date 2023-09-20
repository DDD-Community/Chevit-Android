package com.dkin.chevit.presentation.resource

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun ChevitButtonChip(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    onClick: () -> Unit = {},
    selected: Boolean = false,
    text: String,
) {
    ChevitButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        shape = RoundedCornerShape(100.dp),
        containerColor = Color.Unspecified,
        contentColor = if (selected) ChevitTheme.colors.blue7 else ChevitTheme.colors.grey4,
        focusedContentColor = ChevitTheme.colors.blue4,
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        textStyle = ChevitTheme.typhography.bodyLarge,
        borderColor = if (selected) ChevitTheme.colors.blue7 else ChevitTheme.colors.grey4,
        borderWidth = if (selected) 2.dp else 1.dp
    ) {
        Text(text = text)
    }
}

@Composable
fun ChevitButtonFillLarge(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    onClick: () -> Unit = {},
    content: @Composable RowScope.() -> Unit,
) {
    ChevitButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        shape = RoundedCornerShape(12.dp),
        containerColor = ChevitTheme.colors.blue7,
        pressedContainerColor = ChevitTheme.colors.blue8,
        contentColor = ChevitTheme.colors.white,
        disabledContainerColor = ChevitTheme.colors.blue1,
        disabledContentColor = ChevitTheme.colors.white,
        contentPadding = PaddingValues(horizontal = 32.dp, vertical = 16.dp),
        textStyle = ChevitTheme.typhography.headlineMedium,
        content = content,
    )
}

@Composable
fun ChevitButtonFillMedium(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    onClick: () -> Unit = {},
    content: @Composable RowScope.() -> Unit,
) {
    ChevitButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        shape = RoundedCornerShape(12.dp),
        containerColor = ChevitTheme.colors.blue7,
        pressedContainerColor = ChevitTheme.colors.blue8,
        contentColor = ChevitTheme.colors.white,
        disabledContainerColor = ChevitTheme.colors.blue1,
        disabledContentColor = ChevitTheme.colors.white,
        contentPadding = PaddingValues(horizontal = 32.dp, vertical = 16.dp),
        textStyle = ChevitTheme.typhography.headlineSmall,
        content = content,
    )
}

@Composable
fun ChevitButtonLineLarge(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    selected: Boolean = false,
    onClick: () -> Unit = {},
    content: @Composable RowScope.() -> Unit,
) {
    ChevitButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        shape = RoundedCornerShape(12.dp),
        containerColor = if (selected) ChevitTheme.colors.blue1 else Color.Transparent,
        pressedContainerColor = ChevitTheme.colors.blue1,
        disabledContainerColor = Color.Transparent,
        contentColor = if (selected) ChevitTheme.colors.blue8 else ChevitTheme.colors.blue6,
        pressedContentColor = ChevitTheme.colors.blue8,
        disabledContentColor = ChevitTheme.colors.blue2,
        borderColor = if (selected) ChevitTheme.colors.blue8 else ChevitTheme.colors.blue6,
        pressedBorderColor = ChevitTheme.colors.blue8,
        contentPadding = PaddingValues(horizontal = 24.dp, vertical = 16.dp),
        textStyle = ChevitTheme.typhography.headlineMedium,
        content = content,
    )
}

@Composable
internal fun ChevitButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = false,
    shape: Shape = ButtonDefaults.shape,
    containerColor: Color,
    pressedContainerColor: Color = containerColor,
    focusedContainerColor: Color = containerColor,
    disabledContainerColor: Color = containerColor,
    contentColor: Color,
    pressedContentColor: Color = contentColor,
    focusedContentColor: Color = contentColor,
    disabledContentColor: Color = contentColor,
    elevation: ButtonElevation? = ButtonDefaults.buttonElevation(),
    borderColor: Color? = null,
    borderWidth: Dp = 1.dp,
    pressedBorderColor: Color? = borderColor,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    textStyle: TextStyle,
    content: @Composable RowScope.() -> Unit,
) {
    val isPressed by interactionSource.collectIsPressedAsState()
    val isFocused by interactionSource.collectIsFocusedAsState()

    Button(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        shape = shape,
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isPressed) pressedContainerColor else if (isFocused) focusedContainerColor else containerColor,
            contentColor = if (isPressed) pressedContentColor else if (isFocused) focusedContentColor else contentColor,
            disabledContainerColor = disabledContainerColor,
            disabledContentColor = disabledContentColor,
        ),
        elevation = elevation,
        border = borderColor?.let {
            BorderStroke(
                width = borderWidth,
                color = if (isPressed && pressedBorderColor != null) pressedBorderColor else it
            )
        },
        contentPadding = contentPadding,
        interactionSource = interactionSource,
    ) {
        CompositionLocalProvider(LocalContentColor provides contentColor) {
            ProvideTextStyle(value = textStyle) {
                content()
            }
        }
    }
}
