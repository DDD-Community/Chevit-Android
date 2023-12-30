package com.dkin.chevit.presentation.auth.signup

import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.net.toUri
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.viewModels
import com.dkin.chevit.core.mvi.MVIFragment
import com.dkin.chevit.presentation.auth.R
import com.dkin.chevit.presentation.auth.databinding.FragmentSignUpBinding
import com.dkin.chevit.presentation.auth.signup.SignUpEffect.NavigateToHome
import com.dkin.chevit.presentation.auth.signup.SignUpEffect.ShowTermsService
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
        tvShowServiceTerms.setOnClickListener {
            setIntent(SignUpIntent.ShowTermsServiceClicked)
        }
        cbPrivacyTerms.setOnCheckedChangeListener { _, isChecked ->
            setIntent(SignUpIntent.TermsPrivacyClicked(isChecked))
        }
        tvShowPrivacyTerms.setOnClickListener {
            setIntent(SignUpIntent.ShowTermsPrivacyClicked)
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
        NavigateToHome -> deepLink(Home()) {
            popUpTo(R.id.auth) { inclusive = true }
        }

        is ShowTermsService -> {
            CustomTabsIntent.Builder()
                .build()
                .launchUrl(requireContext(), effect.webUrl.toUri())
        }
    }
}
