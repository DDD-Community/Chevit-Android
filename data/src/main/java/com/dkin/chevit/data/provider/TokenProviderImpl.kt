package com.dkin.chevit.data.provider

import com.dkin.chevit.domain.base.CoroutineDispatcherProvider
import com.dkin.chevit.domain.provider.TokenProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.crashlytics.FirebaseCrashlytics
import javax.inject.Inject
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withTimeout

internal class TokenProviderImpl @Inject constructor(
    private val coroutineDispatcherProvider: CoroutineDispatcherProvider,
    private val auth: FirebaseAuth
) : TokenProvider {
    override fun getFirebaseToken(): String = runBlocking(coroutineDispatcherProvider.io) {
        runCatching {
            withTimeout(1000) {
                auth.currentUser
                    ?.getIdToken(false)
                    ?.await()
                    ?.token
                    ?.takeIf { it.isNotBlank() } ?: ""
            }
        }.onFailure { throwable ->
            FirebaseCrashlytics.getInstance().recordException(throwable)
        }.getOrDefault("")
    }
}
