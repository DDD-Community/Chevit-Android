package com.dkin.chevit.presentation.home

import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.viewModels
import com.dkin.chevit.core.mvi.MVIComposeFragment
import com.dkin.chevit.presentation.home.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber


@AndroidEntryPoint
class Home : MVIComposeFragment<HomeIntent, HomeState, HomeEffect>() {
    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!

    override val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        val window = requireActivity().window
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.setDecorFitsSystemWindows(false)
            window.statusBarColor = Color.TRANSPARENT
        } else {
            window.statusBarColor = Color.TRANSPARENT
            window.decorView.systemUiVisibility =
                View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        }
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root
        binding.composeView.apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                HomeScreen(
                    modifier = Modifier
                        .fillMaxSize()
                        .statusBarsPadding()
                        .navigationBarsPadding(),
                    homeViewModel = viewModel,
                    versionName = requireContext().packageManager.getPackageInfo(
                        requireContext().packageName,
                        0,
                    ).versionName,
                )
            }
        }
        return view
    }

    override fun processEffect(effect: HomeEffect) {
        Timber.tag("Home").d("processEffect")
        when (effect) {
            HomeEffect.NavigateToAddCheckList -> {}
            is HomeEffect.NavigateToCheckList -> {}
            HomeEffect.NavigateToMyCheckList -> {}
            HomeEffect.NavigateToProfileSetting -> {}
            HomeEffect.NavigateToTerms -> {}
            HomeEffect.NavigateToNotificationSetting -> {
                val settingsIntent: Intent = Intent("android.settings.APP_NOTIFICATION_SETTINGS")
                    .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    .putExtra("app_package", requireContext().packageName)
                    .putExtra("app_uid", requireContext().applicationInfo.uid)
                    .putExtra("android.provider.extra.APP_PACKAGE", requireContext().packageName)
                startActivity(settingsIntent)
            }
            HomeEffect.NavigateToAddTemplate -> {}
            HomeEffect.NavigateToSortTemplate -> {}
        }
    }

    override fun processState(state: HomeState) {
    }
}
