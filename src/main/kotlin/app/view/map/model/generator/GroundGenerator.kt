package app.view.map.model.generator

import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.graphics.painter.Painter
import app.extension.imageResource
import app.extension.or
import app.view.map.model.Cell
import app.view.map.model.CellLand
import app.view.map.model.CellSurroundings
import app.view.map.model.extension.randomLandPath

fun CellSurroundings.isTopLeft(type: Cell): Boolean {
    return top == type && left == type
}

fun CellSurroundings.isTopRight(type: Cell): Boolean {
    return top == type && right == type
}

fun CellSurroundings.isBotLeft(type: Cell): Boolean {
    return bot == type && left == type
}

fun CellSurroundings.isBotRight(type: Cell): Boolean {
    return bot == type && right == type
}


fun CellSurroundings.isTopLeftOrNull(type: Cell): Boolean {
    return isTopOrNull(type) && isLeftOrNull(type)
}

fun CellSurroundings.isTopRightOrNull(type: Cell): Boolean {
    return isTopOrNull(type) && isRightOrNull(type)
}

fun CellSurroundings.isBotLeftOrNull(type: Cell): Boolean {
    return isBotOrNull(type) && isLeftOrNull(type)
}

fun CellSurroundings.isBotRightOrNull(type: Cell): Boolean {
    return isBotOrNull(type) && isRightOrNull(type)
}

fun CellSurroundings.isTop(type: Cell): Boolean {
    return top == type
}

fun CellSurroundings.isBot(type: Cell): Boolean {
    return bot == type
}

fun CellSurroundings.isLeft(type: Cell): Boolean {
    return left == type
}

fun CellSurroundings.isRight(type: Cell): Boolean {
    return right == type
}

fun CellSurroundings.isTopOrNull(type: Cell): Boolean {
    return top == null || top == type
}

fun CellSurroundings.isBotOrNull(type: Cell): Boolean {
    return bot == null || bot == type
}

fun CellSurroundings.isLeftOrNull(type: Cell): Boolean {
    return left == null || left == type
}

fun CellSurroundings.isRightOrNull(type: Cell): Boolean {
    return right == null || right == type
}

fun Cell.generateLand(surroundings: CellSurroundings): CellLand {
    return CellLand(
        top1 = getTop1Land(surroundings),
        top2 = getTop2Land(surroundings),
        top3 = getTop3Land(surroundings),
        mid1 = getMid1Land(surroundings),
        mid2 = getMid2Land(surroundings),
        mid3 = getMid3Land(surroundings),
        bot1 = getBot1Land(surroundings),
        bot2 = getBot2Land(surroundings),
        bot3 = getBot3Land(surroundings),
    )
}

private fun Cell.getTop1Land(surroundings: CellSurroundings): Painter {
    return BitmapPainter(imageResource(getTop1ResourcePath(surroundings)))
}

private fun Cell.getTop2Land(surroundings: CellSurroundings): Painter {
    return BitmapPainter(imageResource(getTop2ResourcePath(surroundings)))
}

private fun Cell.getTop3Land(surroundings: CellSurroundings): Painter {
    return BitmapPainter(imageResource(getTop3ResourcePath(surroundings)))
}

private fun Cell.getMid1Land(surroundings: CellSurroundings): Painter {
    return BitmapPainter(imageResource(getMid1ResourcePath(surroundings)))
}

private fun Cell.getMid2Land(surroundings: CellSurroundings): Painter {
    return BitmapPainter(imageResource(randomLandPath()))
}

private fun Cell.getMid3Land(surroundings: CellSurroundings): Painter {
    return BitmapPainter(imageResource(getMid3ResourcePath(surroundings)))
}

private fun Cell.getBot1Land(surroundings: CellSurroundings): Painter {
    return BitmapPainter(imageResource(getBot1ResourcePath(surroundings)))
}

private fun Cell.getBot2Land(surroundings: CellSurroundings): Painter {
    return BitmapPainter(imageResource(getBot2ResourcePath(surroundings)))
}

private fun Cell.getBot3Land(surroundings: CellSurroundings): Painter {
    return BitmapPainter(imageResource(getBot3ResourcePath(surroundings)))
}

