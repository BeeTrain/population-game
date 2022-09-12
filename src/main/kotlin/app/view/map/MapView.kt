package app.view.map

import androidx.compose.foundation.Image
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
import app.view.map.model.randomBuilding
import app.view.toast.state.showToast
import kotlin.math.roundToInt

@Composable
fun BoxScope.MapView() {
    val state = AppState.mapViewState
    val mapModel by remember { AppState.mapViewState.mapModel }
    val cells by remember { AppState.mapViewState.cells }
    val keys = remember { state.cellsKeys }

    val offsetX by remember { state.offsetX }
    val offsetY by remember { state.offsetY }

    println("map recomposed")
    LazyColumn(
        modifier = Modifier
            .offset { IntOffset(offsetX.roundToInt(), offsetY.roundToInt()) }
            .align(Alignment.TopStart)
            .requiredSize(mapModel.viewWidth.dp, mapModel.viewHeight.dp)
            .onGloballyPositioned { coordinates -> state.size.update { coordinates.size } }
            .pointerInput(Unit) {
                detectDragGestures { change, dragAmount ->
                    change.consumeAllChanges()
                    state.offsetX.update { offsetX + dragAmount.x }
                    state.offsetY.update { offsetY + dragAmount.y }
                    println("${state.offsetX.value}, ${state.offsetY.value}")
                }
            }
    ) {
        val rows = cells.chunked(state.mapModel.value.width)
        itemsIndexed(rows) { rowIndex, row ->
            LazyRow {
                itemsIndexed(items = row) { cellIndex, cell ->
                    val listIndex = rowIndex * mapModel.width + cellIndex
                    val key = remember { keys[listIndex] }
                    key(key) {
                        println("cell[${rowIndex + 1}, ${cellIndex + 1}] recomposed")
                        Box(
                            modifier = Modifier
                                .size(35.dp)
                                .clickable {
                                    key.update { it.copy(building = randomBuilding()) }
                                    showToast("[${rowIndex + 1}, ${cellIndex + 1}]")
                                }
                        ) {
                            Image(
                                painter = cell.land,
                                contentDescription = "",
                                modifier = Modifier
                                    .align(Alignment.Center)
                                    .size(mapModel.cellSize.dp)
                            )
                            if (key.value.building.isNotEmpty()) {
                                Text(
                                    text = key.value.building,
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