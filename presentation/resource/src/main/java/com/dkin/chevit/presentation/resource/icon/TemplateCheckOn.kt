package com.dkin.chevit.presentation.resource.icon

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeCap.Companion.Round
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

public val ChevitIcon.TemplateCheckOn: ImageVector
    get() {
        if (_templateCheckOn != null) {
            return _templateCheckOn!!
        }
        _templateCheckOn = Builder(name = "TemplateCheckOn", defaultWidth = 13.0.dp, defaultHeight =
                12.0.dp, viewportWidth = 13.0f, viewportHeight = 12.0f).apply {
            path(fill = SolidColor(Color(0xFF3531FF)), stroke = SolidColor(Color(0xFF4A47FF)),
                    strokeLineWidth = 0.5f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(2.25f, 0.25f)
                lineTo(10.25f, 0.25f)
                arcTo(1.75f, 1.75f, 0.0f, false, true, 12.0f, 2.0f)
                lineTo(12.0f, 10.0f)
                arcTo(1.75f, 1.75f, 0.0f, false, true, 10.25f, 11.75f)
                lineTo(2.25f, 11.75f)
                arcTo(1.75f, 1.75f, 0.0f, false, true, 0.5f, 10.0f)
                lineTo(0.5f, 2.0f)
                arcTo(1.75f, 1.75f, 0.0f, false, true, 2.25f, 0.25f)
                close()
            }
            path(fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFFffffff)),
                    strokeLineWidth = 1.0f, strokeLineCap = Round, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(2.75f, 5.7549f)
                lineTo(4.8598f, 8.0895f)
                curveTo(5.0583f, 8.3092f, 5.4032f, 8.3092f, 5.6017f, 8.0896f)
                lineTo(9.75f, 3.5f)
            }
        }
        .build()
        return _templateCheckOn!!
    }

private var _templateCheckOn: ImageVector? = null
