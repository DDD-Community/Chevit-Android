package com.dkin.chevit.presentation.resource.icon

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

public val ChevitIcon.IconArrowDownLine: ImageVector
    get() {
        if (_iconArrowDownLine != null) {
            return _iconArrowDownLine!!
        }
        _iconArrowDownLine = Builder(name = "IconArrowDownLine", defaultWidth = 25.0.dp,
                defaultHeight = 24.0.dp, viewportWidth = 25.0f, viewportHeight = 24.0f).apply {
            group {
                path(fill = SolidColor(Color(0xFF171717)), stroke = null, strokeLineWidth = 0.0f,
                        strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                        pathFillType = NonZero) {
                    moveTo(12.2502f, 13.1722f)
                    lineTo(17.2002f, 8.2222f)
                    lineTo(18.6142f, 9.6362f)
                    lineTo(12.2502f, 16.0002f)
                    lineTo(5.8862f, 9.6362f)
                    lineTo(7.3002f, 8.2222f)
                    lineTo(12.2502f, 13.1722f)
                    close()
                }
            }
        }
        .build()
        return _iconArrowDownLine!!
    }

private var _iconArrowDownLine: ImageVector? = null
