package app.extension

import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.loadImageBitmap
import androidx.compose.ui.res.useResource

fun imageResource(
    resourcePath: String,
): ImageBitmap = useResource(resourcePath, ::loadImageBitmap)