package app.view.map.land

import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.graphics.painter.Painter
import app.extension.imageResource
import app.view.map.model.CellLand
import app.view.map.model.CellSurroundings
import app.view.map.model.isGrass
import app.view.map.model.isGround
import app.view.map.model.isSand
import app.view.map.model.isWater

val grasses = listOf(
    "land/grass/tgrb000.png",
    "land/grass/tgrb001.png",
    "land/grass/tgrb002.png",
    "land/grass/tgrb003.png",
    "land/grass/tgrb004.png",
    "land/grass/tgrb005.png",
)

fun randomGrassPath(): String {
    return grasses.random()
}


fun getGrassLand(surroundings: CellSurroundings): CellLand {
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
        top.isGrass && left.isGrass -> BitmapPainter(imageResource(randomGrassPath()))
        // water
        left.isWater && top.isWater -> BitmapPainter(imageResource("land/grass/tosand/sssg.png"))
        top.isWater -> BitmapPainter(imageResource("land/grass/tosand/ssgg.png"))
        left.isWater -> BitmapPainter(imageResource("land/grass/tosand/sgsg.png"))
        //sand
        left.isSand && top.isSand -> BitmapPainter(imageResource("land/grass/tosand/sssg.png"))
        top.isSand -> BitmapPainter(imageResource("land/grass/tosand/ssgg.png"))
        left.isSand -> BitmapPainter(imageResource("land/grass/tosand/sgsg.png"))
        // ground
        left.isGround && top.isGround -> BitmapPainter(imageResource("land/grass/toground/sssg.png"))
        top.isGround -> BitmapPainter(imageResource("land/grass/toground/ssgg.png"))
        left.isGround -> BitmapPainter(imageResource("land/grass/toground/sgsg.png"))
        else -> BitmapPainter(imageResource(randomGrassPath()))
    }
}

private fun getTop2Land(surroundings: CellSurroundings): Painter {
    val right = surroundings.right?.cellType
    val top = surroundings.top?.cellType
    val topright = surroundings.topright?.cellType

    return when {
        top.isGrass && right.isGrass -> BitmapPainter(imageResource(randomGrassPath()))
        // water
        right.isWater && top.isWater -> BitmapPainter(imageResource("land/grass/tosand/ssgs.png"))
        top.isWater -> BitmapPainter(imageResource("land/grass/tosand/ssgg.png"))
        right.isWater -> BitmapPainter(imageResource("land/grass/tosand/gsgs.png"))
        // sand
        right.isSand && top.isSand -> BitmapPainter(imageResource("land/grass/tosand/ssgs.png"))
        top.isSand -> BitmapPainter(imageResource("land/grass/tosand/ssgg.png"))
        right.isSand -> BitmapPainter(imageResource("land/grass/tosand/gsgs.png"))
        // ground
        right.isGround && top.isGround -> BitmapPainter(imageResource("land/grass/toground/ssgs.png"))
        top.isGround -> BitmapPainter(imageResource("land/grass/toground/ssgg.png"))
        right.isGround -> BitmapPainter(imageResource("land/grass/toground/gsgs.png"))
        else -> BitmapPainter(imageResource(randomGrassPath()))
    }
}

private fun getBot1Land(surroundings: CellSurroundings): Painter {
    val bot = surroundings.bot?.cellType
    val left = surroundings.left?.cellType
    val botleft = surroundings.botleft?.cellType

    return when {
        bot.isGrass && left.isGrass -> BitmapPainter(imageResource(randomGrassPath()))
        // water
        left.isWater && bot.isWater -> BitmapPainter(imageResource("land/grass/tosand/sgss.png"))
        bot.isWater -> BitmapPainter(imageResource("land/grass/tosand/ggss.png"))
        left.isWater -> BitmapPainter(imageResource("land/grass/tosand/sgsg.png"))
        // sand
        left.isSand && bot.isSand -> BitmapPainter(imageResource("land/grass/tosand/sgss.png"))
        bot.isSand -> BitmapPainter(imageResource("land/grass/tosand/ggss.png"))
        left.isSand -> BitmapPainter(imageResource("land/grass/tosand/sgsg.png"))
        // ground
        left.isGround && bot.isGround -> BitmapPainter(imageResource("land/grass/toground/sgss.png"))
        bot.isGround -> BitmapPainter(imageResource("land/grass/toground/ggss.png"))
        left.isGround -> BitmapPainter(imageResource("land/grass/toground/sgsg.png"))
        else -> BitmapPainter(imageResource(randomGrassPath()))
    }
}

private fun getBot2Land(surroundings: CellSurroundings): Painter {
    val bot = surroundings.bot?.cellType
    val right = surroundings.right?.cellType
    val botright = surroundings.botright?.cellType

    return when {
        bot.isGrass && right.isGrass -> BitmapPainter(imageResource(randomGrassPath()))
        // water
        right.isWater && bot.isWater -> BitmapPainter(imageResource("land/grass/tosand/gsss.png"))
        bot.isWater -> BitmapPainter(imageResource("land/grass/tosand/ggss.png"))
        right.isWater -> BitmapPainter(imageResource("land/grass/tosand/gsgs.png"))
        // sand
        right.isSand && bot.isSand -> BitmapPainter(imageResource("land/grass/tosand/gsss.png"))
        bot.isSand -> BitmapPainter(imageResource("land/grass/tosand/ggss.png"))
        right.isSand -> BitmapPainter(imageResource("land/grass/tosand/gsgs.png"))
        // ground
        right.isGround && bot.isGround -> BitmapPainter(imageResource("land/grass/toground/gsss.png"))
        bot.isGround -> BitmapPainter(imageResource("land/grass/toground/ggss.png"))
        right.isGround -> BitmapPainter(imageResource("land/grass/toground/gsgs.png"))
        else -> BitmapPainter(imageResource(randomGrassPath()))
    }
}