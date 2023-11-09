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

public val ChevitIcon.IconFolderReceivedFill: ImageVector
    get() {
        if (_iconFolderReceivedFill != null) {
            return _iconFolderReceivedFill!!
        }
        _iconFolderReceivedFill = Builder(name = "IconFolderReceivedFill", defaultWidth = 25.0.dp,
                defaultHeight = 25.0.dp, viewportWidth = 25.0f, viewportHeight = 25.0f).apply {
            group {
                path(fill = SolidColor(Color(0xFF171717)), stroke = null, strokeLineWidth = 0.0f,
                        strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                        pathFillType = NonZero) {
                    moveTo(22.5f, 13.876f)
                    curveTo(21.3858f, 13.0751f, 20.0306f, 12.6803f, 18.6606f, 12.7574f)
                    curveTo(17.2905f, 12.8346f, 15.9883f, 13.3791f, 14.971f, 14.3001f)
                    curveTo(13.9537f, 15.2211f, 13.2829f, 16.4629f, 13.0704f, 17.8186f)
                    curveTo(12.8578f, 19.1743f, 13.1164f, 20.5619f, 13.803f, 21.75f)
                    horizontalLineTo(3.5f)
                    curveTo(3.2348f, 21.75f, 2.9804f, 21.6446f, 2.7929f, 21.4571f)
                    curveTo(2.6054f, 21.2696f, 2.5f, 21.0152f, 2.5f, 20.75f)
                    verticalLineTo(4.75f)
                    curveTo(2.5f, 4.4848f, 2.6054f, 4.2304f, 2.7929f, 4.0429f)
                    curveTo(2.9804f, 3.8554f, 3.2348f, 3.75f, 3.5f, 3.75f)
                    horizontalLineTo(10.914f)
                    lineTo(12.914f, 5.75f)
                    horizontalLineTo(21.5f)
                    curveTo(21.7652f, 5.75f, 22.0196f, 5.8554f, 22.2071f, 6.0429f)
                    curveTo(22.3946f, 6.2304f, 22.5f, 6.4848f, 22.5f, 6.75f)
                    verticalLineTo(13.876f)
                    close()
                    moveTo(20.5f, 17.75f)
                    horizontalLineTo(23.5f)
                    verticalLineTo(19.75f)
                    horizontalLineTo(20.5f)
                    verticalLineTo(23.25f)
                    lineTo(15.5f, 18.75f)
                    lineTo(20.5f, 14.25f)
                    verticalLineTo(17.75f)
                    close()
                }
            }
        }
        .build()
        return _iconFolderReceivedFill!!
    }

private var _iconFolderReceivedFill: ImageVector? = null
