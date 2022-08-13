package app.state

import androidx.compose.runtime.mutableStateOf
import app.extension.update

class InfoWindowState {

    var isVisible = mutableStateOf(true)
    var text = mutableStateOf("")

    fun toggleIconClick() {
        isVisible.update(isVisible.value.not())
    }

    fun addLog(message: String) {
        val newValue = (text.value + message + "\n")
        text.update(newValue)
    }

    fun clearLog() {
        text.update("")
    }
}