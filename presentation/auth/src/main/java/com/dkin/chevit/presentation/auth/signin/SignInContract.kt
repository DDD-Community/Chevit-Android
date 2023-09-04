package com.dkin.chevit.presentation.auth.signin

import com.dkin.chevit.core.mvi.ViewEffect
import com.dkin.chevit.core.mvi.ViewIntent
import com.dkin.chevit.core.mvi.ViewState

sealed interface SignInIntent : ViewIntent {
    object SignInClicked : SignInIntent
}

object SignInState : ViewState

sealed interface SignInEffect : ViewEffect
