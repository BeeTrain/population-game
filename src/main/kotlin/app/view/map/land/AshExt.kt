package app.view.map.land

import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.graphics.painter.Painter
import app.extension.imageResource
import app.view.map.model.CellLand
import app.view.map.model.CellSurroundings
import app.view.map.model.isAsh
import app.view.map.model.isSand
import app.view.map.model.isWater

val ash = listOf(
    "land/ash/000.png",
    "land/ash/001.png",
    "land/ash/002.png",
    "land/ash/003.png",
    "land/ash/004.png",
    "land/ash/005.png",
)

fun randomAshPath(): String {
    return ash.random()
}


fun getAshLand(surroundings: CellSurroundings): CellLand {
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
        top.isAsh && left.isAsh -> BitmapPainter(imageResource(randomAshPath()))
        // water
        left.isWater && top.isWater -> BitmapPainter(imageResource("land/ash/sand/ooox.png"))
        top.isWater -> BitmapPainter(imageResource("land/ash/sand/ooxx.png"))
        left.isWater -> BitmapPainter(imageResource("land/ash/sand/oxox.png"))
        //sand
        left.isSand && top.isSand -> BitmapPainter(imageResource("land/ash/sand/ooox.png"))
        top.isSand -> BitmapPainter(imageResource("land/ash/sand/ooxx.png"))
        left.isSand -> BitmapPainter(imageResource("land/ash/sand/oxox.png"))
        else -> BitmapPainter(imageResource(randomAshPath()))
    }
}

private fun getTop2Land(surroundings: CellSurroundings): Painter {
    val right = surroundings.right?.cellType
    val top = surroundings.top?.cellType
    val topright = surroundings.topright?.cellType

    return when {
        top.isAsh && right.isAsh -> BitmapPainter(imageResource(randomAshPath()))
        // water
        right.isWater && top.isWater -> BitmapPainter(imageResource("land/ash/sand/ooxo.png"))
        top.isWater -> BitmapPainter(imageResource("land/ash/sand/ooxx.png"))
        right.isWater -> BitmapPainter(imageResource("land/ash/sand/xoxo.png"))
        // sand
        right.isSand && top.isSand -> BitmapPainter(imageResource("land/ash/sand/ooxo.png"))
        top.isSand -> BitmapPainter(imageResource("land/ash/sand/ooxx.png"))
        right.isSand -> BitmapPainter(imageResource("land/ash/sand/oxox.png"))
        else -> BitmapPainter(imageResource(randomAshPath()))
    }
}

private fun getBot1Land(surroundings: CellSurroundings): Painter {
    val bot = surroundings.bot?.cellType
    val left = surroundings.left?.cellType
    val botleft = surroundings.botleft?.cellType

    return when {
        bot.isAsh && left.isAsh -> BitmapPainter(imageResource(randomAshPath()))
        // water
        left.isWater && bot.isWater -> BitmapPainter(imageResource("land/ash/sand/oxoo.png"))
        bot.isWater -> BitmapPainter(imageResource("land/ash/sand/xxoo.png"))
        left.isWater -> BitmapPainter(imageResource("land/ash/sand/oxox.png"))
        // sand
        left.isSand && bot.isSand -> BitmapPainter(imageResource("land/ash/sand/oxoo.png"))
        bot.isSand -> BitmapPainter(imageResource("land/ash/sand/xxoo.png"))
        left.isSand -> BitmapPainter(imageResource("land/ash/sand/oxox.png"))
        else -> BitmapPainter(imageResource(randomAshPath()))
    }
}

private fun getBot2Land(surroundings: CellSurroundings): Painter {
    val bot = surroundings.bot?.cellType
    val right = surroundings.right?.cellType
    val botright = surroundings.botright?.cellType

    return when {
        bot.isAsh && right.isAsh -> BitmapPainter(imageResource(randomAshPath()))
        // water
        right.isWater && bot.isWater -> BitmapPainter(imageResource("land/ash/sand/xooo.png"))
        bot.isWater -> BitmapPainter(imageResource("land/ash/sand/xxoo.png"))
        right.isWater -> BitmapPainter(imageResource("land/ash/sand/xoxo.png"))
        // sand
        right.isSand && bot.isSand -> BitmapPainter(imageResource("land/ash/sand/xooo.png"))
        bot.isSand -> BitmapPainter(imageResource("land/ash/sand/xxoo.png"))
        right.isSand -> BitmapPainter(imageResource("land/ash/sand/xoxo.png"))
        else -> BitmapPainter(imageResource(randomAshPath()))
    }
}