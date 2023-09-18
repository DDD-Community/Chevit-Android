package com.dkin.chevit.presentation.auth.signup

import com.dkin.chevit.core.mvi.MVIViewModel
import com.dkin.chevit.domain.base.get
import com.dkin.chevit.domain.usecase.GetUserStateUseCase
import com.dkin.chevit.presentation.auth.signup.SignUpIntent.BirthDayChanged
import com.dkin.chevit.presentation.auth.signup.SignUpIntent.GenderClicked
import com.dkin.chevit.presentation.auth.signup.SignUpIntent.NameChanged
import com.dkin.chevit.presentation.auth.signup.SignUpIntent.SubmitClicked
import com.dkin.chevit.presentation.auth.signup.SignUpIntent.TermsAllClicked
import com.dkin.chevit.presentation.auth.signup.SignUpIntent.TermsPrivacyClicked
import com.dkin.chevit.presentation.auth.signup.SignUpIntent.TermsServiceClicked
import dagger.hilt.android.lifecycle.HiltViewModel
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel
    @Inject
    constructor(
        private val getUserStateUseCase: GetUserStateUseCase,
    ) : MVIViewModel<SignUpIntent, SignUpState, SignUpEffect>() {
        override fun createInitialState(): SignUpState = SignUpState()

        override suspend fun processIntent(intent: SignUpIntent) {
            Timber.d("intent: $intent")
            when (intent) {
                is NameChanged -> setState { copy(name = intent.name) }
                is BirthDayChanged -> setState { copy(birthDay = intent.birthDay) }
                is GenderClicked -> setState { copy(gender = intent.gender) }
                is TermsAllClicked -> termsAllClicked(intent.checked)
                is TermsServiceClicked -> setState { copy(termsServiceChecked = intent.checked) }
                is TermsPrivacyClicked -> setState { copy(termsPrivacyChecked = intent.checked) }
                SubmitClicked -> submitClicked()
            }
        }

        private fun termsAllClicked(checked: Boolean) =
            currentState {
                if (checked == hasTermsAllClicked) return@currentState
                setState {
                    copy(
                        termsServiceChecked = checked,
                        termsPrivacyChecked = checked,
                    )
                }
            }

        private suspend fun submitClicked() {
            val user = getUserStateUseCase(Unit).get()
            Timber.d("user: $user")
        }
    }
