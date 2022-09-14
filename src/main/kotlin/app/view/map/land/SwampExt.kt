package app.view.map.land

import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.graphics.painter.Painter
import app.extension.imageResource
import app.view.map.model.CellLand
import app.view.map.model.CellSurroundings
import app.view.map.model.isSand
import app.view.map.model.isSwamp
import app.view.map.model.isWater

val swamp = listOf(
    "land/swamp/000.png",
    "land/swamp/001.png",
    "land/swamp/002.png",
    "land/swamp/003.png",
    "land/swamp/004.png",
    "land/swamp/005.png",
)

fun randomSwampPath(): String {
    return swamp.random()
}

fun getSwampLand(surroundings: CellSurroundings): CellLand {
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
        top.isSwamp && left.isSwamp -> BitmapPainter(imageResource(randomSwampPath()))
        // water
        left.isWater && top.isWater -> BitmapPainter(imageResource("land/swamp/sand/ooox.png"))
        top.isWater -> BitmapPainter(imageResource("land/swamp/sand/ooxx.png"))
        left.isWater -> BitmapPainter(imageResource("land/swamp/sand/oxox.png"))
        //sand
        left.isSand && top.isSand -> BitmapPainter(imageResource("land/swamp/sand/ooox.png"))
        top.isSand -> BitmapPainter(imageResource("land/swamp/sand/ooxx.png"))
        left.isSand -> BitmapPainter(imageResource("land/swamp/sand/oxox.png"))
        else -> BitmapPainter(imageResource(randomGroundPath()))
    }
}

private fun getTop2Land(surroundings: CellSurroundings): Painter {
    val right = surroundings.right?.cellType
    val top = surroundings.top?.cellType
    val topright = surroundings.topright?.cellType

    return when {
        top.isSwamp && right.isSwamp -> BitmapPainter(imageResource(randomSwampPath()))
        // water
        right.isWater && top.isWater -> BitmapPainter(imageResource("land/swamp/sand/ooxo.png"))
        top.isWater -> BitmapPainter(imageResource("land/swamp/sand/ooxx.png"))
        right.isWater -> BitmapPainter(imageResource("land/swamp/sand/xoxo.png"))
        // sand
        right.isSand && top.isSand -> BitmapPainter(imageResource("land/swamp/sand/ooxo.png"))
        top.isSand -> BitmapPainter(imageResource("land/swamp/sand/ooxx.png"))
        right.isSand -> BitmapPainter(imageResource("land/swamp/sand/xoxo.png"))
        else -> BitmapPainter(imageResource(randomGroundPath()))
    }
}

private fun getBot1Land(surroundings: CellSurroundings): Painter {
    val bot = surroundings.bot?.cellType
    val left = surroundings.left?.cellType
    val botleft = surroundings.botleft?.cellType

    return when {
        bot.isSwamp && left.isSwamp -> BitmapPainter(imageResource(randomSwampPath()))
        // water
        left.isWater && bot.isWater -> BitmapPainter(imageResource("land/swamp/sand/oxoo.png"))
        bot.isWater -> BitmapPainter(imageResource("land/swamp/sand/xxoo.png"))
        left.isWater -> BitmapPainter(imageResource("land/swamp/sand/oxox.png"))
        // sand
        left.isSand && bot.isSand -> BitmapPainter(imageResource("land/swamp/sand/oxoo.png"))
        bot.isSand -> BitmapPainter(imageResource("land/swamp/sand/xxoo.png"))
        left.isSand -> BitmapPainter(imageResource("land/swamp/sand/oxox.png"))
        else -> BitmapPainter(imageResource(randomSwampPath()))
    }
}

private fun getBot2Land(surroundings: CellSurroundings): Painter {
    val bot = surroundings.bot?.cellType
    val right = surroundings.right?.cellType
    val botright = surroundings.botright?.cellType

    return when {
        bot.isSwamp && right.isSwamp -> BitmapPainter(imageResource(randomSwampPath()))
        // water
        right.isWater && bot.isWater -> BitmapPainter(imageResource("land/swamp/sand/xooo.png"))
        bot.isWater -> BitmapPainter(imageResource("land/swamp/sand/xxoo.png"))
        right.isWater -> BitmapPainter(imageResource("land/swamp/sand/xoxo.png"))
        // sand
        right.isSand && bot.isSand -> BitmapPainter(imageResource("land/swamp/sand/xooo.png"))
        bot.isSand -> BitmapPainter(imageResource("land/swamp/sand/xxoo.png"))
        right.isSand -> BitmapPainter(imageResource("land/swamp/sand/xoxo.png"))
        else -> BitmapPainter(imageResource(randomSwampPath()))
    }
}