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
    "land/swamp/tswb000.png",
    "land/swamp/tswb001.png",
    "land/swamp/tswb002.png",
    "land/swamp/tswb003.png",
    "land/swamp/tswb004.png",
    "land/swamp/tswb005.png",
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
        left.isWater && top.isWater -> BitmapPainter(imageResource("land/swamp/tosand/sssg.png"))
        top.isWater -> BitmapPainter(imageResource("land/swamp/tosand/ssgg.png"))
        left.isWater -> BitmapPainter(imageResource("land/swamp/tosand/sgsg.png"))
        //sand
        left.isSand && top.isSand -> BitmapPainter(imageResource("land/swamp/tosand/sssg.png"))
        top.isSand -> BitmapPainter(imageResource("land/swamp/tosand/ssgg.png"))
        left.isSand -> BitmapPainter(imageResource("land/swamp/tosand/sgsg.png"))
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
        right.isWater && top.isWater -> BitmapPainter(imageResource("land/swamp/tosand/ssgs.png"))
        top.isWater -> BitmapPainter(imageResource("land/swamp/tosand/ssgg.png"))
        right.isWater -> BitmapPainter(imageResource("land/swamp/tosand/gsgs.png"))
        // sand
        right.isSand && top.isSand -> BitmapPainter(imageResource("land/swamp/tosand/ssgs.png"))
        top.isSand -> BitmapPainter(imageResource("land/swamp/tosand/ssgg.png"))
        right.isSand -> BitmapPainter(imageResource("land/swamp/tosand/gsgs.png"))
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
        left.isWater && bot.isWater -> BitmapPainter(imageResource("land/swamp/tosand/sgss.png"))
        bot.isWater -> BitmapPainter(imageResource("land/swamp/tosand/ggss.png"))
        left.isWater -> BitmapPainter(imageResource("land/swamp/tosand/sgsg.png"))
        // sand
        left.isSand && bot.isSand -> BitmapPainter(imageResource("land/swamp/tosand/sgss.png"))
        bot.isSand -> BitmapPainter(imageResource("land/swamp/tosand/ggss.png"))
        left.isSand -> BitmapPainter(imageResource("land/swamp/tosand/sgsg.png"))
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
        right.isWater && bot.isWater -> BitmapPainter(imageResource("land/swamp/tosand/gsss.png"))
        bot.isWater -> BitmapPainter(imageResource("land/swamp/tosand/ggss.png"))
        right.isWater -> BitmapPainter(imageResource("land/swamp/tosand/gsgs.png"))
        // sand
        right.isSand && bot.isSand -> BitmapPainter(imageResource("land/swamp/tosand/gsss.png"))
        bot.isSand -> BitmapPainter(imageResource("land/swamp/tosand/ggss.png"))
        right.isSand -> BitmapPainter(imageResource("land/swamp/tosand/gsgs.png"))
        else -> BitmapPainter(imageResource(randomSwampPath()))
    }
}