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
    "land/ash/tvlb000.png",
    "land/ash/tvlb001.png",
    "land/ash/tvlb002.png",
    "land/ash/tvlb003.png",
    "land/ash/tvlb004.png",
    "land/ash/tvlb005.png",
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
        left.isWater && top.isWater -> BitmapPainter(imageResource("land/ash/tosand/sssa.png"))
        top.isWater -> BitmapPainter(imageResource("land/ash/tosand/ssaa.png"))
        left.isWater -> BitmapPainter(imageResource("land/ash/tosand/sasa.png"))
        //sand
        left.isSand && top.isSand -> BitmapPainter(imageResource("land/ash/tosand/sssa.png"))
        top.isSand -> BitmapPainter(imageResource("land/ash/tosand/ssaa.png"))
        left.isSand -> BitmapPainter(imageResource("land/ash/tosand/sasa.png"))
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
        right.isWater && top.isWater -> BitmapPainter(imageResource("land/ash/tosand/ssas.png"))
        top.isWater -> BitmapPainter(imageResource("land/ash/tosand/ssaa.png"))
        right.isWater -> BitmapPainter(imageResource("land/ash/tosand/asas.png"))
        // sand
        right.isSand && top.isSand -> BitmapPainter(imageResource("land/ash/tosand/ssas.png"))
        top.isSand -> BitmapPainter(imageResource("land/ash/tosand/ssaa.png"))
        right.isSand -> BitmapPainter(imageResource("land/ash/tosand/asas.png"))
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
        left.isWater && bot.isWater -> BitmapPainter(imageResource("land/ash/tosand/sass.png"))
        bot.isWater -> BitmapPainter(imageResource("land/ash/tosand/aass.png"))
        left.isWater -> BitmapPainter(imageResource("land/ash/tosand/sasa.png"))
        // sand
        left.isSand && bot.isSand -> BitmapPainter(imageResource("land/ash/tosand/sass.png"))
        bot.isSand -> BitmapPainter(imageResource("land/ash/tosand/aass.png"))
        left.isSand -> BitmapPainter(imageResource("land/ash/tosand/sasa.png"))
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
        right.isWater && bot.isWater -> BitmapPainter(imageResource("land/ash/tosand/asss.png"))
        bot.isWater -> BitmapPainter(imageResource("land/ash/tosand/aass.png"))
        right.isWater -> BitmapPainter(imageResource("land/ash/tosand/asas.png"))
        // sand
        right.isSand && bot.isSand -> BitmapPainter(imageResource("land/ash/tosand/asss.png"))
        bot.isSand -> BitmapPainter(imageResource("land/ash/tosand/aass.png"))
        right.isSand -> BitmapPainter(imageResource("land/ash/tosand/asas.png"))
        else -> BitmapPainter(imageResource(randomAshPath()))
    }
}