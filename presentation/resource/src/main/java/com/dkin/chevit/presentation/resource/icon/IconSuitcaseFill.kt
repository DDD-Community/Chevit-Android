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

public val ChevitIcon.IconSuitcaseFill: ImageVector
    get() {
        if (_iconSuitcaseFill != null) {
            return _iconSuitcaseFill!!
        }
        _iconSuitcaseFill = Builder(name = "IconSuitcaseFill", defaultWidth = 25.0.dp, defaultHeight
                = 25.0.dp, viewportWidth = 25.0f, viewportHeight = 25.0f).apply {
            group {
                path(fill = SolidColor(Color(0xFF171717)), stroke = null, strokeLineWidth = 0.0f,
                        strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                        pathFillType = NonZero) {
                    moveTo(18.5f, 23.75f)
                    horizontalLineTo(16.5f)
                    verticalLineTo(22.75f)
                    horizontalLineTo(8.5f)
                    verticalLineTo(23.75f)
                    horizontalLineTo(6.5f)
                    verticalLineTo(22.75f)
                    horizontalLineTo(5.5f)
                    curveTo(4.395f, 22.75f, 3.5f, 21.855f, 3.5f, 20.75f)
                    verticalLineTo(7.75f)
                    curveTo(3.5f, 6.645f, 4.395f, 5.75f, 5.5f, 5.75f)
                    horizontalLineTo(8.5f)
                    verticalLineTo(3.75f)
                    curveTo(8.5f, 3.198f, 8.948f, 2.75f, 9.5f, 2.75f)
                    horizontalLineTo(15.5f)
                    curveTo(16.052f, 2.75f, 16.5f, 3.198f, 16.5f, 3.75f)
                    verticalLineTo(5.75f)
                    horizontalLineTo(19.5f)
                    curveTo(20.605f, 5.75f, 21.5f, 6.645f, 21.5f, 7.75f)
                    verticalLineTo(20.75f)
                    curveTo(21.5f, 21.855f, 20.605f, 22.75f, 19.5f, 22.75f)
                    horizontalLineTo(18.5f)
                    verticalLineTo(23.75f)
                    close()
                    moveTo(10.5f, 9.75f)
                    horizontalLineTo(8.5f)
                    verticalLineTo(18.75f)
                    horizontalLineTo(10.5f)
                    verticalLineTo(9.75f)
                    close()
                    moveTo(16.5f, 9.75f)
                    horizontalLineTo(14.5f)
                    verticalLineTo(18.75f)
                    horizontalLineTo(16.5f)
                    verticalLineTo(9.75f)
                    close()
                    moveTo(14.5f, 4.75f)
                    horizontalLineTo(10.5f)
                    verticalLineTo(5.75f)
                    horizontalLineTo(14.5f)
                    verticalLineTo(4.75f)
                    close()
                }
            }
        }
        .build()
        return _iconSuitcaseFill!!
    }

private var _iconSuitcaseFill: ImageVector? = null
