package app.view.map.land

import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.graphics.painter.Painter
import app.extension.imageResource
import app.view.map.model.CellLand
import app.view.map.model.CellSurroundings
import app.view.map.model.isSand
import app.view.map.model.isStones
import app.view.map.model.isWater

val stones = listOf(
    "land/stones/000.png",
    "land/stones/001.png",
    "land/stones/002.png",
    "land/stones/003.png",
    "land/stones/004.png",
    "land/stones/005.png",
)

fun randomStonesPath(): String {
    return stones.random()
}

fun getStoneLand(surroundings: CellSurroundings): CellLand {
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
        top.isStones && left.isStones -> BitmapPainter(imageResource(randomStonesPath()))
        // water
        left.isWater && top.isWater -> BitmapPainter(imageResource("land/stones/sand/ooox.png"))
        top.isWater -> BitmapPainter(imageResource("land/stones/sand/ooxx.png"))
        left.isWater -> BitmapPainter(imageResource("land/stones/sand/oxox.png"))
        //sand
        left.isSand && top.isSand -> BitmapPainter(imageResource("land/stones/sand/ooox.png"))
        top.isSand -> BitmapPainter(imageResource("land/stones/sand/ooxx.png"))
        left.isSand -> BitmapPainter(imageResource("land/stones/sand/oxox.png"))
        else -> BitmapPainter(imageResource(randomStonesPath()))
    }
}

private fun getTop2Land(surroundings: CellSurroundings): Painter {
    val right = surroundings.right?.cellType
    val top = surroundings.top?.cellType
    val topright = surroundings.topright?.cellType

    return when {
        top.isStones && right.isStones -> BitmapPainter(imageResource(randomStonesPath()))
        // water
        right.isWater && top.isWater -> BitmapPainter(imageResource("land/stones/sand/ooxo.png"))
        top.isWater -> BitmapPainter(imageResource("land/stones/sand/ooxx.png"))
        right.isWater -> BitmapPainter(imageResource("land/stones/sand/xoxo.png"))
        // sand
        right.isSand && top.isSand -> BitmapPainter(imageResource("land/stones/sand/ooxo.png"))
        top.isSand -> BitmapPainter(imageResource("land/stones/sand/ooxx.png"))
        right.isSand -> BitmapPainter(imageResource("land/stones/sand/xoxo.png"))
        else -> BitmapPainter(imageResource(randomStonesPath()))
    }
}

private fun getBot1Land(surroundings: CellSurroundings): Painter {
    val bot = surroundings.bot?.cellType
    val left = surroundings.left?.cellType
    val botleft = surroundings.botleft?.cellType

    return when {
        bot.isStones && left.isStones -> BitmapPainter(imageResource(randomStonesPath()))
        // water
        left.isWater && bot.isWater -> BitmapPainter(imageResource("land/stones/sand/oxoo.png"))
        bot.isWater -> BitmapPainter(imageResource("land/stones/sand/xxoo.png"))
        left.isWater -> BitmapPainter(imageResource("land/stones/sand/oxox.png"))
        // sand
        left.isSand && bot.isSand -> BitmapPainter(imageResource("land/stones/sand/oxoo.png"))
        bot.isSand -> BitmapPainter(imageResource("land/stones/sand/xxoo.png"))
        left.isSand -> BitmapPainter(imageResource("land/stones/sand/oxox.png"))
        else -> BitmapPainter(imageResource(randomStonesPath()))
    }
}

private fun getBot2Land(surroundings: CellSurroundings): Painter {
    val bot = surroundings.bot?.cellType
    val right = surroundings.right?.cellType
    val botright = surroundings.botright?.cellType

    return when {
        bot.isStones && right.isStones -> BitmapPainter(imageResource(randomStonesPath()))
        // water
        right.isWater && bot.isWater -> BitmapPainter(imageResource("land/stones/sand/xooo.png"))
        bot.isWater -> BitmapPainter(imageResource("land/stones/sand/xxoo.png"))
        right.isWater -> BitmapPainter(imageResource("land/stones/sand/xoxo.png"))
        // sand
        right.isSand && bot.isSand -> BitmapPainter(imageResource("land/stones/sand/xooo.png"))
        bot.isSand -> BitmapPainter(imageResource("land/stones/sand/xxoo.png"))
        right.isSand -> BitmapPainter(imageResource("land/stones/sand/xoxo.png"))
        else -> BitmapPainter(imageResource(randomStonesPath()))
    }
}