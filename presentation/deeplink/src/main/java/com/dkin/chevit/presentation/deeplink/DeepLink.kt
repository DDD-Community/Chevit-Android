package com.dkin.chevit.presentation.deeplink

import android.net.Uri

sealed interface DeepLink {
    val deepLink: String
    val uri: Uri
        get() = Uri.parse(deepLink)

    object Auth : DeepLink {
        override val deepLink: String = "$SCHEME://auth"
    }

    object SignIn : DeepLink {
        override val deepLink: String = "$SCHEME://auth/signin"
    }

    object Home : DeepLink {
        override val deepLink: String = "$SCHEME://home"
    }

    object Step : DeepLink {
        override val deepLink: String = "$SCHEME://step"
    }

    object CheckList : DeepLink {
        override val deepLink: String = "$SCHEME://checklist"
    }

    companion object {
        private const val SCHEME = "chevit"
    }
}
