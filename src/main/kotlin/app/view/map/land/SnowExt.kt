package app.view.map.land

val snow = listOf(
    "land/snow/tsnb000.png",
    "land/snow/tsnb001.png",
    "land/snow/tsnb002.png",
    "land/snow/tsnb003.png",
    "land/snow/tsnb004.png",
    "land/snow/tsnb005.png",
    "land/snow/tsnb006.png",
    "land/snow/tsnb007.png",
)

fun randomSnowPath(): String {
    return snow.random()
}