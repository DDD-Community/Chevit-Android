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

public val HomeIcons.UserSelected: ImageVector
    get() {
        if (_userSelected != null) {
            return _userSelected!!
        }
        _userSelected = Builder(
            name = "UserSelected", defaultWidth = 25.0.dp,
            defaultHeight =
            24.0.dp,
            viewportWidth = 25.0f, viewportHeight = 24.0f,
        ).apply {
            path(
                fill = SolidColor(Color(0xFF171717)), stroke = null, strokeLineWidth = 0.0f,
                strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                pathFillType = NonZero,
            ) {
                moveTo(20.5f, 22.0f)
                horizontalLineTo(4.5f)
                verticalLineTo(20.0f)
                curveTo(4.5f, 18.6739f, 5.0268f, 17.4021f, 5.9645f, 16.4645f)
                curveTo(6.9022f, 15.5268f, 8.1739f, 15.0f, 9.5f, 15.0f)
                horizontalLineTo(15.5f)
                curveTo(16.8261f, 15.0f, 18.0979f, 15.5268f, 19.0355f, 16.4645f)
                curveTo(19.9732f, 17.4021f, 20.5f, 18.6739f, 20.5f, 20.0f)
                verticalLineTo(22.0f)
                close()
                moveTo(12.5f, 13.0f)
                curveTo(11.7121f, 13.0f, 10.9319f, 12.8448f, 10.2039f, 12.5433f)
                curveTo(9.476f, 12.2417f, 8.8145f, 11.7998f, 8.2574f, 11.2426f)
                curveTo(7.7002f, 10.6855f, 7.2583f, 10.0241f, 6.9567f, 9.2961f)
                curveTo(6.6552f, 8.5681f, 6.5f, 7.7879f, 6.5f, 7.0f)
                curveTo(6.5f, 6.2121f, 6.6552f, 5.4318f, 6.9567f, 4.7039f)
                curveTo(7.2583f, 3.976f, 7.7002f, 3.3145f, 8.2574f, 2.7574f)
                curveTo(8.8145f, 2.2002f, 9.476f, 1.7582f, 10.2039f, 1.4567f)
                curveTo(10.9319f, 1.1552f, 11.7121f, 1.0f, 12.5f, 1.0f)
                curveTo(14.0913f, 1.0f, 15.6174f, 1.6321f, 16.7426f, 2.7574f)
                curveTo(17.8679f, 3.8826f, 18.5f, 5.4087f, 18.5f, 7.0f)
                curveTo(18.5f, 8.5913f, 17.8679f, 10.1174f, 16.7426f, 11.2426f)
                curveTo(15.6174f, 12.3679f, 14.0913f, 13.0f, 12.5f, 13.0f)
                close()
            }
        }
            .build()
        return _userSelected!!
    }

private var _userSelected: ImageVector? = null
