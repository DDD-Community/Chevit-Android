package com.dkin.chevit.presentation.home.contents.user.profile

import android.os.Bundle
import android.os.FileUtils.copy
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.window.DialogProperties
import androidx.core.content.FileProvider
import androidx.core.net.toUri
import androidx.fragment.app.viewModels
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.dialog
import androidx.navigation.compose.rememberNavController
import androidx.navigation.findNavController
import com.dkin.chevit.core.mvi.MVIComposeFragment
import com.dkin.chevit.presentation.deeplink.navPopBack
import com.dkin.chevit.presentation.home.contents.user.profile.ProfileSettingEffect.NavPopBack
import dagger.hilt.android.AndroidEntryPoint
import java.io.File
import java.io.FileOutputStream


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
                val settingState by viewModel.state.collectAsStateWithLifecycle()
                var imageUrl by remember { mutableStateOf("") }
                var imageChanged by remember { mutableStateOf(false) }

                LaunchedEffect(settingState) {
                    val state = settingState
                    if (state is ProfileSettingState.Stable) {
                        imageUrl = state.imageUrl
                    }
                }

                NavHost(navController = navController, startDestination = "settingMain") {
                    composable("settingMain") {
                        ProfileSettingScreen(
                            viewModel = viewModel,
                            settingState = settingState,
                            imageUrl = imageUrl,
                            onClickBack = { findNavController().popBackStack() },
                            onClickImage = { navController.navigate("editImage") },
                            onClickSave = { name ->
                                saveProfileSetting(
                                    name,
                                    imageUrl,
                                    imageChanged
                                )
                            }
                        )
                    }
                    dialog(
                        route = "editImage",
                        dialogProperties = DialogProperties(usePlatformDefaultWidth = false)
                    ) {
                        EditProfileImageContents(
                            onClickBack = { navController.popBackStack() },
                            changeImage = { uri ->
                                imageUrl = uri.toString()
                                imageChanged = true
                            }
                        )
                    }
                }
            }
        }
    }

    private fun saveProfileSetting(name: String, imageUrl: String, imageChanged: Boolean) {
        val directory = File(requireContext().cacheDir, "images")
        directory.mkdirs() // 임시 파일이 위치할 폴더를 생성한다.

        if (imageChanged) {
            val file = File.createTempFile(
                "selected_image",
                ".jpg",
                directory,
            ) // 해당 폴더에 임시 파일을 만든다.

            val authority = requireContext().packageName + ".fileprovider" //
            val outputFileUri = FileProvider.getUriForFile(requireContext(), authority, file)

            FileOutputStream(file).use { outputStream ->
                requireContext().contentResolver.openInputStream(imageUrl.toUri())
                    .use { inputStream ->
                        inputStream?.copyTo(outputStream)
                        outputStream.flush()
                    }
            }
            viewModel.dispatch(ProfileSettingIntent.SaveImageProfile(
                name,
                outputFileUri.toString(),
                file
            ))
        } else {
            viewModel.dispatch(ProfileSettingIntent.SaveProfile(
                name,
                imageUrl,
            ))
        }
    }
}
