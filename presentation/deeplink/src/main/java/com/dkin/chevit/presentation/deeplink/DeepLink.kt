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

    object Profile : DeepLink {
        override val deepLink: String = "$SCHEME://profile"
    }

    object Step : DeepLink {
        override val deepLink: String = "$SCHEME://step"
    }

    data class CheckList(val id: String) : DeepLink {
        override val deepLink: String = "$SCHEME://checklist/$id"
    }

    object MyCheckList : DeepLink {
        override val deepLink: String = "$SCHEME://myChecklist"
    }

    data class CheckListDetail(val planId: String, val categoryId: String) : DeepLink {
        override val deepLink: String = "$SCHEME://checklist/$planId/$categoryId"
    }

    data class AddCategory(val planId: String) : DeepLink {
        override val deepLink: String = "$SCHEME://addCategory/$planId"
    }

    companion object {
        private const val SCHEME = "chevit"
    }
}
