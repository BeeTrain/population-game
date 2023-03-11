package app.state

import androidx.compose.runtime.mutableStateOf
import app.extension.update
import app.model.building.Building
import app.view.map.model.Map

class GameState {

    var lifecycle = PopulationLifecycle()
        private set

    val mapState = mutableStateOf(createMap())

    val lifecycleStatusState = mutableStateOf(lifecycle.getLifecycleStatus())

    val selectedBuilding = mutableStateOf<Building?>(null)

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

    fun build(): Building? {
        val building = selectedBuilding.value
        selectedBuilding.update { null }

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