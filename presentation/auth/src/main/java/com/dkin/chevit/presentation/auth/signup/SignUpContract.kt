package com.dkin.chevit.presentation.auth.signup

import com.dkin.chevit.core.mvi.ViewEffect
import com.dkin.chevit.core.mvi.ViewIntent
import com.dkin.chevit.core.mvi.ViewState

sealed interface SignUpIntent : ViewIntent {
    @JvmInline
    value class NameChanged(val name: String) : SignUpIntent

    @JvmInline
    value class TermsAllClicked(val checked: Boolean) : SignUpIntent

    @JvmInline
    value class TermsServiceClicked(val checked: Boolean) : SignUpIntent

    object ShowTermsServiceClicked : SignUpIntent

    @JvmInline
    value class TermsPrivacyClicked(val checked: Boolean) : SignUpIntent
    object ShowTermsPrivacyClicked : SignUpIntent

    object SubmitClicked : SignUpIntent
}

data class SignUpState(
    val name: String = "",
    val termsServiceChecked: Boolean = false,
    val termsPrivacyChecked: Boolean = false,
) : ViewState {
    val hasTermsAllClicked: Boolean
        get() = termsServiceChecked && termsPrivacyChecked
    val validSubmitButton: Boolean
        get() = name.isNotBlank() && hasTermsAllClicked
}

sealed interface SignUpEffect : ViewEffect {
    object NavigateToHome : SignUpEffect
    @JvmInline
    value class ShowTermsService(val webUrl: String) : SignUpEffect
}
