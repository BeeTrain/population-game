package app.extension

import app.state.AppState

fun addLog(message: String) {
    AppState.infoWindow.addLog(message)
}