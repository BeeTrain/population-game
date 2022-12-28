package app.model.map

import app.view.map.model.Cell

class TwoIslands(
    private val width: Int,
    private val height: Int
) : GameMap {

    private val midIndices = getMidIndices()

    override fun generate(): List<Cell> {
        return List(width * height) { index ->
            val rowIndex = index % width

            when {
                midIndices.contains(rowIndex) -> Cell.WATER
                else -> Cell.GRASS
            }
        }
    }

    private fun getMidIndices(): List<Int> {
        val mid = width / 2
        return listOf(mid - 1, mid)
    }
}