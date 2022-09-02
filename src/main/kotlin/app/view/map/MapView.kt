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
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.consumeAllChanges
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import app.extension.update
import app.state.AppState
import app.view.map.model.MapConfig
import app.view.map.model.MapModel
import app.view.toast.state.showToast
import kotlin.math.roundToInt

@Composable
fun BoxScope.MapView() {
    val state = AppState.mapViewState
    val mapModel = MapModel()
    val offsetX by remember { state.offsetX }
    val offsetY by remember { state.offsetY }

    LazyColumn(
        modifier = Modifier
            .offset { IntOffset(offsetX.roundToInt(), offsetY.roundToInt()) }
            .align(Alignment.TopStart)
            .requiredSize(mapModel.viewWidth.dp, mapModel.viewHeight.dp)
            .onGloballyPositioned { state.size.update(it.size) }
            .pointerInput(Unit) {
                detectDragGestures { change, dragAmount ->
                    change.consumeAllChanges()
                    val x = offsetX + dragAmount.x
                    val newX = when {
                        x < MapConfig.minX -> MapConfig.minX
                        x > MapConfig.maxX -> MapConfig.maxX
                        else -> x
                    }
                    val y = offsetY + dragAmount.y
                    val newY = when {
                        y < MapConfig.minY -> MapConfig.minY
                        y > MapConfig.maxY -> MapConfig.maxY
                        else -> y
                    }

                    state.offsetX.update(newX.toFloat())
                    state.offsetY.update(newY.toFloat())
                    println("${state.offsetX.value}, ${state.offsetY.value}")
                }
            }
    ) {
        items(items = mapModel.columns) { column ->
            LazyRow {
                items(items = mapModel.rows[column].cells) { cell ->
                    Box(
                        modifier = Modifier.size(35.dp)
                            .clickable { showToast("[${column + 1}, ${cell.index + 1}]") }
                    ) {
                        Image(
                            painter = cell.value,
                            contentDescription = "",
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                }
            }
        }
    }
}