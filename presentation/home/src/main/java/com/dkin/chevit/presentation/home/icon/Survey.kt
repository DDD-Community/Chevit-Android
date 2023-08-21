package com.dkin.chevit.presentation.home.icon

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

public val HomeIcons.Survey: ImageVector
    get() {
        if (_survey != null) {
            return _survey!!
        }
        _survey = Builder(
            name = "Survey", defaultWidth = 25.0.dp, defaultHeight = 24.0.dp,
            viewportWidth = 25.0f, viewportHeight = 24.0f,
        ).apply {
            group {
                path(
                    fill = SolidColor(Color(0xFFA2A2A2)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero,
                ) {
                    moveTo(17.5f, 2.0f)
                    verticalLineTo(4.0f)
                    horizontalLineTo(20.507f)
                    curveTo(21.055f, 4.0f, 21.5f, 4.445f, 21.5f, 4.993f)
                    verticalLineTo(21.007f)
                    curveTo(21.5f, 21.555f, 21.055f, 22.0f, 20.507f, 22.0f)
                    horizontalLineTo(4.493f)
                    curveTo(3.945f, 22.0f, 3.5f, 21.555f, 3.5f, 21.007f)
                    verticalLineTo(4.993f)
                    curveTo(3.5f, 4.445f, 3.945f, 4.0f, 4.493f, 4.0f)
                    horizontalLineTo(7.5f)
                    verticalLineTo(2.0f)
                    horizontalLineTo(17.5f)
                    close()
                    moveTo(7.5f, 6.0f)
                    horizontalLineTo(5.5f)
                    verticalLineTo(20.0f)
                    horizontalLineTo(19.5f)
                    verticalLineTo(6.0f)
                    horizontalLineTo(17.5f)
                    verticalLineTo(8.0f)
                    horizontalLineTo(7.5f)
                    verticalLineTo(6.0f)
                    close()
                    moveTo(9.5f, 16.0f)
                    verticalLineTo(18.0f)
                    horizontalLineTo(7.5f)
                    verticalLineTo(16.0f)
                    horizontalLineTo(9.5f)
                    close()
                    moveTo(9.5f, 13.0f)
                    verticalLineTo(15.0f)
                    horizontalLineTo(7.5f)
                    verticalLineTo(13.0f)
                    horizontalLineTo(9.5f)
                    close()
                    moveTo(9.5f, 10.0f)
                    verticalLineTo(12.0f)
                    horizontalLineTo(7.5f)
                    verticalLineTo(10.0f)
                    horizontalLineTo(9.5f)
                    close()
                    moveTo(15.5f, 4.0f)
                    horizontalLineTo(9.5f)
                    verticalLineTo(6.0f)
                    horizontalLineTo(15.5f)
                    verticalLineTo(4.0f)
                    close()
                }
            }
        }
            .build()
        return _survey!!
    }

private var _survey: ImageVector? = null
