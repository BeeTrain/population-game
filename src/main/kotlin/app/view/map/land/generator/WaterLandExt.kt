package app.view.map.land.generator

import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.graphics.painter.Painter
import app.extension.imageResource
import app.view.map.model.CellLand
import app.view.map.model.CellSurroundings
import app.view.map.model.CellType
import app.view.map.model.isWater
import app.view.map.model.isWaterOrNull

private fun randomWaterPath() = CellType.WATER.randomLandPath()

fun getWaterLand(surroundings: CellSurroundings): CellLand {
    return CellLand(
        top1 = getTop1Land(surroundings),
        top2 = getTop2Land(surroundings),
        bot1 = getBot1Land(surroundings),
        bot2 = getBot2Land(surroundings)
    )
}

private fun getTop1Land(surroundings: CellSurroundings): Painter {
    val top = surroundings.top?.cellType
    val left = surroundings.left?.cellType
    val topleft = surroundings.topleft?.cellType

    return when {
        left.isWaterOrNull && topleft.isWaterOrNull && top.isWaterOrNull -> BitmapPainter(imageResource(randomWaterPath()))

        !left.isWater && !top.isWater && !topleft.isWater -> BitmapPainter(imageResource("land/water/border/ooox.png"))
        left.isWater && top.isWater && !topleft.isWater -> BitmapPainter(imageResource("land/water/border/oxxx.png"))
        !top.isWater -> BitmapPainter(imageResource("land/water/border/ooxx.png"))
        left.isWaterOrNull -> BitmapPainter(imageResource(randomWaterPath()))
        !left.isWater -> BitmapPainter(imageResource("land/water/border/oxox.png"))
        else -> BitmapPainter(imageResource(randomWaterPath()))
    }
}

private fun getTop2Land(surroundings: CellSurroundings): Painter {
    val right = surroundings.right?.cellType
    val top = surroundings.top?.cellType
    val topright = surroundings.topright?.cellType

    return when {
        right.isWaterOrNull && topright.isWaterOrNull && top.isWaterOrNull -> BitmapPainter(
            imageResource(
                randomWaterPath()
            )
        )

        !top.isWater && !right.isWater && !topright.isWater -> BitmapPainter(imageResource("land/water/border/ooxo.png"))
        top.isWater && right.isWater && !topright.isWater -> BitmapPainter(imageResource("land/water/border/xoxx.png"))
        !top.isWater -> BitmapPainter(imageResource("land/water/border/ooxx.png"))
        right.isWaterOrNull -> BitmapPainter(imageResource(randomWaterPath()))
        !right.isWater -> BitmapPainter(imageResource("land/water/border/xoxo.png"))
        else -> BitmapPainter(imageResource(randomWaterPath()))
    }
}

private fun getBot1Land(surroundings: CellSurroundings): Painter {
    val left = surroundings.left?.cellType
    val bot = surroundings.bot?.cellType
    val botleft = surroundings.botleft?.cellType

    return when {
        left.isWaterOrNull && botleft.isWaterOrNull && bot.isWaterOrNull -> BitmapPainter(imageResource(randomWaterPath()))

        !bot.isWater && !left.isWater && !botleft.isWater -> BitmapPainter(imageResource("land/water/border/oxoo.png"))
        bot.isWater && left.isWater && !botleft.isWater -> BitmapPainter(imageResource("land/water/border/xxox.png"))
        !bot.isWater -> BitmapPainter(imageResource("land/water/border/xxoo.png"))
        left.isWaterOrNull -> BitmapPainter(imageResource(randomWaterPath()))
        !left.isWater -> BitmapPainter(imageResource("land/water/border/oxox.png"))
        else -> BitmapPainter(imageResource(randomWaterPath()))
    }
}

private fun getBot2Land(surroundings: CellSurroundings): Painter {
    val right = surroundings.right?.cellType
    val bot = surroundings.bot?.cellType
    val botright = surroundings.botright?.cellType

    return when {
        right.isWaterOrNull && botright.isWaterOrNull && bot.isWaterOrNull -> BitmapPainter(
            imageResource(
                randomWaterPath()
            )
        )

        !bot.isWater && !right.isWater && !botright.isWater -> BitmapPainter(imageResource("land/water/border/xooo.png"))
        bot.isWater && right.isWater && !botright.isWater -> BitmapPainter(imageResource("land/water/border/xxxo.png"))
        !bot.isWater -> BitmapPainter(imageResource("land/water/border/xxoo.png"))
        right.isWaterOrNull -> BitmapPainter(imageResource(randomWaterPath()))
        !right.isWater -> BitmapPainter(imageResource("land/water/border/xoxo.png"))
        else -> BitmapPainter(imageResource(randomWaterPath()))
    }
}