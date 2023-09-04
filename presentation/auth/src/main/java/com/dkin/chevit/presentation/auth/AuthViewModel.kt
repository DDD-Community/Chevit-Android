package com.dkin.chevit.presentation.auth

import com.dkin.chevit.core.mvi.MVIViewModel
import com.dkin.chevit.presentation.auth.AuthIntent.NextClicked
import com.dkin.chevit.presentation.auth.AuthIntent.SelectedIntro
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor() : MVIViewModel<AuthIntent, AuthState, AuthEffect>() {
    override fun createInitialState(): AuthState = AuthState()

    override suspend fun processIntent(intent: AuthIntent) = when (intent) {
        NextClicked -> selectNext()
        is SelectedIntro -> selectPosition(intent.position)
    }

    private fun selectNext() = currentState {
        val nextPosition = selectedIntroGuideIndex + 1
        val lastIndex = introGuideList.lastIndex
        if (nextPosition > lastIndex) {
            setEffect { AuthEffect.NavigateSignIn }
        } else {
            setState { copy(selectedIntroGuideIndex = nextPosition.coerceAtMost(lastIndex)) }
        }
    }

    private fun selectPosition(position: Int) {
        setState { copy(selectedIntroGuideIndex = position) }
    }
}
