package app.view.map.model.extension

import app.view.map.model.Cell
import app.view.map.model.CellLand
import app.view.map.model.CellSurroundings
import app.view.map.model.generator.generateLand
import app.view.map.model.generator.generateWaterCellLand

fun Cell.cellLand(surroundings: CellSurroundings): CellLand {
    return when (this) {
        Cell.WATER -> generateWaterCellLand(surroundings)
        else -> generateLand(surroundings)
    }
}

fun Cell.randomLandPath(): String {
    return "land/${defaultPath()}"
}