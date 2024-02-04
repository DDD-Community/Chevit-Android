package com.dkin.chevit.presentation.auth.signin

import com.dkin.chevit.core.mvi.ViewEffect
import com.dkin.chevit.core.mvi.ViewIntent
import com.dkin.chevit.core.mvi.ViewState

sealed interface SignInIntent : ViewIntent {
    object SignInSuccess : SignInIntent

    @JvmInline
    value class SignInFailure(val throwable: Throwable) : SignInIntent
}

object SignInState : ViewState

sealed interface SignInEffect : ViewEffect {
    object NavigateSignUp : SignInEffect

    object NavigateHome : SignInEffect

    @JvmInline
    value class ShowSignInFailed(val message: String) : SignInEffect
}
