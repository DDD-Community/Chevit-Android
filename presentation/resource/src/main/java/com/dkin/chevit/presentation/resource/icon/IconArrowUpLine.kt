package com.dkin.chevit.presentation.resource.icon

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

public val ChevitIcon.IconArrowUpLine: ImageVector
    get() {
        if (_iconArrowUpLine != null) {
            return _iconArrowUpLine!!
        }
        _iconArrowUpLine = Builder(name = "IconArrowUpLine", defaultWidth = 25.0.dp, defaultHeight =
                24.0.dp, viewportWidth = 25.0f, viewportHeight = 24.0f).apply {
            path(fill = SolidColor(Color(0xFF171717)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(12.7493f, 11.05f)
                lineTo(7.7993f, 16.0f)
                lineTo(6.3853f, 14.586f)
                lineTo(12.7493f, 8.222f)
                lineTo(19.1133f, 14.586f)
                lineTo(17.6993f, 16.0f)
                lineTo(12.7493f, 11.05f)
                close()
            }
        }
        .build()
        return _iconArrowUpLine!!
    }

private var _iconArrowUpLine: ImageVector? = null
