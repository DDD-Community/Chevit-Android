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

public val ChevitIcon.IconCheckboxCheckedGrey: ImageVector
    get() {
        if (_iconCheckboxCheckedGrey != null) {
            return _iconCheckboxCheckedGrey!!
        }
        _iconCheckboxCheckedGrey = Builder(name = "IconCheckboxCheckedGrey", defaultWidth = 24.0.dp,
                defaultHeight = 25.0.dp, viewportWidth = 24.0f, viewportHeight = 25.0f).apply {
            path(fill = SolidColor(Color(0xFFD1D1D1)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = EvenOdd) {
                moveTo(12.0f, 0.4678f)
                curveTo(5.3726f, 0.4678f, 0.0f, 5.8404f, 0.0f, 12.4678f)
                curveTo(0.0f, 19.0952f, 5.3726f, 24.4678f, 12.0f, 24.4678f)
                curveTo(18.6274f, 24.4678f, 24.0f, 19.0952f, 24.0f, 12.4678f)
                curveTo(24.0f, 5.8404f, 18.6274f, 0.4678f, 12.0f, 0.4678f)
                close()
                moveTo(9.2932f, 16.5082f)
                curveTo(9.4807f, 16.6957f, 9.7351f, 16.8011f, 10.0003f, 16.8011f)
                curveTo(10.2655f, 16.8011f, 10.5199f, 16.6957f, 10.7074f, 16.5082f)
                lineTo(17.3741f, 9.8415f)
                curveTo(17.7646f, 9.451f, 17.7646f, 8.8179f, 17.3741f, 8.4273f)
                curveTo(16.9836f, 8.0368f, 16.3504f, 8.0368f, 15.9599f, 8.4273f)
                lineTo(10.0003f, 14.3869f)
                lineTo(8.0408f, 12.4273f)
                curveTo(7.6502f, 12.0368f, 7.0171f, 12.0368f, 6.6266f, 12.4273f)
                curveTo(6.236f, 12.8179f, 6.236f, 13.451f, 6.6266f, 13.8415f)
                lineTo(9.2932f, 16.5082f)
                close()
            }
        }
        .build()
        return _iconCheckboxCheckedGrey!!
    }

private var _iconCheckboxCheckedGrey: ImageVector? = null
