package com.dkin.chevit.presentation.resource.icon

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

public val ChevitIcon.IconCheckboxCircleFill: ImageVector
    get() {
        if (_iconCheckboxCircleFill != null) {
            return _iconCheckboxCircleFill!!
        }
        _iconCheckboxCircleFill = Builder(name = "IconCheckboxCircleFill", defaultWidth =
                25.0.dp, defaultHeight = 25.0.dp, viewportWidth = 25.0f, viewportHeight =
                25.0f).apply {
            group {
                path(fill = SolidColor(Color(0xFF171717)), stroke = null, strokeLineWidth = 0.0f,
                        strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                        pathFillType = NonZero) {
                    moveTo(12.876f, 22.5f)
                    curveTo(7.353f, 22.5f, 2.876f, 18.023f, 2.876f, 12.5f)
                    curveTo(2.876f, 6.977f, 7.353f, 2.5f, 12.876f, 2.5f)
                    curveTo(18.399f, 2.5f, 22.876f, 6.977f, 22.876f, 12.5f)
                    curveTo(22.876f, 18.023f, 18.399f, 22.5f, 12.876f, 22.5f)
                    close()
                    moveTo(11.879f, 16.5f)
                    lineTo(18.949f, 9.429f)
                    lineTo(17.535f, 8.015f)
                    lineTo(11.879f, 13.672f)
                    lineTo(9.05f, 10.843f)
                    lineTo(7.636f, 12.257f)
                    lineTo(11.879f, 16.5f)
                    close()
                }
            }
        }
        .build()
        return _iconCheckboxCircleFill!!
    }

private var _iconCheckboxCircleFill: ImageVector? = null
