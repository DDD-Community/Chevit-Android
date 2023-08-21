package com.dkin.chevit.presentation.home.icon

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

public val HomeIcons.Home: ImageVector
    get() {
        if (_home != null) {
            return _home!!
        }
        _home = Builder(name = "Home", defaultWidth = 25.0.dp, defaultHeight = 24.0.dp,
                viewportWidth = 25.0f, viewportHeight = 24.0f).apply {
            group {
                path(fill = SolidColor(Color(0xFFA2A2A2)), stroke = null, strokeLineWidth = 0.0f,
                        strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                        pathFillType = NonZero) {
                    moveTo(19.5f, 19.0001f)
                    verticalLineTo(9.7991f)
                    lineTo(12.5f, 4.2771f)
                    lineTo(5.5f, 9.7991f)
                    verticalLineTo(19.0001f)
                    horizontalLineTo(19.5f)
                    close()
                    moveTo(21.5f, 20.0001f)
                    curveTo(21.5f, 20.2653f, 21.3946f, 20.5197f, 21.2071f, 20.7072f)
                    curveTo(21.0196f, 20.8947f, 20.7652f, 21.0001f, 20.5f, 21.0001f)
                    horizontalLineTo(4.5f)
                    curveTo(4.2348f, 21.0001f, 3.9804f, 20.8947f, 3.7929f, 20.7072f)
                    curveTo(3.6054f, 20.5197f, 3.5f, 20.2653f, 3.5f, 20.0001f)
                    verticalLineTo(9.3141f)
                    curveTo(3.4999f, 9.163f, 3.5341f, 9.0139f, 3.5999f, 8.878f)
                    curveTo(3.6657f, 8.742f, 3.7615f, 8.6227f, 3.88f, 8.5291f)
                    lineTo(11.88f, 2.2181f)
                    curveTo(12.0565f, 2.0786f, 12.275f, 2.0027f, 12.5f, 2.0027f)
                    curveTo(12.725f, 2.0027f, 12.9435f, 2.0786f, 13.12f, 2.2181f)
                    lineTo(21.12f, 8.5281f)
                    curveTo(21.2386f, 8.6218f, 21.3345f, 8.7413f, 21.4003f, 8.8774f)
                    curveTo(21.4661f, 9.0136f, 21.5002f, 9.1629f, 21.5f, 9.3141f)
                    verticalLineTo(20.0001f)
                    close()
                    moveTo(7.5f, 12.0001f)
                    horizontalLineTo(9.5f)
                    curveTo(9.5f, 12.7957f, 9.8161f, 13.5588f, 10.3787f, 14.1214f)
                    curveTo(10.9413f, 14.684f, 11.7044f, 15.0001f, 12.5f, 15.0001f)
                    curveTo(13.2956f, 15.0001f, 14.0587f, 14.684f, 14.6213f, 14.1214f)
                    curveTo(15.1839f, 13.5588f, 15.5f, 12.7957f, 15.5f, 12.0001f)
                    horizontalLineTo(17.5f)
                    curveTo(17.5f, 13.3262f, 16.9732f, 14.5979f, 16.0355f, 15.5356f)
                    curveTo(15.0979f, 16.4733f, 13.8261f, 17.0001f, 12.5f, 17.0001f)
                    curveTo(11.1739f, 17.0001f, 9.9022f, 16.4733f, 8.9645f, 15.5356f)
                    curveTo(8.0268f, 14.5979f, 7.5f, 13.3262f, 7.5f, 12.0001f)
                    close()
                }
            }
        }
        .build()
        return _home!!
    }

private var _home: ImageVector? = null
