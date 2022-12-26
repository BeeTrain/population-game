package app.view.buildings

import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.consumeAllChanges
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.extension.update
import app.state.AppState
import app.view.map.model.extension.randomBuilding
import app.view.toast.state.showToast
import kotlin.math.roundToInt

@Composable
fun BoxScope.BuildingsView() {
    val state by remember { AppState.game.mapState }
    val buildings = state.buildings.value.map { mutableStateOf(it) }

    LazyColumn(
        modifier = Modifier
            .offset { IntOffset(state.offsetX.value.roundToInt(), state.offsetY.value.roundToInt()) }
            .align(Alignment.TopStart)
            .requiredSize(state.mapWidth.dp, state.mapHeight.dp)
            .onGloballyPositioned { coordinates -> state.size.update { coordinates.size } }
            .pointerInput(state) {
                detectDragGestures { change, dragAmount ->
                    change.consumeAllChanges()
                    state.offsetX.update { it + dragAmount.x }
                    state.offsetY.update { it + dragAmount.y }
                }
            }
    ) {
        val rows = buildings.chunked(state.cellsWidth)
        itemsIndexed(rows) { rowIndex, row ->
            LazyRow {
                itemsIndexed(items = row) { cellIndex, cell ->
                    val listIndex = rowIndex * state.cellsWidth + cellIndex
                    state.buildingsKeys[listIndex] = buildings[listIndex]
                    key(state.buildingsKeys[listIndex]) {
                        Box(
                            modifier = Modifier
                                .size(state.cellSize.dp)
                                .clickable {
                                    state.buildingsKeys[listIndex]?.update { randomBuilding() }
                                    showToast("[${rowIndex + 1}, ${cellIndex + 1}]")
                                }
                        ) {
                            if (state.buildingsKeys[listIndex]?.value?.isNotEmpty() == true) {
                                Text(
                                    text = state.buildingsKeys[listIndex]?.value.orEmpty(),
                                    fontSize = 22.sp,
                                    modifier = Modifier
                                        .align(Alignment.Center)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}