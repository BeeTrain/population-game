package app.model.building

import androidx.compose.ui.graphics.ImageBitmap
import app.model.building.fundamental.Municipality
import app.model.building.fundamental.VillageCouncil

enum class BuildingType {
    FUNDAMENTAL
}

abstract class Building {

    abstract val title: String

    abstract val description: String

    abstract val mapModel: ImageBitmap

    abstract val type: BuildingType

    abstract fun nextTier(): Building?

    protected fun upgrade(): Building {
        return nextTier() ?: this
    }
}

val buildings = listOf<Building>(
    VillageCouncil,
    Municipality
)