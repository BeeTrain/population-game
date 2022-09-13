package app.view.map.land

val ash = listOf(
    "land/ash/tvlb000.png",
    "land/ash/tvlb001.png",
    "land/ash/tvlb002.png",
    "land/ash/tvlb003.png",
    "land/ash/tvlb004.png",
    "land/ash/tvlb005.png",
)

fun randomAshPath(): String {
    return ash.random()
}