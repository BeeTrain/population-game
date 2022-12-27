package app.extension

fun <T> T?.or(other: T): T {
    return this ?: other
}

fun <T> random(vararg items: T): T {
    return items.random()
}