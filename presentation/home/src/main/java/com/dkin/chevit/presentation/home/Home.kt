package com.dkin.chevit.presentation.home

import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.dkin.chevit.core.mvi.MVIComposeFragment
import com.dkin.chevit.presentation.deeplink.DeepLink
import com.dkin.chevit.presentation.deeplink.DeepLink.OnBoarding
import com.dkin.chevit.presentation.deeplink.deepLink
import com.dkin.chevit.presentation.home.MyPageEffect.NavigateToMyCheckList
import com.dkin.chevit.presentation.home.MyPageEffect.NavigateToNotificationSetting
import com.dkin.chevit.presentation.home.MyPageEffect.NavigateToOnBoarding
import com.dkin.chevit.presentation.home.MyPageEffect.NavigateToProfileSetting
import com.dkin.chevit.presentation.home.MyPageEffect.NavigateToTerms
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Home : MVIComposeFragment<HomeIntent, HomeState, HomeEffect>() {
    override val viewModel: HomeViewModel by viewModels()

    private val templateViewModel: TemplateViewModel by viewModels()
    private val myPageViewModel: MyPageViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        val window = requireActivity().window
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.setDecorFitsSystemWindows(true)
            window.statusBarColor = Color.TRANSPARENT
        } else {
            window.statusBarColor = Color.TRANSPARENT
            window.decorView.systemUiVisibility =
                View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        }
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                HomeScreen(
                    modifier = Modifier
                        .fillMaxSize()
                        .statusBarsPadding()
                        .navigationBarsPadding(),
                    homeViewModel = viewModel,
                    templateViewModel = templateViewModel,
                    myPageViewModel = myPageViewModel,
                    versionName = requireContext().packageManager.getPackageInfo(
                        requireContext().packageName,
                        0,
                    ).versionName,
                )
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initCollect()
        myPageViewModel.dispatch(MyPageIntent.ViewCreated)
    }

    override fun processEffect(effect: HomeEffect) {
        when (effect) {
            HomeEffect.NavigateToAddCheckList ->
                deepLink(DeepLink.Step) { popUpTo(R.id.home) }

            is HomeEffect.NavigateToCheckList -> {
                deepLink(DeepLink.CheckList(effect.id)) { popUpTo(R.id.home) }
            }
        }
    }

    private fun processEffect(effect: TemplateEffect) {
        when (effect) {
            TemplateEffect.NavigateToAddTemplate -> {}
            TemplateEffect.NavigateToSortTemplate -> {}
            is TemplateEffect.NavigateToTemplate -> {}
        }
    }

    private fun processEffect(effect: MyPageEffect) {
        when (effect) {
            NavigateToMyCheckList -> {}
            NavigateToNotificationSetting -> {
                val settingsIntent: Intent = Intent("android.settings.APP_NOTIFICATION_SETTINGS")
                    .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    .putExtra("app_package", requireContext().packageName)
                    .putExtra("app_uid", requireContext().applicationInfo.uid)
                    .putExtra("android.provider.extra.APP_PACKAGE", requireContext().packageName)
                startActivity(settingsIntent)
            }

            NavigateToProfileSetting -> {}
            NavigateToTerms -> {}
            NavigateToOnBoarding -> deepLink(OnBoarding) {
                popUpTo(R.id.home) { inclusive = true }
            }
        }
    }

    override fun processState(state: HomeState) {}
    private fun processState(state: TemplateState) {}
    private fun processState(state: MyPageState) {}

    private fun initCollect() {
        viewLifecycleOwner.lifecycleScope.launchWhenResumed {
            templateViewModel.state.collect {
                processState(it)
            }
        }
        viewLifecycleOwner.lifecycleScope.launchWhenResumed {
            templateViewModel.effect.collect {
                processEffect(it)
            }
        }
        viewLifecycleOwner.lifecycleScope.launchWhenResumed {
            myPageViewModel.state.collect {
                processState(it)
            }
        }
        viewLifecycleOwner.lifecycleScope.launchWhenResumed {
            myPageViewModel.effect.collect {
                processEffect(it)
            }
        }
    }
}
