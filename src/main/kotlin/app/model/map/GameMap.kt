package app.model.map

import app.view.map.model.Cell

sealed interface GameMap {

    fun generate(): List<Cell>
}