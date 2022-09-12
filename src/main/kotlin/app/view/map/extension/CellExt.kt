package app.view.map.extension

import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.graphics.painter.Painter
import app.extension.imageResource
import app.view.map.land.randomAshPath
import app.view.map.land.randomGrassPath
import app.view.map.land.randomGroundPath
import app.view.map.land.randomSandsPath
import app.view.map.land.randomSnowPath
import app.view.map.land.randomStonesPath
import app.view.map.land.randomSwampPath
import app.view.map.land.randomWaterPath
import app.view.map.model.CellType

fun cellImage(cellType: CellType): Painter {
    val path = when (cellType) {
        CellType.GROUND -> randomGroundPath()
        CellType.GRASS -> randomGrassPath()
        CellType.STONES -> randomStonesPath()
        CellType.SNOW -> randomSnowPath()
        CellType.SWAMP -> randomSwampPath()
        CellType.ASH -> randomAshPath()
        CellType.WATER -> randomWaterPath()
        CellType.SAND -> randomSandsPath()
    }

    return BitmapPainter(imageResource(path))
}