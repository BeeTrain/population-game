package app.view.map.model

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.unit.IntSize
import app.view.map.model.extension.NO_BUILDING
import app.view.map.model.extension.cellLand

private const val MAP_SIZE_S = 10
private const val MAP_SIZE_M = 20
private const val MAP_SIZE_L = 30

private const val DEFAULT_CELL_SIZE = 35
private const val CELL_PADDING = 0.2

class Map(
    val cellsWidth: Int = MAP_SIZE_S,
    val cellsHeight: Int = cellsWidth,
    val cellSize: Int = DEFAULT_CELL_SIZE,
    val cells: List<Cell> = createMapCells(cellsWidth, cellsHeight),
    val buildings: MutableState<List<String>> = mutableStateOf(createMapBuildings(cells))
) {

    var offsetX = mutableStateOf(0f)
    var offsetY = mutableStateOf(0f)
    var size = mutableStateOf(IntSize(0, 0))

    val mapWidth = cellsWidth * cellSize + CELL_PADDING
    val mapHeight = cellsHeight * cellSize + CELL_PADDING

    val buildingsKeys = mutableMapOf<Int, MutableState<String>>()

    fun getSurroundings(index: Int): CellSurroundings {
        val width = cellsWidth
        val row = index / width

        val leftIndex = if (((index - 1) / width) < row) {
            -1
        } else {
            index - 1
        }
        val rightIndex = if (((index + 1) / width) > row) {
            -1
        } else {
            index + 1
        }
        val topLeftIndex = if (leftIndex == -1) {
            -1
        } else {
            index - width - 1
        }
        val topRightIndex = if (rightIndex == -1) {
            -1
        } else {
            index - width + 1
        }
        val botLeftIndex = if (leftIndex == -1) {
            -1
        } else {
            index + width - 1
        }
        val botRightIndex = if (rightIndex == -1) {
            -1
        } else {
            index + width + 1
        }

        return CellSurroundings(
            top = getCell(index - width),
            bot = getCell(index + width),
            left = getCell(leftIndex),
            right = getCell(rightIndex),
            topleft = getCell(topLeftIndex),
            topright = getCell(topRightIndex),
            botleft = getCell(botLeftIndex),
            botright = getCell(botRightIndex),
        )
    }

    fun getCell(index: Int): Cell? {
        if (index < 0) return null
        if (index > cellsWidth * cellsHeight - 1) return null

        return cells[index]
    }

    fun getLand(index: Int, cell: Cell): CellLand {
        val surroundings = getSurroundings(index)

        return cell.cellLand(surroundings)
    }
}

private fun createMapBuildings(cells: List<Cell>): List<String> {
    return List(cells.size) { NO_BUILDING }
}