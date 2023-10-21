package com.dkin.chevit.domain.base

import kotlinx.coroutines.CoroutineDispatcher

interface CoroutineDispatcherProvider {
    val default: CoroutineDispatcher
    val io: CoroutineDispatcher
    val main: CoroutineDispatcher
}
