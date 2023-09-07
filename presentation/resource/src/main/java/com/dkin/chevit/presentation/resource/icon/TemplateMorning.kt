package com.dkin.chevit.presentation.resource.icon

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.EvenOdd
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

public val ChevitIcon.TemplateMorning: ImageVector
    get() {
        if (_templateMorning != null) {
            return _templateMorning!!
        }
        _templateMorning = Builder(name = "TemplateMorning", defaultWidth = 88.0.dp, defaultHeight =
                66.0.dp, viewportWidth = 88.0f, viewportHeight = 66.0f).apply {
            group {
                path(fill = SolidColor(Color(0xFF5986FB)), stroke = null, strokeLineWidth = 0.0f,
                        strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                        pathFillType = EvenOdd) {
                    moveTo(18.375f, 11.4463f)
                    curveTo(11.1953f, 11.4463f, 5.375f, 17.2666f, 5.375f, 24.4463f)
                    verticalLineTo(47.0458f)
                    curveTo(5.375f, 54.2255f, 11.1953f, 60.0458f, 18.375f, 60.0458f)
                    horizontalLineTo(35.4387f)
                    curveTo(38.9322f, 60.0458f, 42.1038f, 58.6678f, 44.4397f, 56.4257f)
                    curveTo(46.7756f, 58.6677f, 49.9472f, 60.0457f, 53.4406f, 60.0457f)
                    horizontalLineTo(70.5043f)
                    curveTo(77.684f, 60.0457f, 83.5043f, 54.2254f, 83.5043f, 47.0457f)
                    verticalLineTo(34.2891f)
                    curveTo(83.5043f, 27.1094f, 77.684f, 21.2891f, 70.5043f, 21.2891f)
                    horizontalLineTo(53.4406f)
                    curveTo(51.6037f, 21.2891f, 49.8559f, 21.67f, 48.2717f, 22.3572f)
                    curveTo(47.2724f, 16.1707f, 41.9073f, 11.4463f, 35.4387f, 11.4463f)
                    horizontalLineTo(18.375f)
                    close()
                }
                path(fill = SolidColor(Color(0xFF72A0FE)), stroke = null, strokeLineWidth = 0.0f,
                        strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                        pathFillType = NonZero) {
                    moveTo(70.5039f, 28.7705f)
                    horizontalLineTo(18.375f)
                    curveTo(11.1953f, 28.7705f, 5.375f, 34.5908f, 5.375f, 41.7705f)
                    verticalLineTo(71.3452f)
                    curveTo(5.375f, 78.5249f, 11.1953f, 84.3452f, 18.375f, 84.3452f)
                    horizontalLineTo(70.5039f)
                    curveTo(77.6836f, 84.3452f, 83.5039f, 78.5249f, 83.5039f, 71.3452f)
                    verticalLineTo(41.7705f)
                    curveTo(83.5039f, 34.5908f, 77.6836f, 28.7705f, 70.5039f, 28.7705f)
                    close()
                }
                path(fill = SolidColor(Color(0x00000000)), stroke = SolidColor(Color(0xFF72A0FE)),
                        strokeLineWidth = 7.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                        strokeLineMiter = 4.0f, pathFillType = NonZero) {
                    moveTo(22.793f, 36.1402f)
                    verticalLineTo(14.4463f)
                    curveTo(22.793f, 12.7894f, 24.1362f, 11.4463f, 25.793f, 11.4463f)
                    horizontalLineTo(62.6209f)
                    curveTo(64.2778f, 11.4463f, 65.6209f, 12.7894f, 65.6209f, 14.4463f)
                    verticalLineTo(36.1402f)
                }
            }
        }
        .build()
        return _templateMorning!!
    }

private var _templateMorning: ImageVector? = null
