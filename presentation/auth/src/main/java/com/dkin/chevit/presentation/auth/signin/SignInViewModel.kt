package com.dkin.chevit.presentation.auth.signin

import com.dkin.chevit.core.mvi.MVIViewModel
import com.dkin.chevit.presentation.auth.signin.SignInIntent.SignInClicked
import javax.inject.Inject

class SignInViewModel @Inject constructor(
) : MVIViewModel<SignInIntent, SignInState, SignInEffect>() {
    override fun createInitialState(): SignInState = SignInState

    override suspend fun processIntent(intent: SignInIntent) = when(intent){
        SignInClicked -> TODO()
    }
}
