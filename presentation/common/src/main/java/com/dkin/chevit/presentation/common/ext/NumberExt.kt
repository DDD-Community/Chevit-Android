package com.dkin.chevit.presentation.common.ext

fun Number.isNegative() =
    when (this) {
        is Double -> this < 0
        is Float -> this < 0
        is Int -> this < 0
        is Long -> this < 0
        is Short -> this < 0
        else -> false
    }

fun Number.isPositive() =
    when (this) {
        is Double -> this > 0
        is Float -> this > 0
        is Int -> this > 0
        is Long -> this > 0
        is Short -> this > 0
        else -> false
    }
