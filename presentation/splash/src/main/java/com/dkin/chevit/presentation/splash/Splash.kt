package com.dkin.chevit.presentation.splash

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.dkin.chevit.core.mvi.MVIFragment
import com.dkin.chevit.presentation.deeplink.DeepLink.Home
import com.dkin.chevit.presentation.deeplink.DeepLink.OnBoarding
import com.dkin.chevit.presentation.deeplink.DeepLink.SignUp
import com.dkin.chevit.presentation.deeplink.deepLink
import com.dkin.chevit.presentation.splash.SplashEffect.NavigateToHome
import com.dkin.chevit.presentation.splash.SplashEffect.NavigateToOnBoarding
import com.dkin.chevit.presentation.splash.SplashEffect.NavigateToSignUp
import com.dkin.chevit.presentation.splash.databinding.FragmentSplashBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Splash : MVIFragment<FragmentSplashBinding, SplashIntent, SplashState, SplashEffect>(
    FragmentSplashBinding::inflate,
) {
    override val viewModel: SplashViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val window = requireActivity().window
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.setDecorFitsSystemWindows(false)
            window.statusBarColor = Color.TRANSPARENT
        } else {
            window.statusBarColor = Color.TRANSPARENT
            window.decorView.systemUiVisibility =
                View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        }
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun initView() {
        setIntent(SplashIntent.CheckAuth)
    }

    override fun processState(state: SplashState) {
    }

    override fun processEffect(effect: SplashEffect) =
        when (effect) {
            NavigateToOnBoarding -> deepLink(OnBoarding) {
                popUpTo(R.id.splash) { inclusive = true }
            }

            NavigateToHome -> deepLink(Home()) {
                popUpTo(R.id.splash) { inclusive = true }
            }

            NavigateToSignUp -> deepLink(SignUp) {
                popUpTo(R.id.splash) { inclusive = true }
            }
        }
}
