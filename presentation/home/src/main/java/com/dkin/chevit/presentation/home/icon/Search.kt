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

public val HomeIcons.Search: ImageVector
    get() {
        if (_search != null) {
            return _search!!
        }
        _search = Builder(name = "Search", defaultWidth = 25.0.dp, defaultHeight = 24.0.dp,
                viewportWidth = 25.0f, viewportHeight = 24.0f).apply {
            group {
                path(fill = SolidColor(Color(0xFFA2A2A2)), stroke = null, strokeLineWidth = 0.0f,
                        strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                        pathFillType = NonZero) {
                    moveTo(16.4113f, 14.6842f)
                    lineTo(22.2814f, 20.5535f)
                    lineTo(21.0535f, 21.7814f)
                    lineTo(15.1842f, 15.9113f)
                    curveTo(13.8016f, 17.0196f, 12.0819f, 17.6224f, 10.31f, 17.6199f)
                    curveTo(5.9989f, 17.6199f, 2.5f, 14.121f, 2.5f, 9.8099f)
                    curveTo(2.5f, 5.4989f, 5.9989f, 2.0f, 10.31f, 2.0f)
                    curveTo(14.621f, 2.0f, 18.1199f, 5.4989f, 18.1199f, 9.8099f)
                    curveTo(18.1224f, 11.5819f, 17.5196f, 13.3016f, 16.4113f, 14.6842f)
                    close()
                    moveTo(14.6705f, 14.0403f)
                    curveTo(15.7718f, 12.9078f, 16.3868f, 11.3897f, 16.3844f, 9.8099f)
                    curveTo(16.3844f, 6.4534f, 13.6656f, 3.7355f, 10.31f, 3.7355f)
                    curveTo(6.9534f, 3.7355f, 4.2355f, 6.4534f, 4.2355f, 9.8099f)
                    curveTo(4.2355f, 13.1656f, 6.9534f, 15.8844f, 10.31f, 15.8844f)
                    curveTo(11.8897f, 15.8868f, 13.4078f, 15.2718f, 14.5403f, 14.1705f)
                    lineTo(14.6705f, 14.0403f)
                    close()
                }
            }
        }
        .build()
        return _search!!
    }

private var _search: ImageVector? = null
