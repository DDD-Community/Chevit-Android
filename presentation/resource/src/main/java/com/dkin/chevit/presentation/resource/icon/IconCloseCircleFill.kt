package com.dkin.chevit.presentation.resource.icon

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

public val ChevitIcon.IconCloseCircleFill: ImageVector
    get() {
        if (_iconCloseCircleFill != null) {
            return _iconCloseCircleFill!!
        }
        _iconCloseCircleFill = Builder(name = "IconCloseCircleFill", defaultWidth = 21.0.dp,
                defaultHeight = 20.0.dp, viewportWidth = 21.0f, viewportHeight = 20.0f).apply {
            path(fill = SolidColor(Color(0xFFA2A2A2)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(10.5001f, 18.3337f)
                curveTo(5.8976f, 18.3337f, 2.1667f, 14.6028f, 2.1667f, 10.0003f)
                curveTo(2.1667f, 5.3978f, 5.8976f, 1.667f, 10.5001f, 1.667f)
                curveTo(15.1026f, 1.667f, 18.8334f, 5.3978f, 18.8334f, 10.0003f)
                curveTo(18.8334f, 14.6028f, 15.1026f, 18.3337f, 10.5001f, 18.3337f)
                close()
                moveTo(10.5001f, 8.822f)
                lineTo(8.1434f, 6.4645f)
                lineTo(6.9643f, 7.6437f)
                lineTo(9.3217f, 10.0003f)
                lineTo(6.9643f, 12.357f)
                lineTo(8.1434f, 13.5362f)
                lineTo(10.5001f, 11.1787f)
                lineTo(12.8567f, 13.5362f)
                lineTo(14.0359f, 12.357f)
                lineTo(11.6784f, 10.0003f)
                lineTo(14.0359f, 7.6437f)
                lineTo(12.8567f, 6.4645f)
                lineTo(10.5001f, 8.822f)
                close()
            }
        }
        .build()
        return _iconCloseCircleFill!!
    }

private var _iconCloseCircleFill: ImageVector? = null
