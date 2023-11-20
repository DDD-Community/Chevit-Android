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

public val ChevitIcon.IconMinusFill: ImageVector
    get() {
        if (_iconMinusFill != null) {
            return _iconMinusFill!!
        }
        _iconMinusFill = Builder(name = "IconMinusFill", defaultWidth = 25.0.dp, defaultHeight =
                24.0.dp, viewportWidth = 25.0f, viewportHeight = 24.0f).apply {
            group {
                path(fill = SolidColor(Color(0xFF171717)), stroke = null, strokeLineWidth = 0.0f,
                        strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                        pathFillType = NonZero) {
                    moveTo(5.0732f, 11.0098f)
                    horizontalLineTo(19.0732f)
                    verticalLineTo(13.0098f)
                    horizontalLineTo(5.0732f)
                    verticalLineTo(11.0098f)
                    close()
                }
            }
        }
        .build()
        return _iconMinusFill!!
    }

private var _iconMinusFill: ImageVector? = null
