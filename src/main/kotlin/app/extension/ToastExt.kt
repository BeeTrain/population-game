package app.extension

import app.state.AppState

fun showToast(text: String) {
    AppState.toastText.update(text)
    AppState.isToastVisible.update(true)
}

fun hideToast() {
    AppState.isToastVisible.update(false)
}