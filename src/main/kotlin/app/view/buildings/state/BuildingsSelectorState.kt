package app.view.buildings.state

import androidx.compose.runtime.mutableStateOf
import app.extension.update
import app.model.building.Building
import app.state.AppState

class BuildingsSelectorState {

    val isVisible = mutableStateOf(false)

    val selectedBuilding = mutableStateOf<Building?>(null)

    fun selectBuilding(building: Building) {
        AppState.game.selectedBuilding.update { building }
        selectedBuilding.update { null }
        isVisible.update { false }
    }
}