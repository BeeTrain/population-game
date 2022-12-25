package app.view.map.model.extension

import androidx.compose.ui.graphics.painter.BitmapPainter
import app.extension.imageResource
import app.view.map.model.Cell
import app.view.map.model.CellLand
import app.view.map.model.CellSurroundings

val Cell?.isWater: Boolean
    get() = this == Cell.WATER

val Cell?.isWaterOrNull: Boolean
    get() = this == Cell.WATER || this == null

fun Cell.cellLand(surroundings: CellSurroundings): CellLand {
    return CellLand(
        top1 = BitmapPainter(imageResource(randomLandPath())),
        top2 = BitmapPainter(imageResource(randomLandPath())),
        bot1 = BitmapPainter(imageResource(randomLandPath())),
        bot2 = BitmapPainter(imageResource(randomLandPath()))
    )
}

fun Cell.randomLandPath(): String {
    return "land/${defaultPath()}"
}