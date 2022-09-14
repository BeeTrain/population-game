package app.view.map.extension

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

fun randomBuilding(chance: Int = 100): String {
    val variants = List(100) { index ->
        if (index < chance) {
             buildings.random()
        } else {
            ""
        }
    }
    return variants.random()
}