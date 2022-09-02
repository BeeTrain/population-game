package app.view.map.model

import androidx.compose.ui.graphics.painter.BitmapPainter
import app.extension.imageResource

private const val PADDING = 0.2

data class MapModel(
    val height: Int = MapConfig.mapHeight,
    val width: Int = MapConfig.mapWidth,
    val cellSize: Int = MapConfig.cellSize
) {
    val columns = prepareColumns()
    val rows = prepareRows()

    val widthPaddings = width * PADDING
    val heightPaddings = height * PADDING
    val viewWidth = width * cellSize + widthPaddings
    val viewHeight = height * cellSize + heightPaddings

    private fun prepareColumns(): List<Int> {
        return when {
            height <= 0 -> emptyList()
            else -> List(height) { it }
        }
    }

    private fun prepareRows(): List<MapRow> {
        return when {
            height <= 0 -> emptyList()
            else -> List(height) { MapRow(it, List(width) { Cell(it, randomImage()) }) }
        }
    }
}

data class MapRow(val index: Int, val cells: List<Cell>)

data class Cell(val index: Int, val value: BitmapPainter)

val lands = listOf(
    BitmapPainter(imageResource("land/wood.png")),
    BitmapPainter(imageResource("land/wood.png")),
    BitmapPainter(imageResource("land/wood.png")),
    BitmapPainter(imageResource("land/ground.png")),
    BitmapPainter(imageResource("land/ground.png")),
    BitmapPainter(imageResource("land/ground.png")),
    BitmapPainter(imageResource("land/ground.png")),
    BitmapPainter(imageResource("land/ground.png")),
    BitmapPainter(imageResource("land/ground.png")),
    BitmapPainter(imageResource("land/ground.png")),
    BitmapPainter(imageResource("land/ground.png")),
    BitmapPainter(imageResource("land/ground.png")),
    BitmapPainter(imageResource("land/ground.png")),
    BitmapPainter(imageResource("land/water.png"))
)

fun randomImage(): BitmapPainter {
    return lands.random()
}