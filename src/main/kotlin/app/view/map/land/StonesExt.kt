package app.view.map.land

val stones = listOf(
    "land/stones/trob000.png",
    "land/stones/trob001.png",
    "land/stones/trob002.png",
    "land/stones/trob003.png",
    "land/stones/trob004.png",
    "land/stones/trob005.png",
    "land/stones/trob006.png",
    "land/stones/trob007.png",
    "land/stones/trob010.png",
    "land/stones/trob011.png",
    "land/stones/trob012.png",
    "land/stones/trob013.png",
    "land/stones/trob014.png",
    "land/stones/trob015.png",
    "land/stones/trob016.png",
    "land/stones/trob017.png",
    "land/stones/trob018.png",
    "land/stones/trob019.png",
    "land/stones/trob020.png",
    "land/stones/trob021.png",
    "land/stones/trob022.png",
    "land/stones/trob023.png",
    "land/stones/trob024.png",
    "land/stones/trob025.png",
)

fun randomStonesPath(): String {
    return stones.random()
}