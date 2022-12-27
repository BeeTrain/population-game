package app.view.map.model

import androidx.compose.ui.graphics.painter.Painter
import app.extension.random

private val defaultNames = listOf(
    "000.png",
    "001.png",
    "002.png",
    "003.png",
    "004.png",
    "005.png",
)

enum class Cell(val path: String) {
    WATER("water"),
    SAND("sand"),
    GROUND("ground"),
    GRASS("grass");

    fun defaultPath() = "${path}/${defaultNames.random()}"
}

fun createMapCells(
    width: Int,
    height: Int
): List<Cell> {
    return List(width * height) {
        random(Cell.WATER, Cell.GRASS)
    }
}

data class CellSurroundings(
    val top: Cell? = null,
    val bot: Cell? = null,
    val left: Cell? = null,
    val right: Cell? = null,
    val topleft: Cell? = null,
    val topright: Cell? = null,
    val botleft: Cell? = null,
    val botright: Cell? = null,
)

data class CellLand(
    val top1: Painter,
    val top2: Painter,
    val top3: Painter,
    val mid1: Painter,
    val mid2: Painter,
    val mid3: Painter,
    val bot1: Painter,
    val bot2: Painter,
    val bot3: Painter,
) {

    fun toList(): List<Painter> {
        return listOf(
            top1, top2, top3,
            mid1, mid2, mid3,
            bot1, bot2, bot3
        )
    }
}