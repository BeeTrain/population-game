package app.view.toast.state

import androidx.compose.runtime.mutableStateOf
import app.extension.update
import app.state.AppState
import java.util.Timer
import kotlin.concurrent.schedule

private const val DEFAULT_DURATION = 1000L

class ToastState {

    var isVisible = mutableStateOf(false)
    var text = mutableStateOf("")

    fun show(message: String, millis: Long = DEFAULT_DURATION) {
        text.update(message)
        isVisible.update(true)
        Timer().schedule(millis) { hide() }
    }

    private fun hide() {
        isVisible.update(false)
    }
}

fun showToast(message: String, duration: Long = DEFAULT_DURATION) {
    AppState.toast.show(message, duration)
}