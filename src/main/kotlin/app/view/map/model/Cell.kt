package app.view.map.model

import androidx.compose.ui.graphics.painter.Painter
import app.view.map.extension.cellImage

data class Cell(
    val index: Int,
    val cellType: CellType = if (index in grounds) CellType.GROUND else CellType.SAND,
    val land: Painter = cellImage(cellType),
    val building: String = ""
)

val grounds = listOf(6, 7, 8, 11, 12, 13, 16, 17, 18)

data class CellSurroundings(
    val top: Cell?,
    val bottom: Cell?,
    val left: Cell?,
    val right: Cell?
)