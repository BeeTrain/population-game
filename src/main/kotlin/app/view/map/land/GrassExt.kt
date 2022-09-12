package app.view.map.land

val grasses = listOf(
    "land/grass/tgrb000.png",
    "land/grass/tgrb001.png",
    "land/grass/tgrb002.png",
    "land/grass/tgrb003.png",
    "land/grass/tgrb004.png",
    "land/grass/tgrb005.png",
    "land/grass/tgrb006.png",
    "land/grass/tgrb007.png",
    "land/grass/tgrb010.png",
    "land/grass/tgrb011.png",
    "land/grass/tgrb012.png",
    "land/grass/tgrb013.png",
    "land/grass/tgrb014.png",
    "land/grass/tgrb015.png",
    "land/grass/tgrb016.png",
    "land/grass/tgrb018.png",
    "land/grass/tgrb019.png",
    "land/grass/tgrb020.png",
    "land/grass/tgrb021.png",
)

fun randomGrassPath(): String {
    return grasses.random()
}