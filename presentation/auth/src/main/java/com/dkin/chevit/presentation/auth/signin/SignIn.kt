package com.dkin.chevit.presentation.auth.signin

import androidx.fragment.app.viewModels
import com.dkin.chevit.core.mvi.MVIFragment
import com.dkin.chevit.presentation.auth.databinding.FragmentSignInBinding

class SignIn : MVIFragment<FragmentSignInBinding, SignInIntent, SignInState, SignInEffect>(
    FragmentSignInBinding::inflate
) {
    override val viewModel: SignInViewModel by viewModels()

    override fun processEffect(effect: SignInEffect) {
    }

    override fun processState(state: SignInState) {
    }
}
