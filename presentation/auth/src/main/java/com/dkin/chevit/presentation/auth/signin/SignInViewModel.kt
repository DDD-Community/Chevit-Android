package com.dkin.chevit.presentation.auth.signin

import com.dkin.chevit.core.mvi.MVIViewModel
import com.dkin.chevit.domain.base.get
import com.dkin.chevit.domain.model.UserState.Guest
import com.dkin.chevit.domain.model.UserState.NotRegister
import com.dkin.chevit.domain.model.UserState.User
import com.dkin.chevit.domain.usecase.auth.GetUserStateUseCase
import com.dkin.chevit.presentation.auth.signin.SignInIntent.SignInFailure
import com.dkin.chevit.presentation.auth.signin.SignInIntent.SignInSuccess
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val getUserStateUseCase: GetUserStateUseCase,
) : MVIViewModel<SignInIntent, SignInState, SignInEffect>() {
    override fun createInitialState(): SignInState = SignInState

    override suspend fun processIntent(intent: SignInIntent) =
        when (intent) {
            SignInSuccess -> signIn()
            is SignInFailure -> showSignInFailed()
        }

    private suspend fun signIn() {
        val effect =
            when (getUserStateUseCase(Unit).get()) {
                is User -> SignInEffect.NavigateHome
                is NotRegister -> SignInEffect.NavigateSignUp
                Guest -> SignInEffect.ShowSignInFailed
            }
        setEffect { effect }
    }

    private fun showSignInFailed() {
        setEffect { SignInEffect.ShowSignInFailed }
    }
}
