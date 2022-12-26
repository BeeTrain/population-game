package app.view.map.model.generator

import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.graphics.painter.Painter
import app.extension.imageResource
import app.view.map.model.Cell
import app.view.map.model.CellLand
import app.view.map.model.CellSurroundings
import app.view.map.model.extension.randomLandPath

val Cell?.isWater: Boolean
    get() = this == Cell.WATER

val Cell?.isWaterOrNull: Boolean
    get() = this == Cell.WATER || this == null

fun randomWaterPath(): String {
    return Cell.WATER.randomLandPath()
}

private const val ooox = "land/water/border/ooox.png"
private const val ooxo = "land/water/border/ooxo.png"
private const val oxoo = "land/water/border/oxoo.png"
private const val xooo = "land/water/border/xooo.png"
private const val oxxx = "land/water/border/oxxx.png"
private const val ooxx = "land/water/border/ooxx.png"
private const val oxox = "land/water/border/oxox.png"
private const val xoxx = "land/water/border/xoxx.png"
private const val xoxo = "land/water/border/xoxo.png"
private const val xxox = "land/water/border/xxox.png"
private const val xxoo = "land/water/border/xxoo.png"
private const val xxxo = "land/water/border/xxxo.png"

fun generateWaterCellLand(surroundings: CellSurroundings): CellLand {
    return CellLand(
        top1 = surroundings.getTop1Land(),
        top2 = surroundings.getTop2Land(),
        bot1 = surroundings.getBot1Land(),
        bot2 = surroundings.getBot2Land()
    )
}

private fun CellSurroundings.getTop1Land(): Painter {
    val shouldUseRandom = left.isWaterOrNull && topleft.isWaterOrNull && top.isWaterOrNull
    return when {
        shouldUseRandom -> BitmapPainter(imageResource(randomWaterPath()))
        top == null && left.isWaterOrNull.not() -> BitmapPainter(imageResource(oxox))
        top.isWaterOrNull.not() && left == null -> BitmapPainter(imageResource(ooxx))
        !top.isWater && !left.isWater && topleft.isWaterOrNull -> BitmapPainter(imageResource(ooox))
        !left.isWater && !top.isWater && !topleft.isWater -> BitmapPainter(imageResource(ooox))
        left.isWater && top.isWater && !topleft.isWater -> BitmapPainter(imageResource(oxxx))
        !top.isWater -> BitmapPainter(imageResource(ooxx))
        left.isWaterOrNull -> BitmapPainter(imageResource(randomWaterPath()))
        !left.isWater -> BitmapPainter(imageResource(oxox))
        else -> BitmapPainter(imageResource(randomWaterPath()))
    }
}

private fun CellSurroundings.getTop2Land(): Painter {
    val shouldUseRandom = right.isWaterOrNull && topright.isWaterOrNull && top.isWaterOrNull
    return when {
        shouldUseRandom -> BitmapPainter(imageResource(randomWaterPath()))
        top == null && right.isWaterOrNull.not() -> BitmapPainter(imageResource(xoxo))
        top.isWaterOrNull.not() && right == null -> BitmapPainter(imageResource(ooxx))
        !top.isWater && !right.isWater && topright.isWaterOrNull -> BitmapPainter(imageResource(ooxo))
        !top.isWater && !right.isWater && !topright.isWater -> BitmapPainter(imageResource(ooxo))
        top.isWater && right.isWater && !topright.isWater -> BitmapPainter(imageResource(xoxx))
        !top.isWater -> BitmapPainter(imageResource(ooxx))
        right.isWaterOrNull -> BitmapPainter(imageResource(randomWaterPath()))
        !right.isWater -> BitmapPainter(imageResource(xoxo))
        else -> BitmapPainter(imageResource(randomWaterPath()))
    }
}

private fun CellSurroundings.getBot1Land(): Painter {
    val shouldUseRandom = left.isWaterOrNull && botleft.isWaterOrNull && bot.isWaterOrNull
    return when {
        shouldUseRandom -> BitmapPainter(imageResource(randomWaterPath()))
        bot == null && left.isWaterOrNull.not() -> BitmapPainter(imageResource(oxox))
        bot.isWaterOrNull.not() && left == null -> BitmapPainter(imageResource(xxoo))
        !bot.isWater && !left.isWater && botleft.isWaterOrNull -> BitmapPainter(imageResource(oxoo))
        !bot.isWater && !left.isWater && !botleft.isWater -> BitmapPainter(imageResource(oxoo))
        bot.isWater && left.isWater && !botleft.isWater -> BitmapPainter(imageResource(xxox))
        !bot.isWater -> BitmapPainter(imageResource(xxoo))
        left.isWaterOrNull -> BitmapPainter(imageResource(randomWaterPath()))
        !left.isWater -> BitmapPainter(imageResource(oxox))
        else -> BitmapPainter(imageResource(randomWaterPath()))
    }
}

private fun CellSurroundings.getBot2Land(): Painter {
    val shouldUseRandom = right.isWaterOrNull && botright.isWaterOrNull && bot.isWaterOrNull
    return when {
        shouldUseRandom -> BitmapPainter(imageResource(randomWaterPath()))
        bot == null && right.isWaterOrNull.not() -> BitmapPainter(imageResource(xoxo))
        bot.isWaterOrNull.not() && right == null -> BitmapPainter(imageResource(xxoo))
        !bot.isWater && !right.isWater && botright.isWaterOrNull -> BitmapPainter(imageResource(xooo))
        !bot.isWater && !right.isWater && !botright.isWater -> BitmapPainter(imageResource(xooo))
        bot.isWater && right.isWater && !botright.isWater -> BitmapPainter(imageResource(xxxo))
        !bot.isWater -> BitmapPainter(imageResource(xxoo))
        right.isWaterOrNull -> BitmapPainter(imageResource(randomWaterPath()))
        !right.isWater -> BitmapPainter(imageResource(xoxo))
        else -> BitmapPainter(imageResource(randomWaterPath()))
    }
}