package com.dkin.chevit.core.mvi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.launch

abstract class MVIComposeFragment<I : ViewIntent, S : ViewState, E : ViewEffect> : Fragment(), MviView<I, S, E> {
    abstract val viewModel: MVIViewModel<I, S, E>

    override fun setIntent(intent: I) {
        viewModel.dispatch(intent)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initCollect()
    }

    private fun initCollect() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.RESUMED) {
                viewModel.state.collect {
                    processState(it)
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.RESUMED) {
                viewModel.effect.collect {
                    processEffect(it)
                }
            }
        }
    }
}
