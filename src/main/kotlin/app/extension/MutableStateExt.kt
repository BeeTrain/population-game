package app.extension

import androidx.compose.runtime.MutableState

fun <T> MutableState<T>.update(newValue: T) {
    value = newValue
}