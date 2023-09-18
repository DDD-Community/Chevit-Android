package com.dkin.chevit.presentation.splash

import com.dkin.chevit.core.mvi.MVIViewModel
import com.dkin.chevit.domain.base.get
import com.dkin.chevit.domain.model.UserState.Guest
import com.dkin.chevit.domain.model.UserState.NotRegister
import com.dkin.chevit.domain.model.UserState.User
import com.dkin.chevit.domain.usecase.GetUserStateUseCase
import com.dkin.chevit.presentation.splash.SplashEffect.NavigateToHome
import com.dkin.chevit.presentation.splash.SplashEffect.NavigateToOnBoarding
import com.dkin.chevit.presentation.splash.SplashEffect.NavigateToSignUp
import com.dkin.chevit.presentation.splash.SplashIntent.CheckAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.delay
import javax.inject.Inject

@HiltViewModel
class SplashViewModel
    @Inject
    constructor(
        private val getUserStateUseCase: GetUserStateUseCase,
    ) : MVIViewModel<SplashIntent, SplashState, SplashEffect>() {
        override fun createInitialState(): SplashState = SplashState

        override suspend fun processIntent(intent: SplashIntent) =
            when (intent) {
                CheckAuth -> checkAuth()
            }

        private suspend fun checkAuth() {
            val delayAsync = async { delay(SPLASH_DELAY) }
            val userAsync = async { getUserStateUseCase(Unit).get() }
            listOf(delayAsync, userAsync).awaitAll()
            val effect =
                when (userAsync.await()) {
                    Guest -> NavigateToOnBoarding
                    is User -> NavigateToHome
                    is NotRegister -> NavigateToSignUp
                }
            setEffect { effect }
        }

        companion object {
            private const val SPLASH_DELAY = 2000L
        }
    }
