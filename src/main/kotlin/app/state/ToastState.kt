package app.state

import androidx.compose.runtime.mutableStateOf
import app.extension.update

class ToastState {

    var isVisible = mutableStateOf(false)
    var text = mutableStateOf("")

    fun show(message: String) {
        text.update(message)
        isVisible.update(true)
    }

    fun hide() {
        isVisible.update(false)
    }
}