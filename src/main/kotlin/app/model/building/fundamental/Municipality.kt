package app.model.building.fundamental

import androidx.compose.ui.graphics.ImageBitmap
import app.extension.imageResource
import app.model.building.Building
import app.model.building.BuildingType

object Municipality : Building() {

    override val title = "Prefecture"

    override val description = "Fundamental building of any settlement"

    override val mapModel: ImageBitmap get() = imageResource("buildings/municipality.png")

    override val type = BuildingType.FUNDAMENTAL

    override fun nextTier(): Building? = null
}