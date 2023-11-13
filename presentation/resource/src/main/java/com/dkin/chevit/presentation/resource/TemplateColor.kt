package com.dkin.chevit.presentation.resource

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.dkin.chevit.presentation.resource.icon.ChevitIcon
import com.dkin.chevit.presentation.resource.icon.TemplateAfternoon
import com.dkin.chevit.presentation.resource.icon.TemplateDawn
import com.dkin.chevit.presentation.resource.icon.TemplateMorning
import com.dkin.chevit.presentation.resource.icon.TemplateNight
import com.dkin.chevit.presentation.resource.icon.TemplateSunset

enum class TemplateColor(val color: Color, val icon: ImageVector) {
    DAWN(color = Color(0xFF8785FF), icon = ChevitIcon.TemplateDawn),
    MORNING(color = Color(0xFF4A47FF), icon = ChevitIcon.TemplateMorning),
    AFTERNOON(color = Color(0xFFFFAE63), icon = ChevitIcon.TemplateAfternoon),
    SUNSET(color = Color(0xFFFF9534), icon = ChevitIcon.TemplateSunset),
    NIGHT(color = Color(0xFF030099), icon = ChevitIcon.TemplateNight)
}