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

public val ChevitIcon.IconAddFill: ImageVector
    get() {
        if (_iconAddFill != null) {
            return _iconAddFill!!
        }
        _iconAddFill = Builder(name = "IconAddFill", defaultWidth = 30.0.dp, defaultHeight =
                31.0.dp, viewportWidth = 30.0f, viewportHeight = 31.0f).apply {
            path(fill = SolidColor(Color(0xFFffffff)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(13.75f, 14.7178f)
                verticalLineTo(7.2178f)
                horizontalLineTo(16.25f)
                verticalLineTo(14.7178f)
                horizontalLineTo(23.75f)
                verticalLineTo(17.2178f)
                horizontalLineTo(16.25f)
                verticalLineTo(24.7178f)
                horizontalLineTo(13.75f)
                verticalLineTo(17.2178f)
                horizontalLineTo(6.25f)
                verticalLineTo(14.7178f)
                horizontalLineTo(13.75f)
                close()
            }
        }
        .build()
        return _iconAddFill!!
    }

private var _iconAddFill: ImageVector? = null
