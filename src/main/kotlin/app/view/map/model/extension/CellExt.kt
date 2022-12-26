package app.view.map.model.extension

import androidx.compose.ui.graphics.painter.BitmapPainter
import app.extension.imageResource
import app.view.map.model.Cell
import app.view.map.model.CellLand
import app.view.map.model.CellSurroundings
import app.view.map.model.generator.generateWaterCellLand

fun Cell.cellLand(surroundings: CellSurroundings): CellLand {
    return when (this) {
        Cell.WATER -> generateWaterCellLand(surroundings)
        else -> CellLand(
            top1 = BitmapPainter(imageResource(randomLandPath())),
            top2 = BitmapPainter(imageResource(randomLandPath())),
            bot1 = BitmapPainter(imageResource(randomLandPath())),
            bot2 = BitmapPainter(imageResource(randomLandPath()))
        )
    }
}

fun Cell.randomLandPath(): String {
    return "land/${defaultPath()}"
}