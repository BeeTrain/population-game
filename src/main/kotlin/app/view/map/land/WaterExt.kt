package app.view.map.land

import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.graphics.painter.Painter
import app.extension.imageResource
import app.view.map.model.CellLand
import app.view.map.model.CellSurroundings
import app.view.map.model.isWater
import app.view.map.model.isWaterOrNull

val water = listOf(
    "land/water/000.png",
    "land/water/001.png",
    "land/water/002.png",
    "land/water/003.png",
    "land/water/004.png",
    "land/water/005.png",
)

fun randomWaterPath(): String {
    return water.random()
}

fun getWaterLand(surroundings: CellSurroundings): CellLand {
    return CellLand(
        top1 = getTop1Land(surroundings),
        top2 = getTop2Land(surroundings),
        bot1 = getBot1Land(surroundings),
        bot2 = getBot2Land(surroundings)
    )
}

private fun getTop1Land(surroundings: CellSurroundings): Painter {
    val left = surroundings.left?.cellType
    val top = surroundings.top?.cellType
    val topleft = surroundings.topleft?.cellType

    return when {
        left.isWaterOrNull && topleft.isWaterOrNull && top.isWaterOrNull -> BitmapPainter(imageResource(randomWaterPath()))
        left.isWater && top.isWater && !topleft.isWater -> BitmapPainter(imageResource("land/water/border/oxxx.png"))
        !top.isWater -> BitmapPainter(imageResource("land/water/border/ooxx.png"))
        left.isWaterOrNull -> BitmapPainter(imageResource(randomWaterPath()))
        !left.isWater -> BitmapPainter(imageResource("land/water/border/oxox.png"))
        else -> BitmapPainter(imageResource(randomWaterPath()))
    }
}

private fun getTop2Land(surroundings: CellSurroundings): Painter {
    val right = surroundings.right?.cellType
    val top = surroundings.top?.cellType
    val topright = surroundings.topright?.cellType

    return when {
        right.isWaterOrNull && topright.isWaterOrNull && top.isWaterOrNull -> BitmapPainter(imageResource(randomWaterPath()))
        right.isWater && top.isWater && !topright.isWater -> BitmapPainter(imageResource("land/water/border/xoxx.png"))
        !top.isWater -> BitmapPainter(imageResource("land/water/border/ooxx.png"))
        right.isWaterOrNull -> BitmapPainter(imageResource(randomWaterPath()))
        !right.isWater -> BitmapPainter(imageResource("land/water/border/xoxo.png"))
        else -> BitmapPainter(imageResource(randomWaterPath()))
    }
}

private fun getBot1Land(surroundings: CellSurroundings): Painter {
    val left = surroundings.left?.cellType
    val bot = surroundings.bot?.cellType
    val botleft = surroundings.botleft?.cellType

    return when {
        left.isWaterOrNull && botleft.isWaterOrNull && bot.isWaterOrNull -> BitmapPainter(imageResource(randomWaterPath()))
        left.isWater && bot.isWater && !botleft.isWater -> BitmapPainter(imageResource("land/water/border/xxox.png"))
        !bot.isWater -> BitmapPainter(imageResource("land/water/border/xxoo.png"))
        left.isWaterOrNull -> BitmapPainter(imageResource(randomWaterPath()))
        !left.isWater -> BitmapPainter(imageResource("land/water/border/oxox.png"))
        else -> BitmapPainter(imageResource(randomWaterPath()))
    }
}

private fun getBot2Land(surroundings: CellSurroundings): Painter {
    val right = surroundings.right?.cellType
    val bot = surroundings.bot?.cellType
    val botright = surroundings.botright?.cellType

    return when {
        right.isWaterOrNull && botright.isWaterOrNull && bot.isWaterOrNull -> BitmapPainter(imageResource(randomWaterPath()))
        right.isWater && bot.isWater && !botright.isWater -> BitmapPainter(imageResource("land/water/border/xxxo.png"))
        !bot.isWater -> BitmapPainter(imageResource("land/water/border/xxoo.png"))
        right.isWaterOrNull -> BitmapPainter(imageResource(randomWaterPath()))
        !right.isWater -> BitmapPainter(imageResource("land/water/border/xoxo.png"))
        else -> BitmapPainter(imageResource(randomWaterPath()))
    }
}