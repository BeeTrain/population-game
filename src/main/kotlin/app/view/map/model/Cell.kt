package app.view.map.model

import androidx.compose.ui.graphics.painter.Painter

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
    GROUND("ground"),
    GRASS("grass");

    fun defaultPath() = "${path}/${defaultNames.random()}"
}

fun createMapCells(
    width: Int,
    height: Int
): List<Cell> {
    return List(width * height) {
        Cell.values().random()
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
    val bot1: Painter,
    val bot2: Painter
) {

    fun toList(): List<Painter> {
        return listOf(top1, top2, bot1, bot2)
    }
}