private fun Cell.getTop1ResourcePath(surroundings: CellSurroundings): String {
    val isPrior = this.ordinal >= surroundings.top?.ordinal.or(this.ordinal) &&
            this.ordinal >= surroundings.left?.ordinal.or(this.ordinal)

    val pattern = when {
        surroundings.isTopLeftOrNull(this) -> ""

        surroundings.isTopLeft(Cell.WATER) -> Pattern.TOP_LEFT.getPath(Cell.SAND)
        surroundings.isTop(Cell.WATER) -> Pattern.TOP.getPath(Cell.SAND)
        surroundings.isLeft(Cell.WATER) -> Pattern.LEFT.getPath(Cell.SAND)

        isPrior -> ""

        surroundings.isLeft(Cell.SAND) &&
                surroundings.isTop(Cell.GROUND) &&
                surroundings.isTopLeft(Cell.GROUND) -> Pattern.TOP.getPath(Cell.GROUND)

        surroundings.isTopLeft(Cell.SAND) -> Pattern.TOP_LEFT.getPath(Cell.SAND)
        surroundings.isTop(Cell.SAND) -> Pattern.TOP.getPath(Cell.SAND)
        surroundings.isLeft(Cell.SAND) -> Pattern.LEFT.getPath(Cell.SAND)

        surroundings.left == Cell.GROUND && surroundings.topleft == Cell.GROUND -> Pattern.LEFT.getPath(Cell.GROUND)
        surroundings.isTopLeft(Cell.GROUND) -> Pattern.TOP_LEFT.getPath(Cell.GROUND)
        surroundings.isTop(Cell.GROUND) -> Pattern.TOP.getPath(Cell.GROUND)
        surroundings.isLeft(Cell.GROUND) -> Pattern.LEFT.getPath(Cell.GROUND)

        surroundings.left == Cell.GRASS && surroundings.topleft == Cell.GRASS -> Pattern.LEFT.getPath(Cell.GRASS)
        surroundings.isTopLeft(Cell.GRASS) -> Pattern.TOP_LEFT.getPath(Cell.GRASS)
        surroundings.isTop(Cell.GRASS) -> Pattern.TOP.getPath(Cell.GRASS)
        surroundings.isLeft(Cell.GRASS) -> Pattern.LEFT.getPath(Cell.GRASS)
        else -> ""

    }
    return if (pattern.isEmpty()) {
        "land/${defaultPath()}"
    } else {
        "land/${path}/${pattern}"
    }
}

private fun Cell.getTop2ResourcePath(surroundings: CellSurroundings): String {
    val isPrior = this.ordinal >= surroundings.top?.ordinal.or(this.ordinal)

    val pattern = when {
        surroundings.isTopOrNull(this) -> ""
        surroundings.isTop(Cell.WATER) -> Pattern.TOP.getPath(Cell.SAND)
        isPrior -> ""
        surroundings.isTop(Cell.SAND) -> Pattern.TOP.getPath(Cell.SAND)
        surroundings.isTop(Cell.GROUND) -> Pattern.TOP.getPath(Cell.GROUND)
        surroundings.isTop(Cell.GRASS) -> Pattern.TOP.getPath(Cell.GRASS)
        else -> ""

    }
    return if (pattern.isEmpty()) {
        "land/${defaultPath()}"
    } else {
        "land/${path}/${pattern}"
    }
}

private fun Cell.getTop3ResourcePath(surroundings: CellSurroundings): String {
    val isPrior = this.ordinal >= surroundings.top?.ordinal.or(this.ordinal) &&
            this.ordinal >= surroundings.right?.ordinal.or(this.ordinal)

    val pattern = when {
        surroundings.isTopRightOrNull(this) -> ""

        surroundings.isTopRight(Cell.WATER) -> Pattern.TOP_RIGHT.getPath(Cell.SAND)
        surroundings.isTop(Cell.WATER) -> Pattern.TOP.getPath(Cell.SAND)
        surroundings.isRight(Cell.WATER) -> Pattern.RIGHT.getPath(Cell.SAND)

        isPrior -> ""

        surroundings.isRight(Cell.SAND) &&
                surroundings.isTop(Cell.GROUND) &&
                surroundings.isTopRight(Cell.GROUND) -> Pattern.TOP.getPath(Cell.GROUND)

        surroundings.isTopRight(Cell.SAND) -> Pattern.TOP_RIGHT.getPath(Cell.SAND)
        surroundings.isTop(Cell.SAND) -> Pattern.TOP.getPath(Cell.SAND)
        surroundings.isRight(Cell.SAND) -> Pattern.RIGHT.getPath(Cell.SAND)

        surroundings.right == Cell.GROUND && surroundings.topright == Cell.GROUND -> Pattern.RIGHT.getPath(Cell.GROUND)
        surroundings.isTopRight(Cell.GROUND) -> Pattern.TOP_RIGHT.getPath(Cell.GROUND)
        surroundings.isTop(Cell.GROUND) -> Pattern.TOP.getPath(Cell.GROUND)
        surroundings.isRight(Cell.GROUND) -> Pattern.RIGHT.getPath(Cell.GROUND)

        surroundings.right == Cell.GRASS && surroundings.topright == Cell.GRASS -> Pattern.RIGHT.getPath(Cell.GRASS)
        surroundings.isTopRight(Cell.GRASS) -> Pattern.TOP_RIGHT.getPath(Cell.GRASS)
        surroundings.isTop(Cell.GRASS) -> Pattern.TOP.getPath(Cell.GRASS)
        surroundings.isRight(Cell.GRASS) -> Pattern.RIGHT.getPath(Cell.GRASS)
        else -> ""
    }
    return if (pattern.isEmpty()) {
        "land/${defaultPath()}"
    } else {
        "land/${path}/${pattern}"
    }
}

