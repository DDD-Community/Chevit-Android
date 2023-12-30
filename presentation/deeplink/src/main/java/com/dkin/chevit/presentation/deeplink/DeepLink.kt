package com.dkin.chevit.presentation.deeplink

import android.net.Uri

sealed interface DeepLink {
    val deepLink: String
    val uri: Uri
        get() = Uri.parse(deepLink)

    object OnBoarding : DeepLink {
        override val deepLink: String = "$SCHEME://auth/onboarding"
    }

    object Terms : DeepLink {
        override val deepLink: String = "$SCHEME://terms"
    }

    object SignIn : DeepLink {
        override val deepLink: String = "$SCHEME://auth/signin"
    }

    object SignUp : DeepLink {
        override val deepLink: String = "$SCHEME://auth/signup"
    }

    data class Home(val startIndex: Int = 0) : DeepLink {
        override val deepLink: String = "$SCHEME://home/$startIndex"
    }

    object Profile : DeepLink {
        override val deepLink: String = "$SCHEME://profile"
    }

    data class Step(val nickname: String) : DeepLink {
        override val deepLink: String = "$SCHEME://step/$nickname"
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

    data class EditCategory(
        val planId: String,
        val categoryId: String,
        val title: String,
        val type: String
    ) : DeepLink {
        override val deepLink: String = "$SCHEME://editCategory/$planId/$categoryId/$title/$type"
    }

    data class TemplateDetail(val id: String) : DeepLink {
        override val deepLink: String = "$SCHEME://template/$id"
    }

    data class BringTemplate(val id: String) : DeepLink {
        override val deepLink: String = "$SCHEME://bringTemplate/$id"
    }

    companion object {
        private const val SCHEME = "chevit"
    }
}
