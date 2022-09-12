package app.view.map.land

val sands = listOf(
    "land/sand/tsub000.png",
    "land/sand/tsub001.png",
    "land/sand/tsub002.png",
    "land/sand/tsub003.png",
    "land/sand/tsub004.png",
    "land/sand/tsub005.png",
    "land/sand/tsub006.png",
    "land/sand/tsub007.png",
    "land/sand/tsub010.png",
    "land/sand/tsub011.png",
    "land/sand/tsub012.png",
    "land/sand/tsub013.png",
)

fun randomSandsPath(): String {
    return sands.random()
}