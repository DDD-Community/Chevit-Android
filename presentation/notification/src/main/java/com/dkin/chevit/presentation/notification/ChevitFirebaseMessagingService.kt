package com.dkin.chevit.presentation.notification

import androidx.lifecycle.ProcessLifecycleOwner
import androidx.lifecycle.lifecycleScope
import com.dkin.chevit.domain.usecase.notification.UpdatePushTokenUseCase
import com.google.firebase.messaging.FirebaseMessagingService
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class ChevitFirebaseMessagingService : FirebaseMessagingService() {
    @Inject
    lateinit var updatePushTokenUseCase: UpdatePushTokenUseCase

    private val processLifecycleScope by lazy {
        ProcessLifecycleOwner.get().lifecycleScope
    }

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        processLifecycleScope.launch {
            val param = UpdatePushTokenUseCase.Param(token)
            updatePushTokenUseCase(param)
        }
    }
}