package app.view.map.model

private val defaultNames = listOf(
    "000.png",
    "001.png",
    "002.png",
    "003.png",
    "004.png",
    "005.png",
)

enum class CellType(val path: String) {
    GROUND("ground"),
    WATER("water"),
    SNOW("snow"),
    SAND("sand"),
    GRASS("grass"),
    ASH("ash"),
    STONES("stones"),
    SWAMP("swamp");

    val defaultPath = "${path}/${defaultNames.random()}"
}

val CellType?.isWater: Boolean
    get() = this == CellType.WATER

val CellType?.isWaterOrNull: Boolean
    get() = this == CellType.WATER || this == null