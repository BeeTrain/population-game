package app.view.map.land.generator

import androidx.compose.ui.graphics.painter.BitmapPainter
import app.extension.imageResource
import app.view.map.model.CellLand
import app.view.map.model.CellSurroundings
import app.view.map.model.CellType

fun CellSurroundings.isTopLeft(type: CellType): Boolean {
    return top?.cellType == type && left?.cellType == type
}

fun CellSurroundings.isTopRight(type: CellType): Boolean {
    return top?.cellType == type && right?.cellType == type
}

fun CellSurroundings.isBotLeft(type: CellType): Boolean {
    return bot?.cellType == type && left?.cellType == type
}

fun CellSurroundings.isBotRight(type: CellType): Boolean {
    return bot?.cellType == type && right?.cellType == type
}


fun CellSurroundings.isTopLeftOrNull(type: CellType): Boolean {
    return isTopOrNull(type) && isLeftOrNull(type)
}

fun CellSurroundings.isTopRightOrNull(type: CellType): Boolean {
    return isTopOrNull(type) && isRightOrNull(type)
}

fun CellSurroundings.isBotLeftOrNull(type: CellType): Boolean {
    return isBotOrNull(type) && isLeftOrNull(type)
}

fun CellSurroundings.isBotRightOrNull(type: CellType): Boolean {
    return isBotOrNull(type) && isRightOrNull(type)
}

fun CellSurroundings.isTop(type: CellType): Boolean {
    return top?.cellType == type
}

fun CellSurroundings.isBot(type: CellType): Boolean {
    return bot?.cellType == type
}

fun CellSurroundings.isLeft(type: CellType): Boolean {
    return left?.cellType == type
}

fun CellSurroundings.isRight(type: CellType): Boolean {
    return right?.cellType == type
}

fun CellSurroundings.isTopOrNull(type: CellType): Boolean {
    return top == null || top.cellType == type
}

fun CellSurroundings.isBotOrNull(type: CellType): Boolean {
    return bot == null || bot.cellType == type
}

fun CellSurroundings.isLeftOrNull(type: CellType): Boolean {
    return left == null || left.cellType == type
}

fun CellSurroundings.isRightOrNull(type: CellType): Boolean {
    return right == null || right.cellType == type
}

fun CellType.cellLand(surroundings: CellSurroundings): CellLand {
    return if (this == CellType.WATER) {
        getWaterLand(surroundings)
    } else {
        CellLand(
            top1 = BitmapPainter(imageResource("land/${getTop1ResourcePath(surroundings)}")),
            top2 = BitmapPainter(imageResource("land/${getTop2ResourcePath(surroundings)}")),
            bot1 = BitmapPainter(imageResource("land/${getBot1ResourcePath(surroundings)}")),
            bot2 = BitmapPainter(imageResource("land/${getBot2ResourcePath(surroundings)}")),
        )
    }
}

private fun CellType.getTop1ResourcePath(surroundings: CellSurroundings): String {
    val pattern = when {
        surroundings.isTopLeftOrNull(this) -> ""

        surroundings.isTopLeft(CellType.WATER) -> Pattern.TOP_LEFT.getPath(CellType.SAND)
        surroundings.isTop(CellType.WATER) -> Pattern.TOP.getPath(CellType.SAND)
        surroundings.isLeft(CellType.WATER) -> Pattern.LEFT.getPath(CellType.SAND)

        surroundings.isTopLeft(CellType.SAND) -> Pattern.TOP_LEFT.getPath(CellType.SAND)
        surroundings.isTop(CellType.SAND) -> Pattern.TOP.getPath(CellType.SAND)
        surroundings.isLeft(CellType.SAND) -> Pattern.LEFT.getPath(CellType.SAND)
        else -> ""

    }
    return if (pattern.isEmpty()) {
        defaultPath
    } else {
        "${path}/${pattern}"
    }
}

private fun CellType.getTop2ResourcePath(surroundings: CellSurroundings): String {
    val pattern = when {
        surroundings.isTopRightOrNull(this) -> ""

        surroundings.isTopRight(CellType.WATER) -> Pattern.TOP_RIGHT.getPath(CellType.SAND)
        surroundings.isTop(CellType.WATER) -> Pattern.TOP.getPath(CellType.SAND)
        surroundings.isRight(CellType.WATER) -> Pattern.RIGHT.getPath(CellType.SAND)

        surroundings.isTopRight(CellType.SAND) -> Pattern.TOP_RIGHT.getPath(CellType.SAND)
        surroundings.isTop(CellType.SAND) -> Pattern.TOP.getPath(CellType.SAND)
        surroundings.isRight(CellType.SAND) -> Pattern.RIGHT.getPath(CellType.SAND)
        else -> ""
    }
    return if (pattern.isEmpty()) {
        defaultPath
    } else {
        "${path}/${pattern}"
    }
}

private fun CellType.getBot1ResourcePath(surroundings: CellSurroundings): String {
    val pattern = when {
        surroundings.isBotLeftOrNull(this) -> ""

        surroundings.isBotLeft(CellType.WATER) -> Pattern.BOT_LEFT.getPath(CellType.SAND)
        surroundings.isBot(CellType.WATER) -> Pattern.BOT.getPath(CellType.SAND)
        surroundings.isLeft(CellType.WATER) -> Pattern.LEFT.getPath(CellType.SAND)

        surroundings.isBotLeft(CellType.SAND) -> Pattern.BOT_LEFT.getPath(CellType.SAND)
        surroundings.isBot(CellType.SAND) -> Pattern.BOT.getPath(CellType.SAND)
        surroundings.isLeft(CellType.SAND) -> Pattern.LEFT.getPath(CellType.SAND)
        else -> ""
    }
    return if (pattern.isEmpty()) {
        defaultPath
    } else {
        "${path}/${pattern}"
    }
}

private fun CellType.getBot2ResourcePath(surroundings: CellSurroundings): String {
    val pattern = when {
        surroundings.isBotRightOrNull(this) -> ""

        surroundings.isBotRight(CellType.WATER) -> Pattern.BOT_RIGHT.getPath(CellType.SAND)
        surroundings.isBot(CellType.WATER) -> Pattern.BOT.getPath(CellType.SAND)
        surroundings.isRight(CellType.WATER) -> Pattern.RIGHT.getPath(CellType.SAND)

        surroundings.isBotRight(CellType.SAND) -> Pattern.BOT_RIGHT.getPath(CellType.SAND)
        surroundings.isBot(CellType.SAND) -> Pattern.BOT.getPath(CellType.SAND)
        surroundings.isRight(CellType.SAND) -> Pattern.RIGHT.getPath(CellType.SAND)
        else -> ""
    }
    return if (pattern.isEmpty()) {
        defaultPath
    } else {
        "${path}/${pattern}"
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

    fun getPath(type: CellType): String {
        return "${type.path}/${pattern}"
    }
}

fun CellType.randomLandPath(): String {
    return "land/${defaultPath}"
}