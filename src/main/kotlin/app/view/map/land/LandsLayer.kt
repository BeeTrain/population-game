package app.view.map.land

import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import app.extension.update
import app.state.AppState
import kotlin.math.roundToInt

@Composable
fun BoxScope.LandsLayer() {
    val state by remember { AppState.game.mapState }

    LazyColumn(
        modifier = Modifier
            .offset { IntOffset(state.offsetX.value.roundToInt(), state.offsetY.value.roundToInt()) }
            .align(Alignment.TopStart)
            .requiredSize(state.mapWidth.dp, state.mapHeight.dp)
            .onGloballyPositioned { coordinates -> state.size.update { coordinates.size } }
            .pointerInput(state) {
                detectDragGestures { change, dragAmount ->
                    change.consume()
                    state.offsetX.update { it + dragAmount.x }
                    state.offsetY.update { it + dragAmount.y }
                }
            }
    ) {
        val rows = state.cells.chunked(state.cellsWidth)
        itemsIndexed(rows) { rowIndex, row ->
            LazyRow {
                itemsIndexed(items = row) { cellIndex, cell ->
                    val listIndex = rowIndex * state.cellsWidth + cellIndex
                    Box(
                        modifier = Modifier
                            .size(state.cellSize.dp),
                        content = { Land(state.getLand(listIndex, cell)) }
                    )
                }
            }
        }
    }
}