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

public val ChevitIcon.IconCloseFill: ImageVector
    get() {
        if (_iconCloseFill != null) {
            return _iconCloseFill!!
        }
        _iconCloseFill = Builder(name = "IconCloseFill", defaultWidth = 25.0.dp, defaultHeight =
                25.0.dp, viewportWidth = 25.0f, viewportHeight = 25.0f).apply {
            path(fill = SolidColor(Color(0xFF171717)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(12.5f, 11.0857f)
                lineTo(17.45f, 6.1357f)
                lineTo(18.864f, 7.5497f)
                lineTo(13.914f, 12.4997f)
                lineTo(18.864f, 17.4497f)
                lineTo(17.45f, 18.8637f)
                lineTo(12.5f, 13.9137f)
                lineTo(7.55f, 18.8637f)
                lineTo(6.136f, 17.4497f)
                lineTo(11.086f, 12.4997f)
                lineTo(6.136f, 7.5497f)
                lineTo(7.55f, 6.1357f)
                lineTo(12.5f, 11.0857f)
                close()
            }
        }
        .build()
        return _iconCloseFill!!
    }

private var _iconCloseFill: ImageVector? = null
