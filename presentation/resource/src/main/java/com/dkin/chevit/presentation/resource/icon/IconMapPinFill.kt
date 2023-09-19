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

public val ChevitIcon.IconMapPinFill: ImageVector
    get() {
        if (_iconMapPinFill != null) {
            return _iconMapPinFill!!
        }
        _iconMapPinFill = Builder(name = "IconMapPinFill", defaultWidth = 21.0.dp,
                defaultHeight = 20.0.dp, viewportWidth = 21.0f, viewportHeight = 20.0f).apply {
            group {
                path(fill = SolidColor(Color(0xFF171717)), stroke = null, strokeLineWidth = 0.0f,
                        strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                        pathFillType = NonZero) {
                    moveTo(15.8033f, 14.4703f)
                    lineTo(10.5f, 19.7736f)
                    lineTo(5.1967f, 14.4703f)
                    curveTo(4.1478f, 13.4214f, 3.4335f, 12.085f, 3.1441f, 10.6301f)
                    curveTo(2.8547f, 9.1753f, 3.0033f, 7.6673f, 3.5709f, 6.2969f)
                    curveTo(4.1386f, 4.9264f, 5.0999f, 3.7551f, 6.3332f, 2.931f)
                    curveTo(7.5666f, 2.1069f, 9.0167f, 1.667f, 10.5f, 1.667f)
                    curveTo(11.9834f, 1.667f, 13.4334f, 2.1069f, 14.6668f, 2.931f)
                    curveTo(15.9001f, 3.7551f, 16.8614f, 4.9264f, 17.4291f, 6.2969f)
                    curveTo(17.9968f, 7.6673f, 18.1453f, 9.1753f, 17.8559f, 10.6301f)
                    curveTo(17.5665f, 12.085f, 16.8522f, 13.4214f, 15.8033f, 14.4703f)
                    close()
                    moveTo(10.5f, 12.5003f)
                    curveTo(11.3841f, 12.5003f, 12.2319f, 12.1491f, 12.857f, 11.524f)
                    curveTo(13.4821f, 10.8988f, 13.8333f, 10.051f, 13.8333f, 9.1669f)
                    curveTo(13.8333f, 8.2829f, 13.4821f, 7.435f, 12.857f, 6.8099f)
                    curveTo(12.2319f, 6.1848f, 11.3841f, 5.8336f, 10.5f, 5.8336f)
                    curveTo(9.6159f, 5.8336f, 8.7681f, 6.1848f, 8.143f, 6.8099f)
                    curveTo(7.5179f, 7.435f, 7.1667f, 8.2829f, 7.1667f, 9.1669f)
                    curveTo(7.1667f, 10.051f, 7.5179f, 10.8988f, 8.143f, 11.524f)
                    curveTo(8.7681f, 12.1491f, 9.6159f, 12.5003f, 10.5f, 12.5003f)
                    close()
                    moveTo(10.5f, 10.8336f)
                    curveTo(10.058f, 10.8336f, 9.6341f, 10.658f, 9.3215f, 10.3454f)
                    curveTo(9.0089f, 10.0329f, 8.8333f, 9.609f, 8.8333f, 9.1669f)
                    curveTo(8.8333f, 8.7249f, 9.0089f, 8.301f, 9.3215f, 7.9884f)
                    curveTo(9.6341f, 7.6759f, 10.058f, 7.5003f, 10.5f, 7.5003f)
                    curveTo(10.942f, 7.5003f, 11.366f, 7.6759f, 11.6785f, 7.9884f)
                    curveTo(11.9911f, 8.301f, 12.1667f, 8.7249f, 12.1667f, 9.1669f)
                    curveTo(12.1667f, 9.609f, 11.9911f, 10.0329f, 11.6785f, 10.3454f)
                    curveTo(11.366f, 10.658f, 10.942f, 10.8336f, 10.5f, 10.8336f)
                    close()
                }
            }
        }
        .build()
        return _iconMapPinFill!!
    }

private var _iconMapPinFill: ImageVector? = null
