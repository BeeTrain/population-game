package app.extension

import androidx.compose.runtime.MutableState

fun <T> MutableState<T>.update(block: (T) -> T) {
    val newValue = block.invoke(value)
    if (newValue == value) return

    value = newValue
}