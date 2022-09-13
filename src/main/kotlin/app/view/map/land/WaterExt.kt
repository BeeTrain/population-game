package app.view.map.land

import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.graphics.painter.Painter
import app.extension.imageResource
import app.view.map.model.CellLand
import app.view.map.model.CellSurroundings
import app.view.map.model.CellType
import app.view.map.model.isWater
import app.view.map.model.isWaterOrNull

val water = listOf(
    "land/water/watrtl21.png",
    "land/water/watrtl22.png",
    "land/water/watrtl23.png",
    "land/water/watrtl24.png",
    "land/water/watrtl25.png",
    "land/water/watrtl26.png",
    "land/water/watrtl27.png",
    "land/water/watrtl28.png",
    "land/water/watrtl29.png",
    "land/water/watrtl30.png",
    "land/water/watrtl31.png",
    "land/water/watrtl32.png",
    "land/water/watrtl33.png",
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
        left.isWater && top.isWater && !topleft.isWater -> BitmapPainter(imageResource("land/water/tobeach/bwww.png"))
        !top.isWater -> BitmapPainter(imageResource("land/water/tobeach/bbww.png"))
        left.isWaterOrNull -> BitmapPainter(imageResource(randomWaterPath()))
        !left.isWater -> BitmapPainter(imageResource("land/water/tobeach/bwbw.png"))
        else -> BitmapPainter(imageResource(randomWaterPath()))
    }
}

private fun getTop2Land(surroundings: CellSurroundings): Painter {
    val right = surroundings.right?.cellType
    val top = surroundings.top?.cellType
    val topright = surroundings.topright?.cellType

    return when {
        right.isWaterOrNull && topright.isWaterOrNull && top.isWaterOrNull -> BitmapPainter(imageResource(randomWaterPath()))
        right.isWater && top.isWater && !topright.isWater -> BitmapPainter(imageResource("land/water/tobeach/wbww.png"))
        !top.isWater -> BitmapPainter(imageResource("land/water/tobeach/bbww.png"))
        right.isWaterOrNull -> BitmapPainter(imageResource(randomWaterPath()))
        !right.isWater -> BitmapPainter(imageResource("land/water/tobeach/wbwb.png"))
        else -> BitmapPainter(imageResource(randomWaterPath()))
    }
}

private fun getBot1Land(surroundings: CellSurroundings): Painter {
    val left = surroundings.left?.cellType
    val bot = surroundings.bot?.cellType
    val botleft = surroundings.botleft?.cellType

    return when {
        left.isWaterOrNull && botleft.isWaterOrNull && bot.isWaterOrNull -> BitmapPainter(imageResource(randomWaterPath()))
        left.isWater && bot.isWater && !botleft.isWater -> BitmapPainter(imageResource("land/water/tobeach/wwbw.png"))
        !bot.isWater -> BitmapPainter(imageResource("land/water/tobeach/wwbb.png"))
        left.isWaterOrNull -> BitmapPainter(imageResource(randomWaterPath()))
        !left.isWater -> BitmapPainter(imageResource("land/water/tobeach/bwbw.png"))
        else -> BitmapPainter(imageResource(randomWaterPath()))
    }
}

private fun getBot2Land(surroundings: CellSurroundings): Painter {
    val right = surroundings.right?.cellType
    val bot = surroundings.bot?.cellType
    val botright = surroundings.botright?.cellType

    return when {
        right.isWaterOrNull && botright.isWaterOrNull && bot.isWaterOrNull -> BitmapPainter(imageResource(randomWaterPath()))
        right.isWater && bot.isWater && !botright.isWater -> BitmapPainter(imageResource("land/water/tobeach/wwwb.png"))
        !bot.isWater -> BitmapPainter(imageResource("land/water/tobeach/wwbb.png"))
        right.isWaterOrNull -> BitmapPainter(imageResource(randomWaterPath()))
        !right.isWater -> BitmapPainter(imageResource("land/water/tobeach/wbwb.png"))
        else -> BitmapPainter(imageResource(randomWaterPath()))
    }
}