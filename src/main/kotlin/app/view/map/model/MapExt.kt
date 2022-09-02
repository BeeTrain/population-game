package app.view.map.model

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
    "🏯",
    ""
)

fun randomBuilding(): String {
    return buildings.random()
}