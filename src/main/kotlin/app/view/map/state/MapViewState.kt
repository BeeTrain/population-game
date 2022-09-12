package app.view.map.state

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.unit.IntSize
import app.extension.update
import app.view.map.model.MapModel

class MapViewState {

    val mapModel = mutableStateOf(MapModel())
    val cells = mutableStateOf(mapModel.value.cells)
    val cellsKeys = cells.value.map { mutableStateOf(it) }
    var size = mutableStateOf(IntSize(0, 0))

    var offsetX = mutableStateOf(0f)
    var offsetY = mutableStateOf(0f)

    fun recreateMap() {
        mapModel.value = MapModel()
        cells.value = mapModel.value.cells
        cellsKeys.forEachIndexed { index, key ->
            key.update { cells.value[index] }
        }
    }
}