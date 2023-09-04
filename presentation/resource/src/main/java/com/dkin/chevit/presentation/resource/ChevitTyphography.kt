package com.dkin.chevit.presentation.resource

import androidx.compose.runtime.Stable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Stable
data class ChevitTyphography(
    val displayLarge: TextStyle = TextStyle(
        fontWeight = FontWeight.Bold,
        lineHeight = 52.sp,
        fontSize = 40.sp,
        letterSpacing = (-0.6).sp,
    ),
    val displayMedium: TextStyle = TextStyle(
        fontWeight = FontWeight.Bold,
        lineHeight = 42.sp,
        fontSize = 32.sp,
        letterSpacing = (-0.6).sp,
    ),
    val displaySmall: TextStyle = TextStyle(
        fontWeight = FontWeight.Bold,
        lineHeight = 38.sp,
        fontSize = 28.sp,
        letterSpacing = (-0.6).sp,
    ),
    val headlineLarge: TextStyle = TextStyle(
        fontWeight = FontWeight.Bold,
        lineHeight = 34.sp,
        fontSize = 24.sp,
        letterSpacing = (-0.6).sp,
    ),
    val headlineMedium: TextStyle = TextStyle(
        fontWeight = FontWeight.Bold,
        lineHeight = 28.sp,
        fontSize = 20.sp,
        letterSpacing = (-0.6).sp,
    ),
    val headlineSmall: TextStyle = TextStyle(
        fontWeight = FontWeight.Bold,
        lineHeight = 22.sp,
        fontSize = 16.sp,
        letterSpacing = (-0.6).sp,
    ),
    val bodyLarge: TextStyle = TextStyle(
        fontWeight = FontWeight.Medium,
        lineHeight = 20.sp,
        fontSize = 16.sp,
    ),
    val bodyMedium: TextStyle = TextStyle(
        fontWeight = FontWeight.Medium,
        lineHeight = 18.sp,
        fontSize = 14.sp,
    ),
    val bodySmall: TextStyle = TextStyle(
        fontWeight = FontWeight.Medium,
        lineHeight = 18.sp,
        fontSize = 12.sp,
    ),
    val caption: TextStyle = TextStyle(
        fontWeight = FontWeight.Normal,
        lineHeight = 18.sp,
        fontSize = 11.sp,
    ),
)
