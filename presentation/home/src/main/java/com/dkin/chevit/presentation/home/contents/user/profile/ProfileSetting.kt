package com.dkin.chevit.presentation.home.contents.user.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.window.DialogProperties
import androidx.fragment.app.viewModels
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.dialog
import androidx.navigation.compose.rememberNavController
import androidx.navigation.findNavController
import com.dkin.chevit.core.mvi.MVIComposeFragment
import com.dkin.chevit.presentation.deeplink.navPopBack
import com.dkin.chevit.presentation.home.contents.user.profile.ProfileSettingEffect.NavPopBack
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileSetting :
    MVIComposeFragment<ProfileSettingIntent, ProfileSettingState, ProfileSettingEffect>() {
    override val viewModel: ProfileSettingViewModel by viewModels()

    override fun processEffect(effect: ProfileSettingEffect) {
        when (effect) {
            NavPopBack -> navPopBack()
        }
    }

    override fun processState(state: ProfileSettingState) {}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "settingMain") {
                    composable("settingMain") {
                        ProfileSettingScreen(
                            viewModel = viewModel,
                            onClickBack = { findNavController().popBackStack() },
                            onClickImage = { navController.navigate("editImage") }
                        )
                    }
                    dialog(
                        route = "editImage",
                        dialogProperties = DialogProperties(usePlatformDefaultWidth = false)
                    ) {
                        EditProfileImageContents(
                            viewModel = viewModel,
                            onClickBack = { navController.popBackStack() }
                        )
                    }
                }
            }
        }
    }
}
