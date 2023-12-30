package com.dkin.chevit.presentation.auth.signin

import android.app.PendingIntent
import android.content.Intent
import android.widget.Toast
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts.StartIntentSenderForResult
import androidx.fragment.app.viewModels
import com.dkin.chevit.core.mvi.MVIFragment
import com.dkin.chevit.presentation.auth.R
import com.dkin.chevit.presentation.auth.databinding.FragmentSignInBinding
import com.dkin.chevit.presentation.auth.signin.SignInEffect.NavigateHome
import com.dkin.chevit.presentation.auth.signin.SignInEffect.NavigateSignUp
import com.dkin.chevit.presentation.auth.signin.SignInEffect.ShowSignInFailed
import com.dkin.chevit.presentation.common.DefaultWebClientIdAnnotation
import com.dkin.chevit.presentation.deeplink.DeepLink
import com.dkin.chevit.presentation.deeplink.deepLink
import com.google.android.gms.auth.api.identity.GetSignInIntentRequest
import com.google.android.gms.auth.api.identity.Identity
import com.google.android.gms.auth.api.identity.SignInClient
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SignIn : MVIFragment<FragmentSignInBinding, SignInIntent, SignInState, SignInEffect>(
    FragmentSignInBinding::inflate,
) {
    @DefaultWebClientIdAnnotation
    @Inject
    lateinit var defaultWebClientId: String

    @Inject
    lateinit var auth: FirebaseAuth

    override val viewModel: SignInViewModel by viewModels()

    private val signInRequest: GetSignInIntentRequest by lazy {
        GetSignInIntentRequest.builder()
            .setServerClientId(defaultWebClientId)
            .build()
    }

    private val signInClient: SignInClient by lazy {
        Identity.getSignInClient(requireContext())
    }

    private val signInLauncher =
        registerForActivityResult(StartIntentSenderForResult()) { result ->
            handleSignInResult(result.data)
        }

    private fun handleSignInResult(data: Intent?) {
        runCatching {
            val googleCredential = signInClient.getSignInCredentialFromIntent(data)
            val idToken = googleCredential.googleIdToken
            requireNotNull(idToken)
            val credential = GoogleAuthProvider.getCredential(idToken, null)
            auth.signInWithCredential(credential).addOnCompleteListener(requireActivity()) {
                setIntent(SignInIntent.SignInSuccess)
            }
        }.onFailure {
            setIntent(SignInIntent.SignInFailure(it))
        }
    }

    override fun initView() =
        binding {
            btnSignInGoogle.setOnClickListener {
                signInClient.getSignInIntent(signInRequest)
                    .addOnSuccessListener { pendingIntent ->
                        launchSignIn(pendingIntent)
                    }
                    .addOnFailureListener { throwable ->
                        setIntent(SignInIntent.SignInFailure(throwable))
                    }
            }
        }

    private fun launchSignIn(pendingIntent: PendingIntent) =
        runCatching {
            val intentSenderRequest = IntentSenderRequest.Builder(pendingIntent).build()
            signInLauncher.launch(intentSenderRequest)
        }.onFailure { throwable ->
            setIntent(SignInIntent.SignInFailure(throwable))
        }

    override fun processState(state: SignInState) {
    }

    override fun processEffect(effect: SignInEffect) =
        when (effect) {
            NavigateHome ->
                deepLink(DeepLink.Home()) {
                    popUpTo(R.id.auth) { inclusive = false }
                }

            is NavigateSignUp ->
                deepLink(DeepLink.SignUp) {
                    popUpTo(R.id.auth) { inclusive = false }
                }

            ShowSignInFailed ->
                Toast.makeText(
                    requireContext(),
                    "Sign in failed",
                    Toast.LENGTH_SHORT,
                ).show()
        }
}
