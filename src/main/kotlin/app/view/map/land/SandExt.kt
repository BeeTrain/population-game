package app.view.map.land

val sands = listOf(
    "land/sand/tsab000.png",
    "land/sand/tsab001.png",
    "land/sand/tsab002.png",
    "land/sand/tsab003.png",
    "land/sand/tsab004.png",
    "land/sand/tsab005.png",
)

fun randomSandsPath(): String {
    return sands.random()
}