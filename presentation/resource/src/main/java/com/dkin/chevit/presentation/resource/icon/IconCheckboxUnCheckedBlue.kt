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

public val ChevitIcon.IconCheckboxUnCheckedBlue: ImageVector
    get() {
        if (_iconCheckboxUnCheckedBlue != null) {
            return _iconCheckboxUnCheckedBlue!!
        }
        _iconCheckboxUnCheckedBlue = Builder(name = "Iconcheckboxuncheckedblue", defaultWidth =
                24.0.dp, defaultHeight = 25.0.dp, viewportWidth = 24.0f, viewportHeight =
                25.0f).apply {
            path(fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFF4A47FF)),
                    strokeLineWidth = 2.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(12.0f, 1.4678f)
                lineTo(12.0f, 1.4678f)
                arcTo(11.0f, 11.0f, 0.0f, false, true, 23.0f, 12.4678f)
                lineTo(23.0f, 12.4678f)
                arcTo(11.0f, 11.0f, 0.0f, false, true, 12.0f, 23.4678f)
                lineTo(12.0f, 23.4678f)
                arcTo(11.0f, 11.0f, 0.0f, false, true, 1.0f, 12.4678f)
                lineTo(1.0f, 12.4678f)
                arcTo(11.0f, 11.0f, 0.0f, false, true, 12.0f, 1.4678f)
                close()
            }
        }
        .build()
        return _iconCheckboxUnCheckedBlue!!
    }

private var _iconCheckboxUnCheckedBlue: ImageVector? = null
