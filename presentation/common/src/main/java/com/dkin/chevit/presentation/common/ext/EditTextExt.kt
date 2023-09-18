package com.dkin.chevit.presentation.common.ext

import android.content.Context
import android.text.InputFilter
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import com.dkin.chevit.core.mvi.ViewIntent
import com.google.android.material.textfield.TextInputLayout
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.sample
import kotlinx.coroutines.launch

inline fun <reified T : ViewIntent> EditText.dispatchIntentOnTextChanged(action: Pair<(String) -> T, (T) -> Unit>) {
    doOnTextChanged { text, _, _, _ ->
        text?.toString()?.let(action.first)?.let(action.second)
    }
}

inline fun <reified T : ViewIntent> TextInputLayout.dispatchIntentOnTextChanged(action: Pair<(String) -> T, (T) -> Unit>) {
    editText?.doOnTextChanged { text, _, _, _ ->
        text?.toString()?.let(action.first)?.let(action.second)
    }
}

inline fun TextInputLayout.doOnTextChanged(crossinline action: (String) -> Unit) {
    editText?.doOnTextChanged { text, _, _, _ -> text?.toString()?.let(action) }
}

fun EditText.setTextIfNewWithSelection(text: CharSequence) {
    val oldText = this.text?.toString() ?: ""
    if (text.toString() != oldText) {
        setText(text)
        text.length.takeIf { it.isPositive() }?.let(::setSelection)
    }
}

fun TextInputLayout.setTextIfNewWithSelection(text: CharSequence) {
    editText?.setTextIfNewWithSelection(text)
}

@FlowPreview
@ExperimentalCoroutinesApi
fun EditText.debounce(
    scope: CoroutineScope,
    duration: Long,
    watchAction: (CharSequence) -> Unit,
) {
    textChanges()
        .debounce(duration)
        .filterNotNull()
        .onEach { watchAction(it) }
        .launchIn(scope)
}

@FlowPreview
@ExperimentalCoroutinesApi
fun EditText.typing(
    scope: CoroutineScope,
    watchAction: (Boolean) -> Unit,
) {
    var job: Job? = null
    var isTyping = false
    doAfterTextChanged {
        job?.cancel()
        job =
            scope.launch {
                if (!isTyping) {
                    isTyping = true
                    watchAction(true)
                }
                delay(1000L)
                isTyping = false
                watchAction(false)
            }
    }
}

@FlowPreview
@ExperimentalCoroutinesApi
fun EditText.sample(
    scope: CoroutineScope,
    duration: Long,
    watcherAction: (CharSequence) -> Unit,
) {
    textChanges()
        .sample(duration)
        .filterNotNull()
        .onEach { watcherAction(it) }
        .launchIn(scope)
}

@ExperimentalCoroutinesApi
private fun EditText.textChanges(): Flow<CharSequence?> {
    return callbackFlow {
        val listener = doOnTextChanged { text, _, _, _ -> trySend(text) }
        addTextChangedListener(listener)
        awaitClose { removeTextChangedListener(listener) }
    }
}

fun EditText.showKeyboard() {
    requestFocus()
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.showSoftInput(this, InputMethodManager.SHOW_FORCED)
}

fun EditText.hideKeyboard() {
    clearFocus()
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(windowToken, 0)
}

fun EditText.readOnly() {
    isFocusable = false
    isFocusableInTouchMode = false
}

fun EditText.maxLength(length: Int) =
    apply {
        filters = arrayOf(InputFilter.LengthFilter(length))
    }
