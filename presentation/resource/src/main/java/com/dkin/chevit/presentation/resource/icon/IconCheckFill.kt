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

public val ChevitIcon.IconCheckFill: ImageVector
    get() {
        if (_iconCheckFill != null) {
            return _iconCheckFill!!
        }
        _iconCheckFill = Builder(
            name = "IconCheckFill", defaultWidth = 25.0.dp, defaultHeight =
            24.0.dp, viewportWidth = 25.0f, viewportHeight = 24.0f
        ).apply {
            path(
                fill = SolidColor(Color(0xFFffffff)), stroke = null, strokeLineWidth = 0.0f,
                strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                pathFillType = NonZero
            ) {
                moveTo(10.1247f, 15.172f)
                lineTo(19.3167f, 5.979f)
                lineTo(20.7317f, 7.393f)
                lineTo(10.1247f, 18.0f)
                lineTo(3.7607f, 11.636f)
                lineTo(5.1747f, 10.222f)
                lineTo(10.1247f, 15.172f)
                close()
            }
        }
            .build()
        return _iconCheckFill!!
    }

private var _iconCheckFill: ImageVector? = null
