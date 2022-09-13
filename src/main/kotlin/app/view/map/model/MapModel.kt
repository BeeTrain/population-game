package app.view.map.model

import app.view.map.extension.cellImage
import app.view.map.land.getAshLand
import app.view.map.land.getGroundLand
import app.view.map.land.getWaterLand

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

    fun getCell(index: Int): Cell? {
        if (index < 0) return null
        if (index > width * height - 1) return null

        return cells[index]
    }

    fun getLand(cell: Cell): CellLand {
        val surroundings = CellSurroundings(
            top = getCell(cell.index - width),
            bot = getCell(cell.index + width),
            left = getCell(cell.index - 1),
            right = getCell(cell.index + 1),
            topleft = getCell(cell.index - width - 1),
            topright = getCell(cell.index - width + 1),
            botleft = getCell(cell.index + width - 1),
            botright = getCell(cell.index + width + 1),
        )

        return when (cell.cellType) {
            CellType.GROUND -> getGroundLand(surroundings)
            CellType.WATER -> getWaterLand(surroundings)
            CellType.ASH -> getAshLand(surroundings)
            else -> CellLand(
                top1 = cellImage(cell.cellType),
                top2 = cellImage(cell.cellType),
                bot1 = cellImage(cell.cellType),
                bot2 = cellImage(cell.cellType)
            )
        }
    }
}

private fun prepareCells(width: Int, height: Int): List<Cell> {
    return List(width * height) {
        Cell(it)
    }
}