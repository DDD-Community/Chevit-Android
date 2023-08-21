package com.dkin.chevit.presentation.home.icon

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.EvenOdd
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

public val HomeIcons.Logo: ImageVector
    get() {
        if (_logo != null) {
            return _logo!!
        }
        _logo = Builder(name = "Logo", defaultWidth = 102.0.dp, defaultHeight = 24.0.dp,
                viewportWidth = 102.0f, viewportHeight = 24.0f).apply {
            group {
                path(fill = SolidColor(Color(0xFF171717)), stroke = null, strokeLineWidth = 0.0f,
                        strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                        pathFillType = NonZero) {
                    moveTo(28.88f, 11.55f)
                    curveTo(28.88f, 7.662f, 31.166f, 5.434f, 35.192f, 5.434f)
                    curveTo(39.178f, 5.434f, 41.25f, 7.662f, 41.25f, 10.534f)
                    horizontalLineTo(38.357f)
                    curveTo(38.357f, 8.912f, 37.126f, 7.916f, 35.192f, 7.916f)
                    curveTo(33.003f, 7.916f, 31.772f, 9.225f, 31.772f, 11.55f)
                    verticalLineTo(13.602f)
                    curveTo(31.772f, 15.928f, 33.003f, 17.257f, 35.192f, 17.257f)
                    curveTo(37.126f, 17.257f, 38.357f, 16.24f, 38.357f, 14.618f)
                    horizontalLineTo(41.25f)
                    curveTo(41.25f, 17.491f, 39.178f, 19.738f, 35.192f, 19.738f)
                    curveTo(31.166f, 19.738f, 28.88f, 17.491f, 28.88f, 13.602f)
                    verticalLineTo(11.55f)
                    close()
                    moveTo(42.56f, 4.555f)
                    horizontalLineTo(45.315f)
                    verticalLineTo(9.127f)
                    curveTo(46.038f, 8.092f, 47.152f, 7.525f, 48.618f, 7.525f)
                    curveTo(51.706f, 7.525f, 53.464f, 9.381f, 53.464f, 12.606f)
                    verticalLineTo(19.426f)
                    horizontalLineTo(50.689f)
                    verticalLineTo(12.606f)
                    curveTo(50.689f, 10.886f, 49.732f, 9.85f, 48.012f, 9.85f)
                    curveTo(46.292f, 9.85f, 45.315f, 10.886f, 45.315f, 12.606f)
                    verticalLineTo(19.426f)
                    horizontalLineTo(42.56f)
                    verticalLineTo(4.555f)
                    close()
                    moveTo(57.471f, 14.482f)
                    curveTo(57.471f, 16.338f, 58.604f, 17.413f, 60.617f, 17.413f)
                    curveTo(62.337f, 17.413f, 63.334f, 16.768f, 63.334f, 15.654f)
                    horizontalLineTo(66.089f)
                    curveTo(66.089f, 18.273f, 64.096f, 19.758f, 60.617f, 19.758f)
                    curveTo(56.865f, 19.758f, 54.716f, 17.843f, 54.716f, 14.482f)
                    verticalLineTo(12.821f)
                    curveTo(54.716f, 9.46f, 56.865f, 7.525f, 60.617f, 7.525f)
                    curveTo(64.232f, 7.525f, 66.323f, 9.46f, 66.323f, 12.821f)
                    verticalLineTo(14.482f)
                    horizontalLineTo(57.471f)
                    close()
                    moveTo(57.53f, 12.117f)
                    horizontalLineTo(63.49f)
                    curveTo(63.236f, 10.691f, 62.239f, 9.889f, 60.617f, 9.889f)
                    curveTo(58.878f, 9.889f, 57.784f, 10.691f, 57.53f, 12.117f)
                    close()
                    moveTo(72.086f, 19.406f)
                    lineTo(66.654f, 5.747f)
                    horizontalLineTo(69.741f)
                    lineTo(73.826f, 15.967f)
                    lineTo(77.89f, 5.747f)
                    horizontalLineTo(80.997f)
                    lineTo(75.545f, 19.406f)
                    horizontalLineTo(72.086f)
                    close()
                    moveTo(81.706f, 5.629f)
                    curveTo(81.706f, 4.652f, 82.116f, 4.222f, 83.074f, 4.222f)
                    curveTo(84.051f, 4.222f, 84.461f, 4.652f, 84.461f, 5.629f)
                    curveTo(84.461f, 6.606f, 84.051f, 7.036f, 83.074f, 7.036f)
                    curveTo(82.116f, 7.036f, 81.706f, 6.606f, 81.706f, 5.629f)
                    close()
                    moveTo(81.706f, 7.857f)
                    horizontalLineTo(84.461f)
                    verticalLineTo(19.426f)
                    horizontalLineTo(81.706f)
                    verticalLineTo(7.857f)
                    close()
                    moveTo(86.803f, 7.857f)
                    verticalLineTo(6.411f)
                    horizontalLineTo(89.578f)
                    verticalLineTo(7.857f)
                    horizontalLineTo(93.604f)
                    verticalLineTo(10.222f)
                    horizontalLineTo(89.578f)
                    verticalLineTo(15.283f)
                    curveTo(89.578f, 16.651f, 90.399f, 17.433f, 91.865f, 17.433f)
                    curveTo(92.705f, 17.433f, 93.35f, 17.237f, 93.662f, 16.905f)
                    lineTo(96.281f, 18.117f)
                    curveTo(95.578f, 19.172f, 94.132f, 19.758f, 92.275f, 19.758f)
                    curveTo(88.816f, 19.758f, 86.803f, 18.019f, 86.803f, 14.951f)
                    verticalLineTo(10.222f)
                    horizontalLineTo(85.533f)
                    verticalLineTo(7.857f)
                    horizontalLineTo(86.803f)
                    close()
                }
                path(fill = SolidColor(Color(0xFF3531FF)), stroke = null, strokeLineWidth = 0.0f,
                        strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                        pathFillType = NonZero) {
                    moveTo(6.335f, 5.357f)
                    lineTo(14.718f, 5.357f)
                    arcTo(5.251f, 5.251f, 0.0f, false, true, 19.969f, 10.608f)
                    lineTo(19.969f, 18.992f)
                    arcTo(5.251f, 5.251f, 0.0f, false, true, 14.718f, 24.242f)
                    lineTo(6.335f, 24.242f)
                    arcTo(5.251f, 5.251f, 0.0f, false, true, 1.084f, 18.992f)
                    lineTo(1.084f, 10.608f)
                    arcTo(5.251f, 5.251f, 0.0f, false, true, 6.335f, 5.357f)
                    close()
                }
                path(fill = SolidColor(Color(0xFF8785FF)), stroke = null, strokeLineWidth = 0.0f,
                        strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                        pathFillType = EvenOdd) {
                    moveTo(7.186f, 3.214f)
                    curveTo(6.105f, 3.214f, 5.229f, 4.09f, 5.229f, 5.171f)
                    verticalLineTo(11.615f)
                    curveTo(5.229f, 12.06f, 4.868f, 12.421f, 4.423f, 12.421f)
                    curveTo(3.977f, 12.421f, 3.616f, 12.06f, 3.616f, 11.615f)
                    verticalLineTo(5.171f)
                    curveTo(3.616f, 3.2f, 5.215f, 1.602f, 7.186f, 1.602f)
                    horizontalLineTo(13.866f)
                    curveTo(15.837f, 1.602f, 17.436f, 3.2f, 17.436f, 5.171f)
                    verticalLineTo(11.615f)
                    curveTo(17.436f, 12.06f, 17.075f, 12.421f, 16.629f, 12.421f)
                    curveTo(16.184f, 12.421f, 15.823f, 12.06f, 15.823f, 11.615f)
                    verticalLineTo(5.171f)
                    curveTo(15.823f, 4.09f, 14.947f, 3.214f, 13.866f, 3.214f)
                    horizontalLineTo(7.186f)
                    close()
                }
                path(fill = SolidColor(Color(0xFF4A47FF)), stroke = null, strokeLineWidth = 0.0f,
                        strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                        pathFillType = EvenOdd) {
                    moveTo(3.053f, 9.374f)
                    curveTo(1.966f, 9.374f, 1.084f, 10.256f, 1.084f, 11.343f)
                    verticalLineTo(14.669f)
                    verticalLineTo(20.304f)
                    verticalLineTo(20.916f)
                    curveTo(1.084f, 21.215f, 1.15f, 21.497f, 1.269f, 21.75f)
                    curveTo(1.432f, 22.098f, 1.67f, 22.407f, 1.905f, 22.711f)
                    curveTo(2.625f, 23.642f, 3.753f, 24.242f, 5.022f, 24.242f)
                    horizontalLineTo(16.031f)
                    curveTo(18.206f, 24.242f, 19.969f, 22.479f, 19.969f, 20.304f)
                    verticalLineTo(14.669f)
                    curveTo(19.969f, 12.494f, 18.206f, 10.731f, 16.031f, 10.731f)
                    horizontalLineTo(13.879f)
                    curveTo(12.405f, 10.731f, 11.01f, 9.374f, 9.536f, 9.374f)
                    verticalLineTo(9.374f)
                    horizontalLineTo(3.053f)
                    close()
                }
                path(fill = SolidColor(Color(0xFF0400CC)), stroke = null, strokeLineWidth = 0.0f,
                        strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                        pathFillType = NonZero) {
                    moveTo(15.025f, 10.737f)
                    horizontalLineToRelative(3.211f)
                    verticalLineToRelative(7.704f)
                    horizontalLineToRelative(-3.211f)
                    close()
                }
            }
        }
        .build()
        return _logo!!
    }

private var _logo: ImageVector? = null
