package app.model.map

import app.view.map.model.Cell

class QuadIsland(
    private val width: Int,
    private val height: Int
) : GameMap {

    override fun generate(): List<Cell> {
        return List(width * height) { index ->
            val x = index / height
            val y = index % width
            when {
                x == 0 || x == height - 1 -> Cell.WATER
                y == 0 || y == width - 1 -> Cell.WATER
                else -> Cell.GRASS
            }
        }
    }
}