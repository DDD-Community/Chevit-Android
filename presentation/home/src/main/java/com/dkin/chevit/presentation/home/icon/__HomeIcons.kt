package com.dkin.chevit.presentation.home.icon

import androidx.compose.ui.graphics.vector.ImageVector
import kotlin.collections.List as ____KtList

public object HomeIcons

private var __HomeIcons: ____KtList<ImageVector>? = null

public val HomeIcons.AllIcons: ____KtList<ImageVector>
    get() {
        if (__HomeIcons != null) {
            return __HomeIcons!!
        }
        __HomeIcons = listOf(
            Search, User, Home, UserSelected, HomeSelected, Survey, SearchSelected,
            SurveySelected, Notification, Logo,
        )
        return __HomeIcons!!
    }
