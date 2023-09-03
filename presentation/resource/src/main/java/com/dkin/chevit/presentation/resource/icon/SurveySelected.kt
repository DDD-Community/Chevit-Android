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

public val ChevitIcon.SurveySelected: ImageVector
    get() {
        if (_surveySelected != null) {
            return _surveySelected!!
        }
        _surveySelected = Builder(
            name = "SurveySelected", defaultWidth = 25.0.dp,
            defaultHeight =
            24.0.dp,
            viewportWidth = 25.0f, viewportHeight = 24.0f,
        ).apply {
            path(
                fill = SolidColor(Color(0xFF171717)), stroke = null, strokeLineWidth = 0.0f,
                strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                pathFillType = NonZero,
            ) {
                moveTo(6.5f, 4.0f)
                verticalLineTo(8.0f)
                horizontalLineTo(18.5f)
                verticalLineTo(4.0f)
                horizontalLineTo(20.507f)
                curveTo(21.055f, 4.0f, 21.5f, 4.445f, 21.5f, 4.993f)
                verticalLineTo(21.007f)
                curveTo(21.5f, 21.555f, 21.055f, 22.0f, 20.507f, 22.0f)
                horizontalLineTo(4.493f)
                curveTo(3.945f, 22.0f, 3.5f, 21.555f, 3.5f, 21.007f)
                verticalLineTo(4.993f)
                curveTo(3.5f, 4.445f, 3.945f, 4.0f, 4.493f, 4.0f)
                horizontalLineTo(6.5f)
                close()
                moveTo(9.5f, 17.0f)
                horizontalLineTo(7.5f)
                verticalLineTo(19.0f)
                horizontalLineTo(9.5f)
                verticalLineTo(17.0f)
                close()
                moveTo(9.5f, 14.0f)
                horizontalLineTo(7.5f)
                verticalLineTo(16.0f)
                horizontalLineTo(9.5f)
                verticalLineTo(14.0f)
                close()
                moveTo(9.5f, 11.0f)
                horizontalLineTo(7.5f)
                verticalLineTo(13.0f)
                horizontalLineTo(9.5f)
                verticalLineTo(11.0f)
                close()
                moveTo(16.5f, 2.0f)
                verticalLineTo(6.0f)
                horizontalLineTo(8.5f)
                verticalLineTo(2.0f)
                horizontalLineTo(16.5f)
                close()
            }
        }
            .build()
        return _surveySelected!!
    }

private var _surveySelected: ImageVector? = null
