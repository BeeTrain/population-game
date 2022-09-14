package app.view.map.land

import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.graphics.painter.Painter
import app.extension.imageResource
import app.view.map.model.CellLand
import app.view.map.model.CellSurroundings
import app.view.map.model.isSand
import app.view.map.model.isStone
import app.view.map.model.isWater

val stones = listOf(
    "land/stones/trob000.png",
    "land/stones/trob001.png",
    "land/stones/trob002.png",
    "land/stones/trob003.png",
    "land/stones/trob004.png",
    "land/stones/trob005.png",
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
        top.isStone && left.isStone -> BitmapPainter(imageResource(randomStonesPath()))
        // water
        left.isWater && top.isWater -> BitmapPainter(imageResource("land/stones/tosand/sssg.png"))
        top.isWater -> BitmapPainter(imageResource("land/stones/tosand/ssgg.png"))
        left.isWater -> BitmapPainter(imageResource("land/stones/tosand/sgsg.png"))
        //sand
        left.isSand && top.isSand -> BitmapPainter(imageResource("land/stones/tosand/sssg.png"))
        top.isSand -> BitmapPainter(imageResource("land/stones/tosand/ssgg.png"))
        left.isSand -> BitmapPainter(imageResource("land/stones/tosand/sgsg.png"))
        else -> BitmapPainter(imageResource(randomStonesPath()))
    }
}

private fun getTop2Land(surroundings: CellSurroundings): Painter {
    val right = surroundings.right?.cellType
    val top = surroundings.top?.cellType
    val topright = surroundings.topright?.cellType

    return when {
        top.isStone && right.isStone -> BitmapPainter(imageResource(randomStonesPath()))
        // water
        right.isWater && top.isWater -> BitmapPainter(imageResource("land/stones/tosand/ssgs.png"))
        top.isWater -> BitmapPainter(imageResource("land/stones/tosand/ssgg.png"))
        right.isWater -> BitmapPainter(imageResource("land/stones/tosand/gsgs.png"))
        // sand
        right.isSand && top.isSand -> BitmapPainter(imageResource("land/stones/tosand/ssgs.png"))
        top.isSand -> BitmapPainter(imageResource("land/stones/tosand/ssgg.png"))
        right.isSand -> BitmapPainter(imageResource("land/stones/tosand/gsgs.png"))
        else -> BitmapPainter(imageResource(randomStonesPath()))
    }
}

private fun getBot1Land(surroundings: CellSurroundings): Painter {
    val bot = surroundings.bot?.cellType
    val left = surroundings.left?.cellType
    val botleft = surroundings.botleft?.cellType

    return when {
        bot.isStone && left.isStone -> BitmapPainter(imageResource(randomStonesPath()))
        // water
        left.isWater && bot.isWater -> BitmapPainter(imageResource("land/stones/tosand/sgss.png"))
        bot.isWater -> BitmapPainter(imageResource("land/stones/tosand/ggss.png"))
        left.isWater -> BitmapPainter(imageResource("land/stones/tosand/sgsg.png"))
        // sand
        left.isSand && bot.isSand -> BitmapPainter(imageResource("land/stones/tosand/sgss.png"))
        bot.isSand -> BitmapPainter(imageResource("land/stones/tosand/ggss.png"))
        left.isSand -> BitmapPainter(imageResource("land/stones/tosand/sgsg.png"))
        else -> BitmapPainter(imageResource(randomStonesPath()))
    }
}

private fun getBot2Land(surroundings: CellSurroundings): Painter {
    val bot = surroundings.bot?.cellType
    val right = surroundings.right?.cellType
    val botright = surroundings.botright?.cellType

    return when {
        bot.isStone && right.isStone -> BitmapPainter(imageResource(randomStonesPath()))
        // water
        right.isWater && bot.isWater -> BitmapPainter(imageResource("land/stones/tosand/gsss.png"))
        bot.isWater -> BitmapPainter(imageResource("land/stones/tosand/ggss.png"))
        right.isWater -> BitmapPainter(imageResource("land/stones/tosand/gsgs.png"))
        // sand
        right.isSand && bot.isSand -> BitmapPainter(imageResource("land/stones/tosand/gsss.png"))
        bot.isSand -> BitmapPainter(imageResource("land/stones/tosand/ggss.png"))
        right.isSand -> BitmapPainter(imageResource("land/stones/tosand/gsgs.png"))
        else -> BitmapPainter(imageResource(randomStonesPath()))
    }
}