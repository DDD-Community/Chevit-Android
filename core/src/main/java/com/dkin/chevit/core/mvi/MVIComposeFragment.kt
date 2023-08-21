package com.dkin.chevit.core.mvi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope

abstract class MVIComposeFragment<I : ViewIntent, S : ViewState, E : ViewEffect> : Fragment(), MviView<I, S, E> {
    abstract val viewModel: MVIViewModel<I, S, E>

    override fun setIntent(intent: I) {
        viewModel.dispatch(intent)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        initCollect()
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    private fun initCollect() {
        viewLifecycleOwner.lifecycleScope.launchWhenResumed {
            viewModel.state.collect {
                processState(it)
            }
        }
        viewLifecycleOwner.lifecycleScope.launchWhenResumed {
            viewModel.effect.collect {
                processEffect(it)
            }
        }
    }
}
