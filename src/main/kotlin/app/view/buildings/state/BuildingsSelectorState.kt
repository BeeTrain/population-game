package app.view.buildings.state

import androidx.compose.runtime.mutableStateOf
import app.extension.update
import app.state.AppState

class BuildingsSelectorState {

    val isVisible = mutableStateOf(false)

    val selectedBuilding = mutableStateOf("")

    fun selectBuilding(building: String) {
        selectedBuilding.update { building }
        AppState.game.isBuildMode.update { building.isNotEmpty() }
    }

    fun build(): String {
        val building = selectedBuilding.value
        selectedBuilding.update { "" }
        AppState.game.isBuildMode.update { false }

        return building
    }
}