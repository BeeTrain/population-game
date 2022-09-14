package app.view.map.model

import androidx.compose.ui.graphics.painter.Painter

val grounds = listOf(
    6, 7, 8,
    11, 12, 13,
    16, 17, 18
)

data class Cell(
    val index: Int,
    val cellType: CellType = if (index in grounds) CellType.STONES else CellType.GROUND,
    val building: String = ""
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