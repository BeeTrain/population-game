package app.extension

import androidx.compose.animation.slideInVertically

fun slideInVerticallyReversed() = slideInVertically(initialOffsetY = { it / 2 })