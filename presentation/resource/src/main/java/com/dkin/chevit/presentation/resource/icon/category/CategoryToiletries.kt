package com.dkin.chevit.presentation.resource.icon.category

import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.dkin.chevit.presentation.resource.icon.ChevitIcon

public val ChevitIcon.CategoryToiletries: ImageVector
    get() {
        if (_categoryToiletries != null) {
            return _categoryToiletries!!
        }
        _categoryToiletries = Builder(name = "CategoryToiletries", defaultWidth = 48.0.dp, defaultHeight = 48.0.dp,
                viewportWidth = 48.0f, viewportHeight = 48.0f).apply {
            path(fill = null, stroke = null, strokeLineWidth = 0.0f, strokeLineCap = Butt,
                    strokeLineJoin = Miter, strokeLineMiter = 4.0f, pathFillType = NonZero) {
                moveTo(0.0f, 0.0f)
                horizontalLineToRelative(48.0f)
                verticalLineToRelative(48.0f)
                horizontalLineToRelative(-48.0f)
                close()
            }
        }
        .build()
        return _categoryToiletries!!
    }

private var _categoryToiletries: ImageVector? = null
