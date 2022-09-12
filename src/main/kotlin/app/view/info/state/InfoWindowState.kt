package app.view.info.state

import androidx.compose.runtime.mutableStateOf
import app.extension.update

class InfoWindowState {

    var isVisible = mutableStateOf(true)
    var text = mutableStateOf("")

    fun toggleIconClick() {
        isVisible.update { it.not() }
    }

    fun addLog(message: String) {
        text.update { "${it}${message}\n" }
    }

    fun clearLog() {
        text.update { "" }
    }
}