private fun Cell.getMid1ResourcePath(surroundings: CellSurroundings): String {
    val isPrior = this.ordinal >= surroundings.left?.ordinal.or(this.ordinal)
    val pattern = when {
        surroundings.isLeftOrNull(this) -> ""
        surroundings.isLeft(Cell.WATER) -> Pattern.LEFT.getPath(Cell.SAND)
        isPrior -> ""
        surroundings.isLeft(Cell.SAND) -> Pattern.LEFT.getPath(Cell.SAND)
        surroundings.isLeft(Cell.GROUND) -> Pattern.LEFT.getPath(Cell.GROUND)
        surroundings.isLeft(Cell.GRASS) -> Pattern.LEFT.getPath(Cell.GRASS)
        else -> ""

    }
    return if (pattern.isEmpty()) {
        "land/${defaultPath()}"
    } else {
        "land/${path}/${pattern}"
    }
}

private fun Cell.getMid3ResourcePath(surroundings: CellSurroundings): String {
    val isPrior = this.ordinal >= surroundings.right?.ordinal.or(this.ordinal)
    val pattern = when {
        surroundings.isRightOrNull(this) -> ""
        surroundings.isRight(Cell.WATER) -> Pattern.RIGHT.getPath(Cell.SAND)
        isPrior -> ""
        surroundings.isRight(Cell.SAND) -> Pattern.RIGHT.getPath(Cell.SAND)
        surroundings.isRight(Cell.GROUND) -> Pattern.RIGHT.getPath(Cell.GROUND)
        surroundings.isRight(Cell.GRASS) -> Pattern.RIGHT.getPath(Cell.GRASS)
        else -> ""

    }
    return if (pattern.isEmpty()) {
        "land/${defaultPath()}"
    } else {
        "land/${path}/${pattern}"
    }
}

private fun Cell.getBot1ResourcePath(surroundings: CellSurroundings): String {
    val isPrior = this.ordinal >= surroundings.bot?.ordinal.or(this.ordinal) &&
            this.ordinal >= surroundings.left?.ordinal.or(this.ordinal)

    val pattern = when {
        surroundings.isBotLeftOrNull(this) -> ""

        surroundings.isBotLeft(Cell.WATER) -> Pattern.BOT_LEFT.getPath(Cell.SAND)
        surroundings.isBot(Cell.WATER) -> Pattern.BOT.getPath(Cell.SAND)
        surroundings.isLeft(Cell.WATER) -> Pattern.LEFT.getPath(Cell.SAND)

        isPrior -> ""

        surroundings.isLeft(Cell.SAND) &&
                surroundings.isBot(Cell.GROUND) &&
                surroundings.isBotLeft(Cell.GROUND) -> Pattern.TOP.getPath(Cell.GROUND)

        surroundings.isBotLeft(Cell.SAND) -> Pattern.BOT_LEFT.getPath(Cell.SAND)
        surroundings.isBot(Cell.SAND) -> Pattern.BOT.getPath(Cell.SAND)
        surroundings.isLeft(Cell.SAND) -> Pattern.LEFT.getPath(Cell.SAND)

        surroundings.left == Cell.GROUND && surroundings.botleft == Cell.GROUND -> Pattern.LEFT.getPath(Cell.GROUND)
        surroundings.isBotLeft(Cell.GROUND) -> Pattern.BOT_LEFT.getPath(Cell.GROUND)
        surroundings.isBot(Cell.GROUND) -> Pattern.BOT.getPath(Cell.GROUND)
        surroundings.isLeft(Cell.GROUND) -> Pattern.LEFT.getPath(Cell.GROUND)

        surroundings.left == Cell.GRASS && surroundings.botleft == Cell.GRASS -> Pattern.LEFT.getPath(Cell.GRASS)
        surroundings.isBotLeft(Cell.GRASS) -> Pattern.BOT_LEFT.getPath(Cell.GRASS)
        surroundings.isBot(Cell.GRASS) -> Pattern.BOT.getPath(Cell.GRASS)
        surroundings.isLeft(Cell.GRASS) -> Pattern.LEFT.getPath(Cell.GRASS)
        else -> ""
    }
    return if (pattern.isEmpty()) {
        "land/${defaultPath()}"
    } else {
        "land/${path}/${pattern}"
    }
}

