package app.view.map.land

val sands = listOf(
    "land/sand/000.png",
    "land/sand/001.png",
    "land/sand/002.png",
    "land/sand/003.png",
    "land/sand/004.png",
    "land/sand/005.png",
)

fun randomSandsPath(): String {
    return sands.random()
}