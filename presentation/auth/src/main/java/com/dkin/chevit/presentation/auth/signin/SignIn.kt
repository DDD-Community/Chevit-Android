package com.dkin.chevit.presentation.auth.signin

import androidx.fragment.app.viewModels
import com.dkin.chevit.core.mvi.MVIFragment
import com.dkin.chevit.presentation.auth.R
import com.dkin.chevit.presentation.auth.databinding.FragmentSignInBinding
import com.dkin.chevit.presentation.deeplink.DeepLink
import com.dkin.chevit.presentation.deeplink.deepLink

class SignIn : MVIFragment<FragmentSignInBinding, SignInIntent, SignInState, SignInEffect>(
    FragmentSignInBinding::inflate,
) {
    override val viewModel: SignInViewModel by viewModels()

    override fun initView() = binding {
        layoutGoogle.setOnClickListener {
            deepLink(DeepLink.Home) {
                popUpTo(R.id.signIn) { inclusive = true }
            }
        }
    }

    override fun processEffect(effect: SignInEffect) {
    }

    override fun processState(state: SignInState) {
    }
}
