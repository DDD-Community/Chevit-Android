package com.dkin.chevit.presentation.auth.signup

import com.dkin.chevit.core.mvi.ViewEffect
import com.dkin.chevit.core.mvi.ViewIntent
import com.dkin.chevit.core.mvi.ViewState
import com.dkin.chevit.domain.model.Gender
import com.dkin.chevit.domain.model.Gender.FEMALE
import com.dkin.chevit.domain.model.Gender.MALE
import com.dkin.chevit.domain.model.Gender.UNKNOWN
import com.dkin.chevit.presentation.auth.R

sealed interface SignUpIntent : ViewIntent {
    @JvmInline
    value class NameChanged(val name: String) : SignUpIntent

    @JvmInline
    value class BirthDayChanged(val birthDay: String) : SignUpIntent

    @JvmInline
    value class GenderClicked(val gender: Gender) : SignUpIntent

    @JvmInline
    value class TermsAllClicked(val checked: Boolean) : SignUpIntent

    @JvmInline
    value class TermsServiceClicked(val checked: Boolean) : SignUpIntent

    @JvmInline
    value class TermsPrivacyClicked(val checked: Boolean) : SignUpIntent

    object SubmitClicked : SignUpIntent
}

data class SignUpState(
    val name: String = "",
    val birthDay: String = "",
    val gender: Gender = UNKNOWN,
    val termsServiceChecked: Boolean = false,
    val termsPrivacyChecked: Boolean = false,
) : ViewState {
    val selectedGenderResId: Int
        get() =
            when (gender) {
                MALE -> R.id.chip_male
                FEMALE -> R.id.chip_female
                UNKNOWN -> -1
            }
    val hasTermsAllClicked: Boolean
        get() = termsServiceChecked && termsPrivacyChecked
    val validSubmitButton: Boolean
        get() =
            name.isNotBlank() &&
                birthDay.toLongOrNull() != null &&
                gender != UNKNOWN &&
                hasTermsAllClicked
}

sealed interface SignUpEffect : ViewEffect
