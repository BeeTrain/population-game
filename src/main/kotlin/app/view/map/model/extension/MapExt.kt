package app.view.map.model.extension

const val NO_BUILDING = ""

val buildings = listOf(
    "🛕",
    "🕍",
    "🕌",
    "⛪️",
    "🏛",
    "💒",
    "🏩",
    "🏫",
    "🏢",
    "🏬",
    "🏣",
    "🏤",
    "🏥",
    "🏦",
    "🏨",
    "🏪",
    "🏭",
    "🏗",
    "🏚",
    "🏘",
    "🏡",
    "🏠",
    "⛺️",
    "🏰",
    "🏯"
)

fun randomBuilding(): String {
    return buildings.random()
}