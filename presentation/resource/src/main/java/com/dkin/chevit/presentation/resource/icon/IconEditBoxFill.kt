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

public val ChevitIcon.IconEditBoxFill: ImageVector
    get() {
        if (_iconEditBoxFill != null) {
            return _iconEditBoxFill!!
        }
        _iconEditBoxFill = Builder(name = "IconEditBoxFill", defaultWidth = 25.0.dp,
                defaultHeight = 25.0.dp, viewportWidth = 25.0f, viewportHeight = 25.0f).apply {
            group {
                path(fill = SolidColor(Color(0xFF171717)), stroke = null, strokeLineWidth = 0.0f,
                        strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                        pathFillType = NonZero) {
                    moveTo(17.257f, 3.7496f)
                    lineTo(9.791f, 11.2156f)
                    lineTo(9.799f, 15.4626f)
                    lineTo(14.037f, 15.4556f)
                    lineTo(21.5f, 7.9926f)
                    verticalLineTo(20.7496f)
                    curveTo(21.5f, 21.0148f, 21.3946f, 21.2692f, 21.2071f, 21.4567f)
                    curveTo(21.0196f, 21.6443f, 20.7652f, 21.7496f, 20.5f, 21.7496f)
                    horizontalLineTo(4.5f)
                    curveTo(4.2348f, 21.7496f, 3.9804f, 21.6443f, 3.7929f, 21.4567f)
                    curveTo(3.6054f, 21.2692f, 3.5f, 21.0148f, 3.5f, 20.7496f)
                    verticalLineTo(4.7496f)
                    curveTo(3.5f, 4.4844f, 3.6054f, 4.23f, 3.7929f, 4.0425f)
                    curveTo(3.9804f, 3.855f, 4.2348f, 3.7496f, 4.5f, 3.7496f)
                    horizontalLineTo(17.257f)
                    close()
                    moveTo(20.985f, 2.8496f)
                    lineTo(22.4f, 4.2656f)
                    lineTo(13.208f, 13.4576f)
                    lineTo(11.796f, 13.4606f)
                    lineTo(11.794f, 12.0436f)
                    lineTo(20.985f, 2.8496f)
                    close()
                }
            }
        }
        .build()
        return _iconEditBoxFill!!
    }

private var _iconEditBoxFill: ImageVector? = null
