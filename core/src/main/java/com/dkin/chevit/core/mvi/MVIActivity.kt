package com.dkin.chevit.core.mvi

import android.view.LayoutInflater
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.viewbinding.ViewBinding
import com.dkin.chevit.core.base.BaseActivity
import kotlinx.coroutines.launch

abstract class MVIActivity<BINDING : ViewBinding, I : ViewIntent, S : ViewState, E : ViewEffect>(
    inflater: (LayoutInflater) -> BINDING,
) : BaseActivity<BINDING>(inflater), MviView<I, S, E> {
    abstract val viewModel: MVIViewModel<I, S, E>

    override fun setIntent(intent: I) {
        viewModel.dispatch(intent)
    }

    init {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.RESUMED) {
                viewModel.state.collect(::processState)
            }
        }
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.RESUMED) {
                viewModel.effect.collect(::processEffect)
            }
        }
    }
}
