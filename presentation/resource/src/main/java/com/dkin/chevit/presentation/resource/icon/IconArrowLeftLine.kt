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

public val ChevitIcon.IconArrowLeftLine: ImageVector
    get() {
        if (_iconArrowLeftLine != null) {
            return _iconArrowLeftLine!!
        }
        _iconArrowLeftLine = Builder(name = "IconArrowLeftLine", defaultWidth = 8.0.dp,
                defaultHeight = 13.0.dp, viewportWidth = 8.0f, viewportHeight = 13.0f).apply {
            path(fill = SolidColor(Color(0xFF171717)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(2.828f, 6.4997f)
                lineTo(7.778f, 11.4497f)
                lineTo(6.364f, 12.8637f)
                lineTo(0.0f, 6.4997f)
                lineTo(6.364f, 0.1357f)
                lineTo(7.778f, 1.5497f)
                lineTo(2.828f, 6.4997f)
                close()
            }
        }
        .build()
        return _iconArrowLeftLine!!
    }

private var _iconArrowLeftLine: ImageVector? = null
