package app.state

import androidx.compose.runtime.mutableStateOf

object AppState {

    val game = GameState()

    var isInfoWindowVisible = mutableStateOf(true)

    var populationStatusState = mutableStateOf(game.lifecycle.populationStatus())

}