package app.state

import androidx.compose.runtime.mutableStateOf
import app.extension.update
import app.view.map.model.Map

class GameState {

    var lifecycle = PopulationLifecycle()
        private set

    val mapState = mutableStateOf(createMap())

    val lifecycleStatusState = mutableStateOf(lifecycle.getLifecycleStatus())

    val selectedBuilding = mutableStateOf("")

    fun restartGame() {
        lifecycle = PopulationLifecycle()
        mapState.update { createMap() }

        updateStates()
        AppState.infoWindow.clearLog()
    }

    fun runCycle() {
        lifecycle.runCycle()
        updateStates()
    }

    fun build(): String {
        val building = selectedBuilding.value
        selectedBuilding.update { "" }

        return building
    }

    private fun updateStates() {
        lifecycleStatusState.update { lifecycle.getLifecycleStatus() }
    }

    private fun createMap(): Map {
        return Map(
            cellsWidth = AppState.settings.mapSize.value.cells
        )
    }
}