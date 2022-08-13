package app.state

import androidx.compose.runtime.mutableStateOf

object AppState {

    val game = GameState()

    var isInfoWindowVisible = mutableStateOf(true)
    var infoWindowText = mutableStateOf("")

    var isToastVisible = mutableStateOf(false)
    var toastText = mutableStateOf("")
}