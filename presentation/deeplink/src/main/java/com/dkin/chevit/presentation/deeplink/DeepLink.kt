package com.dkin.chevit.presentation.deeplink

import android.net.Uri

sealed interface DeepLink {
    val deepLink: String
    val uri: Uri
        get() = Uri.parse(deepLink)

    object OnBoarding : DeepLink {
        override val deepLink: String = "$SCHEME://auth/onboarding"
    }

    object SignIn : DeepLink {
        override val deepLink: String = "$SCHEME://auth/signin"
    }

    object SignUp : DeepLink {
        override val deepLink: String = "$SCHEME://auth/signup"
    }

    object Home : DeepLink {
        override val deepLink: String = "$SCHEME://home"
    }

    object Step : DeepLink {
        override val deepLink: String = "$SCHEME://step"
    }

    data class CheckList(val id: String) : DeepLink {
        override val deepLink: String = "$SCHEME://checklist/$id"
    }

    companion object {
        private const val SCHEME = "chevit"
    }
}
