package com.dkin.chevit.presentation.auth.signup

import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.viewModels
import com.dkin.chevit.core.mvi.MVIFragment
import com.dkin.chevit.presentation.auth.R
import com.dkin.chevit.presentation.auth.databinding.FragmentSignUpBinding
import com.dkin.chevit.presentation.auth.signup.SignUpEffect.NavigateToHome
import com.dkin.chevit.presentation.common.ext.setTextIfNewWithSelection
import com.dkin.chevit.presentation.deeplink.DeepLink.Home
import com.dkin.chevit.presentation.deeplink.deepLink
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignUp : MVIFragment<FragmentSignUpBinding, SignUpIntent, SignUpState, SignUpEffect>(
    FragmentSignUpBinding::inflate,
) {
    override val viewModel: SignUpViewModel by viewModels()

    override fun initView() = binding {
        etName.doOnTextChanged { text, _, _, _ ->
            setIntent(SignUpIntent.NameChanged(text.toString()))
        }
        cbTermsAll.setOnCheckedChangeListener { _, isChecked ->
            setIntent(SignUpIntent.TermsAllClicked(isChecked))
        }
        cbServiceTerms.setOnCheckedChangeListener { _, isChecked ->
            setIntent(SignUpIntent.TermsServiceClicked(isChecked))
        }
        cbPrivacyTerms.setOnCheckedChangeListener { _, isChecked ->
            setIntent(SignUpIntent.TermsPrivacyClicked(isChecked))
        }
        btnSignUp.setOnClickListener {
            setIntent(SignUpIntent.SubmitClicked)
        }
    }

    override fun processState(state: SignUpState) =
        binding {
            etName.setTextIfNewWithSelection(state.name)
            cbTermsAll.isChecked = state.hasTermsAllClicked
            cbServiceTerms.isChecked = state.termsServiceChecked
            cbPrivacyTerms.isChecked = state.termsPrivacyChecked
            btnSignUp.isEnabled = state.validSubmitButton
        }

    override fun processEffect(effect: SignUpEffect) = when (effect) {
        NavigateToHome -> deepLink(Home) {
            popUpTo(R.id.auth) { inclusive = true }
        }
    }
}
