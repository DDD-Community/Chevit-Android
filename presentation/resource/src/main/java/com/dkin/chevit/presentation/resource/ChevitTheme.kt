package com.dkin.chevit.presentation.resource

import androidx.compose.material3.ProvideTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf

@Composable
fun ChevitTheme(
    typhography: ChevitTyphography = ChevitTheme.typhography,
    colors: ChevitColors = ChevitTheme.colors,
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(
        LocalColors provides colors,
        LocalTypography provides typhography,
    ) {
        ProvideTextStyle(typhography.bodyMedium, content = content)
    }
}

val LocalColors = staticCompositionLocalOf { ChevitColors() }
val LocalTypography = staticCompositionLocalOf { ChevitTyphography() }

object ChevitTheme {
    val colors: ChevitColors
        @Composable
        @ReadOnlyComposable
        get() = LocalColors.current

    val typhography: ChevitTyphography
        @Composable
        @ReadOnlyComposable
        get() = LocalTypography.current
}
