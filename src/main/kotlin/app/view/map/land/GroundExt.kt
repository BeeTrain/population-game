package app.view.map.land

import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.graphics.painter.Painter
import app.extension.imageResource
import app.view.map.model.CellLand
import app.view.map.model.CellSurroundings
import app.view.map.model.isGround
import app.view.map.model.isSand
import app.view.map.model.isWater

val grounds = listOf(
    "land/ground/tdtb000.png",
    "land/ground/tdtb001.png",
    "land/ground/tdtb002.png",
    "land/ground/tdtb003.png",
    "land/ground/tdtb004.png",
    "land/ground/tdtb005.png",
    "land/ground/tdtb006.png",
    "land/ground/tdtb007.png",
)

fun randomGroundPath(): String {
    return grounds.random()
}

fun getGroundLand(surroundings: CellSurroundings): CellLand {
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
        top.isGround && left.isGround -> BitmapPainter(imageResource(randomGroundPath()))
        // water
        left.isWater && top.isWater -> BitmapPainter(imageResource("land/ground/tosand/sssg.png"))
        top.isWater -> BitmapPainter(imageResource("land/ground/tosand/ssgg.png"))
        left.isWater -> BitmapPainter(imageResource("land/ground/tosand/sgsg.png"))
        //sand
        left.isSand && top.isSand -> BitmapPainter(imageResource("land/ground/tosand/sssg.png"))
        top.isSand -> BitmapPainter(imageResource("land/ground/tosand/ssgg.png"))
        left.isSand -> BitmapPainter(imageResource("land/ground/tosand/sgsg.png"))
        else -> BitmapPainter(imageResource(randomGroundPath()))
    }
}

private fun getTop2Land(surroundings: CellSurroundings): Painter {
    val right = surroundings.right?.cellType
    val top = surroundings.top?.cellType
    val topright = surroundings.topright?.cellType

    return when {
        top.isGround && right.isGround -> BitmapPainter(imageResource(randomGroundPath()))
        // water
        right.isWater && top.isWater -> BitmapPainter(imageResource("land/ground/tosand/ssgs.png"))
        top.isWater -> BitmapPainter(imageResource("land/ground/tosand/ssgg.png"))
        right.isWater -> BitmapPainter(imageResource("land/ground/tosand/gsgs.png"))
        // sand
        right.isSand && top.isSand -> BitmapPainter(imageResource("land/ground/tosand/ssgs.png"))
        top.isSand -> BitmapPainter(imageResource("land/ground/tosand/ssgg.png"))
        right.isSand -> BitmapPainter(imageResource("land/ground/tosand/gsgs.png"))
        else -> BitmapPainter(imageResource(randomGroundPath()))
    }
}

private fun getBot1Land(surroundings: CellSurroundings): Painter {
    val bot = surroundings.bot?.cellType
    val left = surroundings.left?.cellType
    val botleft = surroundings.botleft?.cellType

    return when {
        bot.isGround && left.isGround -> BitmapPainter(imageResource(randomGroundPath()))
        // water
        left.isWater && bot.isWater -> BitmapPainter(imageResource("land/ground/tosand/sgss.png"))
        bot.isWater -> BitmapPainter(imageResource("land/ground/tosand/ggss.png"))
        left.isWater -> BitmapPainter(imageResource("land/ground/tosand/sgsg.png"))
        // sand
        left.isSand && bot.isSand -> BitmapPainter(imageResource("land/ground/tosand/sgss.png"))
        bot.isSand -> BitmapPainter(imageResource("land/ground/tosand/ggss.png"))
        left.isSand -> BitmapPainter(imageResource("land/ground/tosand/sgsg.png"))
        else -> BitmapPainter(imageResource(randomGroundPath()))
    }
}

private fun getBot2Land(surroundings: CellSurroundings): Painter {
    val bot = surroundings.bot?.cellType
    val right = surroundings.right?.cellType
    val botright = surroundings.botright?.cellType

    return when {
        bot.isGround && right.isGround -> BitmapPainter(imageResource(randomGroundPath()))
        // water
        right.isWater && bot.isWater -> BitmapPainter(imageResource("land/ground/tosand/gsss.png"))
        bot.isWater -> BitmapPainter(imageResource("land/ground/tosand/ggss.png"))
        right.isWater -> BitmapPainter(imageResource("land/ground/tosand/gsgs.png"))
        // sand
        right.isSand && bot.isSand -> BitmapPainter(imageResource("land/ground/tosand/gsss.png"))
        bot.isSand -> BitmapPainter(imageResource("land/ground/tosand/ggss.png"))
        right.isSand -> BitmapPainter(imageResource("land/ground/tosand/gsgs.png"))
        else -> BitmapPainter(imageResource(randomGroundPath()))
    }
}