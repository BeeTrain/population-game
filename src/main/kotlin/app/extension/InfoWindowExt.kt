package app.extension

import app.state.AppState

fun addLog(text: String) {
    val newValue = (AppState.infoWindowText.value + text + "\n")
    AppState.infoWindowText.update(newValue)
}

fun clearLog() {
    AppState.infoWindowText.update("")
}