package app.view.map.model.extension

const val NO_BUILDING = ""

val buildings = listOf(
    "π",
    "π",
    "π",
    "βͺοΈ",
    "π",
    "π",
    "π©",
    "π«",
    "π’",
    "π¬",
    "π£",
    "π€",
    "π₯",
    "π¦",
    "π¨",
    "πͺ",
    "π­",
    "π",
    "π",
    "π",
    "π‘",
    "π ",
    "βΊοΈ",
    "π°",
    "π―"
)

fun randomBuilding(): String {
    return buildings.random()
}