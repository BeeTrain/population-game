package app.view.map.model

import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.graphics.painter.Painter
import app.extension.imageResource
import app.view.map.land.randomAshPath
import app.view.map.land.randomGrassPath
import app.view.map.land.randomGroundPath
import app.view.map.land.randomSandsPath
import app.view.map.land.randomSnowPath
import app.view.map.land.randomStonesPath
import app.view.map.land.randomSwampPath
import app.view.map.land.randomWaterPath

private const val PADDING = 0.2

data class MapModel(
    val height: Int = MapConfig.mapHeight,
    val width: Int = MapConfig.mapWidth,
    val cellSize: Int = MapConfig.cellSize,
    val cells: List<Cell> = prepareCells(width, height)
) {

    val widthPaddings = width * PADDING
    val heightPaddings = height * PADDING
    val viewWidth = width * cellSize + widthPaddings
    val viewHeight = height * cellSize + heightPaddings

    fun getCell(column: Int, index: Int): Cell {
        val cellIndex = column * height + index
        return cells[cellIndex]
    }

    fun getCellImage(column: Int, index: Int): Painter {
        val cell = getCell(column, index)

        val path = when (cell.cellType) {
            CellType.GROUND -> randomGroundPath()
            CellType.GRASS -> randomGrassPath()
            CellType.STONES -> randomStonesPath()
            CellType.SNOW -> randomSnowPath()
            CellType.SWAMP -> randomSwampPath()
            CellType.ASH -> randomAshPath()
            CellType.WATER -> randomWaterPath()
            CellType.SAND -> randomSandsPath()
        }

        return BitmapPainter(imageResource(path))
    }
}

private fun prepareCells(width: Int, height: Int): List<Cell> {
    return List(width * height) {
        Cell(it)
    }
}