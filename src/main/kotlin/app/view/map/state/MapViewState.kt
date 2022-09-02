package app.view.map.state

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.unit.IntSize

class MapViewState {

    var size = mutableStateOf(IntSize(0, 0))

    var offsetX = mutableStateOf(0f)
    var offsetY = mutableStateOf(0f)
}