private fun Cell.getBot2ResourcePath(surroundings: CellSurroundings): String {
    val isPrior = this.ordinal >= surroundings.bot?.ordinal.or(this.ordinal)
    val pattern = when {
        surroundings.isBotLeftOrNull(this) -> ""
        surroundings.isBot(Cell.WATER) -> Pattern.BOT.getPath(Cell.SAND)
        isPrior -> ""
        surroundings.isBot(Cell.SAND) -> Pattern.BOT.getPath(Cell.SAND)
        surroundings.isBot(Cell.GROUND) -> Pattern.BOT.getPath(Cell.GROUND)
        surroundings.isBot(Cell.GRASS) -> Pattern.BOT.getPath(Cell.GRASS)
        else -> ""
    }
    return if (pattern.isEmpty()) {
        "land/${defaultPath()}"
    } else {
        "land/${path}/${pattern}"
    }
}

private fun Cell.getBot3ResourcePath(surroundings: CellSurroundings): String {
    val isPrior = this.ordinal >= surroundings.bot?.ordinal.or(this.ordinal) &&
            this.ordinal >= surroundings.right?.ordinal.or(this.ordinal)

    val pattern = when {
        surroundings.isBotRightOrNull(this) -> ""

        surroundings.isBotRight(Cell.WATER) -> Pattern.BOT_RIGHT.getPath(Cell.SAND)
        surroundings.isBot(Cell.WATER) -> Pattern.BOT.getPath(Cell.SAND)
        surroundings.isRight(Cell.WATER) -> Pattern.RIGHT.getPath(Cell.SAND)

        isPrior -> ""

        surroundings.isRight(Cell.SAND) &&
                surroundings.isBot(Cell.GROUND) &&
                surroundings.isBotRight(Cell.GROUND) -> Pattern.TOP.getPath(Cell.GROUND)

        surroundings.isBotRight(Cell.SAND) -> Pattern.BOT_RIGHT.getPath(Cell.SAND)
        surroundings.isBot(Cell.SAND) -> Pattern.BOT.getPath(Cell.SAND)
        surroundings.isRight(Cell.SAND) -> Pattern.RIGHT.getPath(Cell.SAND)

        surroundings.right == Cell.GROUND && surroundings.botright == Cell.GROUND -> Pattern.RIGHT.getPath(Cell.GROUND)
        surroundings.isBotRight(Cell.GROUND) -> Pattern.BOT_RIGHT.getPath(Cell.GROUND)
        surroundings.isBot(Cell.GROUND) -> Pattern.BOT.getPath(Cell.GROUND)
        surroundings.isRight(Cell.GROUND) -> Pattern.RIGHT.getPath(Cell.GROUND)

        surroundings.right == Cell.GRASS && surroundings.botright == Cell.GRASS -> Pattern.RIGHT.getPath(Cell.GRASS)
        surroundings.isBotRight(Cell.GRASS) -> Pattern.BOT_RIGHT.getPath(Cell.GRASS)
        surroundings.isBot(Cell.GRASS) -> Pattern.BOT.getPath(Cell.GRASS)
        surroundings.isRight(Cell.GRASS) -> Pattern.RIGHT.getPath(Cell.GRASS)
        else -> ""
    }
    return if (pattern.isEmpty()) {
        "land/${defaultPath()}"
    } else {
        "land/${path}/${pattern}"
    }
}

private enum class Pattern(val pattern: String) {
    TOP("ooxx.png"),
    LEFT("oxox.png"),
    RIGHT("xoxo.png"),
    BOT("xxoo.png"),
    TOP_LEFT("ooox.png"),
    TOP_RIGHT("ooxo.png"),
    BOT_LEFT("oxoo.png"),
    BOT_RIGHT("xooo.png");

    fun getPath(type: Cell): String {
        return "${type.path}/${pattern}"
    }
}