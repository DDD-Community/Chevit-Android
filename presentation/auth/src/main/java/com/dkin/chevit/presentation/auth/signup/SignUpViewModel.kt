package com.dkin.chevit.presentation.auth.signup

import com.dkin.chevit.core.mvi.MVIViewModel
import com.dkin.chevit.domain.base.get
import com.dkin.chevit.domain.base.getOrNull
import com.dkin.chevit.domain.base.onComplete
import com.dkin.chevit.domain.model.UserState.User
import com.dkin.chevit.domain.repository.ServiceRepository
import com.dkin.chevit.domain.usecase.auth.SignUpUserUseCase
import com.dkin.chevit.domain.usecase.service.GetAppInfoUseCase
import com.dkin.chevit.presentation.auth.signup.SignUpIntent.NameChanged
import com.dkin.chevit.presentation.auth.signup.SignUpIntent.ShowTermsPrivacyClicked
import com.dkin.chevit.presentation.auth.signup.SignUpIntent.ShowTermsServiceClicked
import com.dkin.chevit.presentation.auth.signup.SignUpIntent.SubmitClicked
import com.dkin.chevit.presentation.auth.signup.SignUpIntent.TermsAllClicked
import com.dkin.chevit.presentation.auth.signup.SignUpIntent.TermsPrivacyClicked
import com.dkin.chevit.presentation.auth.signup.SignUpIntent.TermsServiceClicked
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val signUpUserUseCase: SignUpUserUseCase,
    private val getAppInfoUseCase: GetAppInfoUseCase
) : MVIViewModel<SignUpIntent, SignUpState, SignUpEffect>() {
    override fun createInitialState(): SignUpState = SignUpState()

    override suspend fun processIntent(intent: SignUpIntent) = when (intent) {
        is NameChanged -> setState { copy(name = intent.name) }
        is TermsAllClicked -> termsAllClicked(intent.checked)
        is TermsServiceClicked -> setState { copy(termsServiceChecked = intent.checked) }
        ShowTermsServiceClicked -> showTermsServiceClicked()
        is TermsPrivacyClicked -> setState { copy(termsPrivacyChecked = intent.checked) }
        ShowTermsPrivacyClicked -> showTermsPrivacyClicked()
        SubmitClicked -> submitClicked()
    }

    private fun termsAllClicked(checked: Boolean) = currentState {
        if (checked == hasTermsAllClicked) return@currentState
        setState {
            copy(
                termsServiceChecked = checked,
                termsPrivacyChecked = checked,
            )
        }
    }

    private suspend fun showTermsServiceClicked() {
        getAppInfoUseCase(Unit).onComplete {
            setEffect { SignUpEffect.ShowTermsService(termsOfServiceWebUrl) }
        }
    }

    private suspend fun showTermsPrivacyClicked() {
        getAppInfoUseCase(Unit).onComplete {
            setEffect { SignUpEffect.ShowTermsService(privacyPolicyWebUrl) }
        }
    }

    private suspend fun submitClicked() {
        val name = currentState { name }
        val param = SignUpUserUseCase.Param(name = name)
        val user = signUpUserUseCase(param).get()
        if (user is User) {
            setEffect { SignUpEffect.NavigateToHome }
        }
    }
}
