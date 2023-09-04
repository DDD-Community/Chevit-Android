package com.dkin.chevit.presentation.resource

import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.Color

@Stable
data class ChevitColors(
    val black: Color = Color(0xFF000000),
    val white: Color = Color(0xFFFFFFFF),

    val grey10: Color = Color(0xFF171717),
    val grey9: Color = Color(0xFF1B1B1B),
    val grey8: Color = Color(0xFF454545),
    val grey7: Color = Color(0xFF5D5D5D),
    val grey6: Color = Color(0xFF747474),
    val grey5: Color = Color(0xFF8B8B8B),
    val grey4: Color = Color(0xFFA2A2A2),
    val grey3: Color = Color(0xFFB9B9B9),
    val grey2: Color = Color(0xFFD1D1D1),
    val grey1: Color = Color(0xFFE8E8E8),
    val grey0: Color = Color(0xFFF3F3F3),

    val blue10: Color = Color(0xFF020066),
    val blue9: Color = Color(0xFF030099),
    val blue8: Color = Color(0xFF0400CC),
    val blue7: Color = Color(0xFF3531FF),
    val blue6: Color = Color(0xFF4A47FF),
    val blue5: Color = Color(0xFF7370FF),
    val blue4: Color = Color(0xFF8785FF),
    val blue3: Color = Color(0xFF9B99FF),
    val blue2: Color = Color(0xFFC3C2FF),
    val blue1: Color = Color(0xFFD7DAFF),

    val orange6: Color = Color(0xFFFF5C00),
    val orange5: Color = Color(0xFFFD7A1B),
    val orange4: Color = Color(0xFFFF9534),
    val orange3: Color = Color(0xFFFFAE63),
    val orange2: Color = Color(0xFFFFC38C),
    val orange1: Color = Color(0xFFFFE9DC),

    val backgroundBasic: Color = Color(0xFFFFFFFF),
    val backgroundElevated: Color = Color(0xFFFFFFFF),
    val backgroundContents: Color = Color(0x0D171717),

    val pressLight: Color = Color(0xFFFFFFFF),
    val pressGrey: Color = Color(0x0D171717),

    val shadowBasic: Color = Color(0x1A171717),
    val shadowThick: Color = Color(0x33171717),

    val statusError: Color = Color(0xFFFF4D4D),
    val statusCancel: Color = Color(0xFFFF4D4D),
    val statusNotice: Color = Color(0xFF21C389),

    val dimBasic: Color = Color(0x33171717),
    val dimThin: Color = Color(0x80171717),
    val dimThick: Color = Color(0xCC171717),

    val border: Color = Color(0x0D171717),

    val textPrimary: Color = Color(0xFF171717),
    val textSecondary: Color = Color(0xCC171717),
    val textCaption: Color = Color(0x33171717),
    val textDisabled: Color = Color(0x1A171717),
)
