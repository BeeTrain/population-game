package app.extension

fun Int.below(value: Int): Boolean {
    return value in Int.MIN_VALUE until this
}

fun Int.above(value: Int): Boolean {
    return this in value until Int.MAX_VALUE
}

fun Int.zeroOrLess(): Boolean {
    return this in Int.MIN_VALUE..0
}

fun Int.zeroOrMore(): Boolean {
    return this in 0..Int.MAX_VALUE
}