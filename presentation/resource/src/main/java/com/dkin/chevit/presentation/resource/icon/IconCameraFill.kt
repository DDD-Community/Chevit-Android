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

public val ChevitIcon.IconCameraFill: ImageVector
    get() {
        if (_iconCameraFill != null) {
            return _iconCameraFill!!
        }
        _iconCameraFill = Builder(name = "IconCameraFill", defaultWidth = 25.0.dp, defaultHeight =
                25.0.dp, viewportWidth = 25.0f, viewportHeight = 25.0f).apply {
            group {
                path(fill = SolidColor(Color(0xFFffffff)), stroke = null, strokeLineWidth = 0.0f,
                        strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                        pathFillType = NonZero) {
                    moveTo(9.9648f, 3.4558f)
                    horizontalLineTo(15.9648f)
                    lineTo(17.9648f, 5.4558f)
                    horizontalLineTo(21.9648f)
                    curveTo(22.2301f, 5.4558f, 22.4844f, 5.5612f, 22.672f, 5.7487f)
                    curveTo(22.8595f, 5.9362f, 22.9648f, 6.1906f, 22.9648f, 6.4558f)
                    verticalLineTo(20.4558f)
                    curveTo(22.9648f, 20.721f, 22.8595f, 20.9754f, 22.672f, 21.1629f)
                    curveTo(22.4844f, 21.3505f, 22.2301f, 21.4558f, 21.9648f, 21.4558f)
                    horizontalLineTo(3.9648f)
                    curveTo(3.6996f, 21.4558f, 3.4453f, 21.3505f, 3.2577f, 21.1629f)
                    curveTo(3.0702f, 20.9754f, 2.9648f, 20.721f, 2.9648f, 20.4558f)
                    verticalLineTo(6.4558f)
                    curveTo(2.9648f, 6.1906f, 3.0702f, 5.9362f, 3.2577f, 5.7487f)
                    curveTo(3.4453f, 5.5612f, 3.6996f, 5.4558f, 3.9648f, 5.4558f)
                    horizontalLineTo(7.9648f)
                    lineTo(9.9648f, 3.4558f)
                    close()
                    moveTo(12.9648f, 19.4558f)
                    curveTo(14.5561f, 19.4558f, 16.0823f, 18.8237f, 17.2075f, 17.6985f)
                    curveTo(18.3327f, 16.5732f, 18.9648f, 15.0471f, 18.9648f, 13.4558f)
                    curveTo(18.9648f, 11.8645f, 18.3327f, 10.3384f, 17.2075f, 9.2132f)
                    curveTo(16.0823f, 8.0879f, 14.5561f, 7.4558f, 12.9648f, 7.4558f)
                    curveTo(11.3735f, 7.4558f, 9.8474f, 8.0879f, 8.7222f, 9.2132f)
                    curveTo(7.597f, 10.3384f, 6.9648f, 11.8645f, 6.9648f, 13.4558f)
                    curveTo(6.9648f, 15.0471f, 7.597f, 16.5732f, 8.7222f, 17.6985f)
                    curveTo(9.8474f, 18.8237f, 11.3735f, 19.4558f, 12.9648f, 19.4558f)
                    close()
                    moveTo(12.9648f, 17.4558f)
                    curveTo(11.904f, 17.4558f, 10.8866f, 17.0344f, 10.1364f, 16.2842f)
                    curveTo(9.3863f, 15.5341f, 8.9648f, 14.5167f, 8.9648f, 13.4558f)
                    curveTo(8.9648f, 12.3949f, 9.3863f, 11.3775f, 10.1364f, 10.6274f)
                    curveTo(10.8866f, 9.8772f, 11.904f, 9.4558f, 12.9648f, 9.4558f)
                    curveTo(14.0257f, 9.4558f, 15.0431f, 9.8772f, 15.7933f, 10.6274f)
                    curveTo(16.5434f, 11.3775f, 16.9648f, 12.3949f, 16.9648f, 13.4558f)
                    curveTo(16.9648f, 14.5167f, 16.5434f, 15.5341f, 15.7933f, 16.2842f)
                    curveTo(15.0431f, 17.0344f, 14.0257f, 17.4558f, 12.9648f, 17.4558f)
                    close()
                }
            }
        }
        .build()
        return _iconCameraFill!!
    }

private var _iconCameraFill: ImageVector? = null
