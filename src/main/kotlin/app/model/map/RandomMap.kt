package app.model.map

import app.extension.random
import app.view.map.model.Cell

class RandomMap(
    private val width: Int,
    private val height: Int
) : GameMap {

    override fun generate(): List<Cell> {
        return List(width * height) {
            random(Cell.WATER, Cell.GRASS)
        }
    }
}