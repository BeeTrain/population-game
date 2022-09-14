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
    "land/grass/000.png",
    "land/grass/001.png",
    "land/grass/002.png",
    "land/grass/003.png",
    "land/grass/004.png",
    "land/grass/005.png",
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
        left.isWater && top.isWater -> BitmapPainter(imageResource("land/grass/sand/ooox.png"))
        top.isWater -> BitmapPainter(imageResource("land/grass/sand/ooxx.png"))
        left.isWater -> BitmapPainter(imageResource("land/grass/sand/oxox.png"))
        //sand
        left.isSand && top.isSand -> BitmapPainter(imageResource("land/grass/sand/ooox.png"))
        top.isSand -> BitmapPainter(imageResource("land/grass/sand/ooxx.png"))
        left.isSand -> BitmapPainter(imageResource("land/grass/sand/oxox.png"))
        // ground
        left.isGround && top.isGround -> BitmapPainter(imageResource("land/grass/ground/sssg.png"))
        top.isGround -> BitmapPainter(imageResource("land/grass/ground/ssgg.png"))
        left.isGround -> BitmapPainter(imageResource("land/grass/ground/sgsg.png"))
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
        right.isWater && top.isWater -> BitmapPainter(imageResource("land/grass/sand/ooxo.png"))
        top.isWater -> BitmapPainter(imageResource("land/grass/sand/ooxx.png"))
        right.isWater -> BitmapPainter(imageResource("land/grass/sand/xoxo.png"))
        // sand
        right.isSand && top.isSand -> BitmapPainter(imageResource("land/grass/sand/ooxo.png"))
        top.isSand -> BitmapPainter(imageResource("land/grass/sand/ooxx.png"))
        right.isSand -> BitmapPainter(imageResource("land/grass/sand/xoxo.png"))
        // ground
        right.isGround && top.isGround -> BitmapPainter(imageResource("land/grass/ground/ooxo.png"))
        top.isGround -> BitmapPainter(imageResource("land/grass/ground/ooxx.png"))
        right.isGround -> BitmapPainter(imageResource("land/grass/ground/xoxo.png"))
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
        left.isWater && bot.isWater -> BitmapPainter(imageResource("land/grass/sand/oxoo.png"))
        bot.isWater -> BitmapPainter(imageResource("land/grass/sand/xxoo.png"))
        left.isWater -> BitmapPainter(imageResource("land/grass/sand/oxox.png"))
        // sand
        left.isSand && bot.isSand -> BitmapPainter(imageResource("land/grass/sand/oxoo.png"))
        bot.isSand -> BitmapPainter(imageResource("land/grass/sand/xxoo.png"))
        left.isSand -> BitmapPainter(imageResource("land/grass/sand/oxox.png"))
        // ground
        left.isGround && bot.isGround -> BitmapPainter(imageResource("land/grass/ground/oxoo.png"))
        bot.isGround -> BitmapPainter(imageResource("land/grass/ground/xxoo.png"))
        left.isGround -> BitmapPainter(imageResource("land/grass/ground/oxox.png"))
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
        right.isWater && bot.isWater -> BitmapPainter(imageResource("land/grass/sand/xooo.png"))
        bot.isWater -> BitmapPainter(imageResource("land/grass/sand/xxoo.png"))
        right.isWater -> BitmapPainter(imageResource("land/grass/sand/xoxo.png"))
        // sand
        right.isSand && bot.isSand -> BitmapPainter(imageResource("land/grass/sand/xooo.png"))
        bot.isSand -> BitmapPainter(imageResource("land/grass/sand/xxoo.png"))
        right.isSand -> BitmapPainter(imageResource("land/grass/sand/xoxo.png"))
        // ground
        right.isGround && bot.isGround -> BitmapPainter(imageResource("land/grass/toground/xooo.png"))
        bot.isGround -> BitmapPainter(imageResource("land/grass/toground/xxoo.png"))
        right.isGround -> BitmapPainter(imageResource("land/grass/toground/xoxo.png"))
        else -> BitmapPainter(imageResource(randomGrassPath()))
    }
}