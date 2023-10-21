package com.dkin.chevit.data.provider

import com.dkin.chevit.domain.base.CoroutineDispatcherProvider
import com.dkin.chevit.domain.provider.TokenProvider
import com.google.firebase.auth.FirebaseAuth
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.suspendCancellableCoroutine

internal class TokenProviderImpl @Inject constructor(
    private val coroutineDispatcherProvider: CoroutineDispatcherProvider,
    private val auth: FirebaseAuth
) : TokenProvider {
    override fun getFirebaseToken(): String = runBlocking(coroutineDispatcherProvider.io) {
        suspendCancellableCoroutine { continuation ->
            val currentUser = auth.currentUser
            if (currentUser != null) {
                currentUser.getIdToken(true)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            val token = task.result?.token
                            continuation.resume(token ?: "")
                        } else {
                            continuation.resume("")
                        }
                    }
            } else {
                continuation.resume("")
            }
        }
    }
}
