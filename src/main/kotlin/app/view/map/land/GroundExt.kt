package app.view.map.land

val grounds = listOf(
    "land/ground/tdtb000.png",
    "land/ground/tdtb001.png",
    "land/ground/tdtb002.png",
    "land/ground/tdtb003.png",
    "land/ground/tdtb004.png",
    "land/ground/tdtb005.png",
    "land/ground/tdtb006.png",
    "land/ground/tdtb007.png",
)

fun randomGroundPath(): String {
    return grounds.random()
}