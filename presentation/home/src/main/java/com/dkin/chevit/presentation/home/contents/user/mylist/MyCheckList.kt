package com.dkin.chevit.presentation.home.contents.user.mylist

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
import com.dkin.chevit.presentation.deeplink.DeepLink
import com.dkin.chevit.presentation.deeplink.deepLink
import com.dkin.chevit.presentation.home.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MyCheckList :
    MVIComposeFragment<MyCheckListIntent, MyCheckListState, MyCheckListEffect>() {
    override val viewModel: MyCheckListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                val state by viewModel.state.collectAsState()
                MyCheckListScreen(
                    onClickBack = { findNavController().popBackStack() },
                    checkList = state.checkList,
                    onClickChecklist = { id -> viewModel.onClickChecklist(id) }
                )
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.initMyChecklist()
    }

    override fun processEffect(effect: MyCheckListEffect) {
        when (effect) {
            is MyCheckListEffect.NavigateToCheckList -> deepLink(DeepLink.CheckList(effect.id)) {
                popUpTo(
                    R.id.myChecklist
                )
            }
        }
    }

    override fun processState(state: MyCheckListState) {}

}