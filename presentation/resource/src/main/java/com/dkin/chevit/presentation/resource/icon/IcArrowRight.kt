package com.dkin.chevit.presentation.resource.icon

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.EvenOdd
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

public val ChevitIcon.IconArrowRight: ImageVector
    get() {
        if (_iconArrowRight != null) {
            return _iconArrowRight!!
        }
        _iconArrowRight = Builder(name = "IconArrowRight", defaultWidth = 7.0.dp, defaultHeight =
                10.0.dp, viewportWidth = 7.0f, viewportHeight = 10.0f).apply {
            path(fill = SolidColor(Color(0xFF171717)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = EvenOdd) {
                moveTo(0.9697f, 0.2357f)
                curveTo(1.2626f, -0.0572f, 1.7374f, -0.0572f, 2.0303f, 0.2357f)
                lineTo(6.0303f, 4.2357f)
                curveTo(6.3232f, 4.5286f, 6.3232f, 5.0034f, 6.0303f, 5.2963f)
                lineTo(2.0303f, 9.2963f)
                curveTo(1.7374f, 9.5892f, 1.2626f, 9.5892f, 0.9697f, 9.2963f)
                curveTo(0.6768f, 9.0034f, 0.6768f, 8.5286f, 0.9697f, 8.2357f)
                lineTo(4.4393f, 4.766f)
                lineTo(0.9697f, 1.2963f)
                curveTo(0.6768f, 1.0034f, 0.6768f, 0.5286f, 0.9697f, 0.2357f)
                close()
            }
        }
        .build()
        return _iconArrowRight!!
    }

private var _iconArrowRight: ImageVector? = null
