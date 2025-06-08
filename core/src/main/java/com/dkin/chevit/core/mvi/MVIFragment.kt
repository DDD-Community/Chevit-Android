package com.dkin.chevit.core.mvi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.viewbinding.ViewBinding
import com.dkin.chevit.core.base.BaseFragment
import kotlinx.coroutines.launch

abstract class MVIFragment<BINDING : ViewBinding, I : ViewIntent, S : ViewState, E : ViewEffect>(
    inflater: (LayoutInflater, ViewGroup?, Boolean) -> BINDING,
) : BaseFragment<BINDING>(inflater), MviView<I, S, E> {
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
