package app.state

import androidx.compose.runtime.mutableStateOf
import app.extension.update

class GameState {

    var lifecycle = PopulationLifecycle()
        private set

    val lifecycleStatusState = mutableStateOf(lifecycle.getLifecycleStatus())

    fun restartGame() {
        lifecycle = PopulationLifecycle()
        updateStates()
        AppState.infoWindow.clearLog()
    }

    fun runCycle() {
        lifecycle.runCycle()
        updateStates()
    }

    private fun updateStates() {
        lifecycleStatusState.update { lifecycle.getLifecycleStatus() }
    }
}