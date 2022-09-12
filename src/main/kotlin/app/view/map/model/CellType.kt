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