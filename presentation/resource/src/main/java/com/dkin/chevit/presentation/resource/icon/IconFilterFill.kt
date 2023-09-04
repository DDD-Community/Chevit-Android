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

public val ChevitIcon.IconFilterFill: ImageVector
    get() {
        if (_iconFilterFill != null) {
            return _iconFilterFill!!
        }
        _iconFilterFill = Builder(name = "IconFilterFill", defaultWidth = 24.0.dp, defaultHeight =
                25.0.dp, viewportWidth = 24.0f, viewportHeight = 25.0f).apply {
            path(fill = SolidColor(Color(0xFF171717)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(17.0f, 5.125f)
                horizontalLineTo(19.5f)
                verticalLineTo(6.7917f)
                lineTo(17.0f, 6.7917f)
                verticalLineTo(8.4583f)
                horizontalLineTo(15.3333f)
                verticalLineTo(3.4583f)
                lineTo(17.0f, 3.4583f)
                verticalLineTo(5.125f)
                close()
                moveTo(17.0f, 18.4583f)
                horizontalLineTo(19.5f)
                verticalLineTo(20.125f)
                horizontalLineTo(17.0f)
                lineTo(17.0f, 21.7917f)
                horizontalLineTo(15.3333f)
                lineTo(15.3333f, 16.7917f)
                horizontalLineTo(17.0f)
                verticalLineTo(18.4583f)
                close()
                moveTo(7.0f, 13.4583f)
                horizontalLineTo(4.5f)
                verticalLineTo(11.7917f)
                horizontalLineTo(7.0f)
                verticalLineTo(10.125f)
                horizontalLineTo(8.6667f)
                lineTo(8.6667f, 15.125f)
                horizontalLineTo(7.0f)
                verticalLineTo(13.4583f)
                close()
                moveTo(10.3333f, 13.4583f)
                verticalLineTo(11.7917f)
                lineTo(19.5f, 11.7917f)
                verticalLineTo(13.4583f)
                lineTo(10.3333f, 13.4583f)
                close()
                moveTo(13.6667f, 20.125f)
                horizontalLineTo(4.5f)
                lineTo(4.5f, 18.4583f)
                horizontalLineTo(13.6667f)
                verticalLineTo(20.125f)
                close()
                moveTo(13.6667f, 6.7917f)
                lineTo(4.5f, 6.7917f)
                verticalLineTo(5.125f)
                lineTo(13.6667f, 5.125f)
                verticalLineTo(6.7917f)
                close()
            }
        }
        .build()
        return _iconFilterFill!!
    }

private var _iconFilterFill: ImageVector? = null
