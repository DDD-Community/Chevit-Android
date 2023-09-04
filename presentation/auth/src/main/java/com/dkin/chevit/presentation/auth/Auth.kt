package com.dkin.chevit.presentation.auth

import androidx.fragment.app.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.dkin.chevit.core.mvi.MVIFragment
import com.dkin.chevit.presentation.auth.AuthEffect.NavigateSignIn
import com.dkin.chevit.presentation.auth.databinding.FragmentAuthBinding
import com.dkin.chevit.presentation.deeplink.DeepLink
import com.dkin.chevit.presentation.deeplink.deepLink
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Auth : MVIFragment<FragmentAuthBinding, AuthIntent, AuthState, AuthEffect>(
    FragmentAuthBinding::inflate,
) {
    override val viewModel: AuthViewModel by viewModels()
    private val introAdapter by lazy { IntroAdapter() }

    override fun initView() = binding {
        pager.adapter = introAdapter
        pager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                setIntent(AuthIntent.SelectedIntro(position))
            }
        })
        TabLayoutMediator(tlIntro, pager) { _, _ -> }.attach()
        btnNext.setOnClickListener { setIntent(AuthIntent.NextClicked) }
    }

    override fun processState(state: AuthState) = binding {
        introAdapter.submitList(state.introGuideList)
        pager.setCurrentItem(state.selectedIntroGuideIndex, true)
        tvTitle.text = state.title
        tvDescription.text = state.description
        btnNext.text = state.nextButtonText
    }

    override fun processEffect(effect: AuthEffect) = when (effect) {
        NavigateSignIn -> deepLink(DeepLink.SignIn) {
            popUpTo(R.id.auth) { inclusive = true }
        }
    }
}
