package app.extension

import androidx.compose.runtime.MutableState

fun <T> MutableState<T>.update(block: (T) -> T) {
    value = block.invoke(value)
}