package app.view.buildings.state

import androidx.compose.runtime.mutableStateOf
import app.extension.update
import app.state.AppState

class BuildingsSelectorState {

    val isVisible = mutableStateOf(false)

    val selectedBuilding = mutableStateOf("")

    fun selectBuilding(building: String) {
        AppState.game.selectedBuilding.update { building }
        selectedBuilding.update { "" }
        isVisible.update { false }
    }
}