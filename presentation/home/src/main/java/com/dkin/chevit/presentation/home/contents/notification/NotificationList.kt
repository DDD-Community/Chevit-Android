package com.dkin.chevit.presentation.home.contents.notification

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.dkin.chevit.core.mvi.MVIComposeFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NotificationList :
    MVIComposeFragment<NotificationListIntent, NotificationListState, NotificationListEffect>() {
    override val viewModel: NotificationListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                val state by viewModel.state.collectAsState()
                NotificationListScreen(
                    onClickBack = { findNavController().popBackStack() },
                    state = state,
                )
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.initNotificationList()
    }

    override fun processEffect(effect: NotificationListEffect) {}

    override fun processState(state: NotificationListState) {}
}