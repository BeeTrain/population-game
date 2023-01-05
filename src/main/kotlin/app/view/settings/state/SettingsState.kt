package app.view.settings.state

import androidx.compose.runtime.mutableStateOf
import app.extension.update
import app.model.game.MapSize

class SettingsState {

    val isVisible = mutableStateOf(false)

    val mapSize = mutableStateOf(MapSize.default())

    fun updateMapSize(newMapSize: MapSize) {
        mapSize.update { newMapSize }
    }
}