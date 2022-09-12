package app.view.map.land

val swamp = listOf(
    "land/swamp/tswb000.png",
    "land/swamp/tswb001.png",
    "land/swamp/tswb002.png",
    "land/swamp/tswb003.png",
    "land/swamp/tswb004.png",
    "land/swamp/tswb005.png",
    "land/swamp/tswb006.png",
    "land/swamp/tswb007.png",
    "land/swamp/tswb010.png",
    "land/swamp/tswb011.png",
    "land/swamp/tswb012.png",
    "land/swamp/tswb013.png",
    "land/swamp/tswb014.png",
)

fun randomSwampPath(): String {
    return swamp.random()
}