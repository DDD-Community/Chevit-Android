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

public val ChevitIcon.IconMoreLine: ImageVector
    get() {
        if (_iconMoreLine != null) {
            return _iconMoreLine!!
        }
        _iconMoreLine = Builder(name = "IconMoreLine", defaultWidth = 25.0.dp, defaultHeight =
                25.0.dp, viewportWidth = 25.0f, viewportHeight = 25.0f).apply {
            group {
                path(fill = SolidColor(Color(0xFF171717)), stroke = null, strokeLineWidth = 0.0f,
                        strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                        pathFillType = NonZero) {
                    moveTo(4.8232f, 11.0f)
                    curveTo(3.9982f, 11.0f, 3.3232f, 11.675f, 3.3232f, 12.5f)
                    curveTo(3.3232f, 13.325f, 3.9982f, 14.0f, 4.8232f, 14.0f)
                    curveTo(5.6482f, 14.0f, 6.3232f, 13.325f, 6.3232f, 12.5f)
                    curveTo(6.3232f, 11.675f, 5.6482f, 11.0f, 4.8232f, 11.0f)
                    close()
                    moveTo(19.8232f, 11.0f)
                    curveTo(18.9982f, 11.0f, 18.3232f, 11.675f, 18.3232f, 12.5f)
                    curveTo(18.3232f, 13.325f, 18.9982f, 14.0f, 19.8232f, 14.0f)
                    curveTo(20.6482f, 14.0f, 21.3232f, 13.325f, 21.3232f, 12.5f)
                    curveTo(21.3232f, 11.675f, 20.6482f, 11.0f, 19.8232f, 11.0f)
                    close()
                    moveTo(12.3232f, 11.0f)
                    curveTo(11.4982f, 11.0f, 10.8232f, 11.675f, 10.8232f, 12.5f)
                    curveTo(10.8232f, 13.325f, 11.4982f, 14.0f, 12.3232f, 14.0f)
                    curveTo(13.1482f, 14.0f, 13.8232f, 13.325f, 13.8232f, 12.5f)
                    curveTo(13.8232f, 11.675f, 13.1482f, 11.0f, 12.3232f, 11.0f)
                    close()
                }
            }
        }
        .build()
        return _iconMoreLine!!
    }

private var _iconMoreLine: ImageVector? = null
