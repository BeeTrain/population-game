package app.view.map.model

enum class CellType(val path: String) {
    GROUND("land/ground/ground.png"),
    WATER("land/water/water.png"),
    SNOW("land/snow/snow.png"),
    SAND("land/sand/sand.png"),
    GRASS("land/grass/grass.png"),
    ASH("land/ash/ash.png"),
    STONES("land/stones/stones.png"),
    SWAMP("land/swamp/swamp.png")
}

val CellType?.isWater: Boolean
    get() = this == CellType.WATER

val CellType?.isWaterOrNull: Boolean
    get() = this == CellType.WATER || this == null

val CellType?.isGround: Boolean
    get() = this == CellType.GROUND

val CellType?.isSand: Boolean
    get() = this == CellType.SAND