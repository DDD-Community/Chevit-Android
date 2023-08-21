package com.dkin.chevit.presentation.home.icon

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

public val HomeIcons.Notification: ImageVector
    get() {
        if (_notification != null) {
            return _notification!!
        }
        _notification = Builder(
            name = "Notification", defaultWidth = 20.0.dp,
            defaultHeight =
            20.0.dp,
            viewportWidth = 20.0f, viewportHeight = 20.0f,
        ).apply {
            path(
                fill = SolidColor(Color(0xFF171717)), stroke = null, strokeLineWidth = 0.0f,
                strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                pathFillType = NonZero,
            ) {
                moveTo(15.0001f, 8.3337f)
                curveTo(15.0001f, 7.0076f, 14.4733f, 5.7358f, 13.5356f, 4.7981f)
                curveTo(12.5979f, 3.8604f, 11.3262f, 3.3337f, 10.0001f, 3.3337f)
                curveTo(8.674f, 3.3337f, 7.4022f, 3.8604f, 6.4646f, 4.7981f)
                curveTo(5.5269f, 5.7358f, 5.0001f, 7.0076f, 5.0001f, 8.3337f)
                verticalLineTo(15.0003f)
                horizontalLineTo(15.0001f)
                verticalLineTo(8.3337f)
                close()
                moveTo(16.6667f, 15.5562f)
                lineTo(17.0001f, 16.0003f)
                curveTo(17.0465f, 16.0622f, 17.0748f, 16.1358f, 17.0817f, 16.2129f)
                curveTo(17.0887f, 16.29f, 17.074f, 16.3675f, 17.0394f, 16.4367f)
                curveTo(17.0048f, 16.5059f, 16.9516f, 16.5641f, 16.8858f, 16.6048f)
                curveTo(16.82f, 16.6454f, 16.7441f, 16.667f, 16.6667f, 16.667f)
                horizontalLineTo(3.3334f)
                curveTo(3.256f, 16.667f, 3.1802f, 16.6454f, 3.1144f, 16.6048f)
                curveTo(3.0485f, 16.5641f, 2.9953f, 16.5059f, 2.9607f, 16.4367f)
                curveTo(2.9261f, 16.3675f, 2.9115f, 16.29f, 2.9184f, 16.2129f)
                curveTo(2.9254f, 16.1358f, 2.9536f, 16.0622f, 3.0001f, 16.0003f)
                lineTo(3.3334f, 15.5562f)
                verticalLineTo(8.3337f)
                curveTo(3.3334f, 6.5655f, 4.0358f, 4.8699f, 5.286f, 3.6196f)
                curveTo(6.5363f, 2.3694f, 8.232f, 1.667f, 10.0001f, 1.667f)
                curveTo(11.7682f, 1.667f, 13.4639f, 2.3694f, 14.7141f, 3.6196f)
                curveTo(15.9644f, 4.8699f, 16.6667f, 6.5655f, 16.6667f, 8.3337f)
                verticalLineTo(15.5562f)
                close()
                moveTo(7.9167f, 17.5003f)
                horizontalLineTo(12.0834f)
                curveTo(12.0834f, 18.0529f, 11.8639f, 18.5828f, 11.4732f, 18.9735f)
                curveTo(11.0825f, 19.3642f, 10.5526f, 19.5837f, 10.0001f, 19.5837f)
                curveTo(9.4475f, 19.5837f, 8.9176f, 19.3642f, 8.5269f, 18.9735f)
                curveTo(8.1362f, 18.5828f, 7.9167f, 18.0529f, 7.9167f, 17.5003f)
                verticalLineTo(17.5003f)
                close()
            }
        }
            .build()
        return _notification!!
    }

private var _notification: ImageVector? = null
