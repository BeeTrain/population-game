package app.view.map.land

val grasses = listOf(
    "land/grass/tgrb000.png",
    "land/grass/tgrb001.png",
    "land/grass/tgrb002.png",
    "land/grass/tgrb003.png",
    "land/grass/tgrb004.png",
    "land/grass/tgrb005.png",
)

fun randomGrassPath(): String {
    return grasses.random()
}