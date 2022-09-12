package app.view.map.model

import androidx.compose.ui.graphics.painter.Painter
import app.view.map.extension.cellImage

data class Cell(
    val index: Int,
    val cellType: CellType = CellType.GROUND,
    val land: Painter = cellImage(cellType),
    val building: String = ""
)