package app.view.map.model

enum class CellType {
    GROUND,
    WATER,
    SNOW,
    SAND,
    GRASS,
    ASH,
    STONES,
    SWAMP
}

val CellType?.isWater: Boolean
    get() = this == CellType.WATER

val CellType?.isWaterOrNull: Boolean
    get() = this == CellType.WATER || this == null

val CellType?.isGround: Boolean
    get() = this == CellType.GROUND

val CellType?.isSand: Boolean
    get() = this == CellType.SAND

val CellType?.isAsh: Boolean
    get() = this == CellType.ASH

val CellType?.isGrass: Boolean
    get() = this == CellType.GRASS

val CellType?.isSnow: Boolean
    get() = this == CellType.SNOW

val CellType?.isStones: Boolean
    get() = this == CellType.STONES

val CellType?.isSwamp: Boolean
    get() = this == CellType.SWAMP