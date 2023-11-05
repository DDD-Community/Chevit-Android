package com.dkin.chevit.presentation.resource.icon.category

import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.dkin.chevit.presentation.resource.icon.ChevitIcon

public val ChevitIcon.CategoryElectronics: ImageVector
    get() {
        if (_categoryElectronics != null) {
            return _categoryElectronics!!
        }
        _categoryElectronics = Builder(name = "CategoryElectronics", defaultWidth = 48.0.dp, defaultHeight =
                48.0.dp, viewportWidth = 48.0f, viewportHeight = 48.0f).apply {
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
        return _categoryElectronics!!
    }

private var _categoryElectronics: ImageVector? = null
