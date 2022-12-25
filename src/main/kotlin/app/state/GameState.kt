package app.state

import androidx.compose.runtime.mutableStateOf
import app.extension.update
import app.view.map.model.Map

class GameState {

    var lifecycle = PopulationLifecycle()
        private set

    var mapState = mutableStateOf(Map())
        private set

    val lifecycleStatusState = mutableStateOf(lifecycle.getLifecycleStatus())

    fun restartGame() {
        lifecycle = PopulationLifecycle()
        mapState.update { Map() }

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