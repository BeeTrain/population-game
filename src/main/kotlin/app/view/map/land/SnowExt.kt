package app.view.map.land

import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.graphics.painter.Painter
import app.extension.imageResource
import app.view.map.model.CellLand
import app.view.map.model.CellSurroundings
import app.view.map.model.isSand
import app.view.map.model.isSnow
import app.view.map.model.isWater

val snow = listOf(
    "land/snow/000.png",
    "land/snow/001.png",
    "land/snow/002.png",
    "land/snow/003.png",
    "land/snow/004.png",
    "land/snow/005.png",
)

fun randomSnowPath(): String {
    return snow.random()
}

fun getSnowLand(surroundings: CellSurroundings): CellLand {
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
        top.isSnow && left.isSnow -> BitmapPainter(imageResource(randomSnowPath()))
        // water
        left.isWater && top.isWater -> BitmapPainter(imageResource("land/snow/sand/ooox.png"))
        top.isWater -> BitmapPainter(imageResource("land/snow/sand/ooxx.png"))
        left.isWater -> BitmapPainter(imageResource("land/snow/sand/oxox.png"))
        //sand
        left.isSand && top.isSand -> BitmapPainter(imageResource("land/snow/sand/ooox.png"))
        top.isSand -> BitmapPainter(imageResource("land/snow/sand/ooxx.png"))
        left.isSand -> BitmapPainter(imageResource("land/snow/sand/oxox.png"))
        else -> BitmapPainter(imageResource(randomSnowPath()))
    }
}

private fun getTop2Land(surroundings: CellSurroundings): Painter {
    val right = surroundings.right?.cellType
    val top = surroundings.top?.cellType
    val topright = surroundings.topright?.cellType

    return when {
        top.isSnow && right.isSnow -> BitmapPainter(imageResource(randomSnowPath()))
        // water
        right.isWater && top.isWater -> BitmapPainter(imageResource("land/snow/sand/ooxo.png"))
        top.isWater -> BitmapPainter(imageResource("land/snow/sand/ooxx.png"))
        right.isWater -> BitmapPainter(imageResource("land/snow/sand/xoxo.png"))
        // sand
        right.isSand && top.isSand -> BitmapPainter(imageResource("land/snow/sand/ooxo.png"))
        top.isSand -> BitmapPainter(imageResource("land/snow/sand/ooxx.png"))
        right.isSand -> BitmapPainter(imageResource("land/snow/sand/xoxo.png"))
        else -> BitmapPainter(imageResource(randomSnowPath()))
    }
}

private fun getBot1Land(surroundings: CellSurroundings): Painter {
    val bot = surroundings.bot?.cellType
    val left = surroundings.left?.cellType
    val botleft = surroundings.botleft?.cellType

    return when {
        bot.isSnow && left.isSnow -> BitmapPainter(imageResource(randomSnowPath()))
        // water
        left.isWater && bot.isWater -> BitmapPainter(imageResource("land/snow/sand/oxoo.png"))
        bot.isWater -> BitmapPainter(imageResource("land/snow/sand/xxoo.png"))
        left.isWater -> BitmapPainter(imageResource("land/snow/sand/oxox.png"))
        // sand
        left.isSand && bot.isSand -> BitmapPainter(imageResource("land/snow/sand/oxoo.png"))
        bot.isSand -> BitmapPainter(imageResource("land/snow/sand/xxoo.png"))
        left.isSand -> BitmapPainter(imageResource("land/snow/sand/oxox.png"))
        else -> BitmapPainter(imageResource(randomSnowPath()))
    }
}

private fun getBot2Land(surroundings: CellSurroundings): Painter {
    val bot = surroundings.bot?.cellType
    val right = surroundings.right?.cellType
    val botright = surroundings.botright?.cellType

    return when {
        bot.isSnow && right.isSnow -> BitmapPainter(imageResource(randomSnowPath()))
        // water
        right.isWater && bot.isWater -> BitmapPainter(imageResource("land/snow/sand/xooo.png"))
        bot.isWater -> BitmapPainter(imageResource("land/snow/sand/xxoo.png"))
        right.isWater -> BitmapPainter(imageResource("land/snow/sand/xoxo.png"))
        // sand
        right.isSand && bot.isSand -> BitmapPainter(imageResource("land/snow/sand/xooo.png"))
        bot.isSand -> BitmapPainter(imageResource("land/snow/sand/xxoo.png"))
        right.isSand -> BitmapPainter(imageResource("land/snow/sand/xoxo.png"))
        else -> BitmapPainter(imageResource(randomSnowPath()))
    }
}