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

public val ChevitIcon.IconSearch: ImageVector
    get() {
        if (_iconSearch != null) {
            return _iconSearch!!
        }
        _iconSearch = Builder(name = "IconSearch", defaultWidth = 25.0.dp, defaultHeight = 24.0.dp,
                viewportWidth = 25.0f, viewportHeight = 24.0f).apply {
            path(fill = SolidColor(Color(0xFFA2A2A2)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = EvenOdd) {
                moveTo(14.8851f, 15.446f)
                curveTo(12.2349f, 17.5687f, 8.3554f, 17.4016f, 5.8987f, 14.9448f)
                curveTo(3.2626f, 12.3088f, 3.2626f, 8.0349f, 5.8987f, 5.3989f)
                curveTo(8.5347f, 2.7629f, 12.8086f, 2.7629f, 15.4446f, 5.3989f)
                curveTo(17.9014f, 7.8557f, 18.0685f, 11.7351f, 15.9458f, 14.3854f)
                lineTo(21.1014f, 19.541f)
                curveTo(21.3943f, 19.8339f, 21.3943f, 20.3088f, 21.1014f, 20.6017f)
                curveTo(20.8085f, 20.8946f, 20.3337f, 20.8946f, 20.0408f, 20.6017f)
                lineTo(14.8851f, 15.446f)
                close()
                moveTo(6.9593f, 13.8842f)
                curveTo(4.9091f, 11.8339f, 4.9091f, 8.5098f, 6.9593f, 6.4596f)
                curveTo(9.0096f, 4.4093f, 12.3337f, 4.4093f, 14.3839f, 6.4596f)
                curveTo(16.4327f, 8.5083f, 16.4342f, 11.8291f, 14.3885f, 13.8797f)
                curveTo(14.3869f, 13.8812f, 14.3854f, 13.8827f, 14.3839f, 13.8842f)
                curveTo(14.3824f, 13.8857f, 14.3809f, 13.8872f, 14.3794f, 13.8887f)
                curveTo(12.3288f, 15.9344f, 9.0081f, 15.9329f, 6.9593f, 13.8842f)
                close()
            }
        }
        .build()
        return _iconSearch!!
    }

private var _iconSearch: ImageVector? = null
