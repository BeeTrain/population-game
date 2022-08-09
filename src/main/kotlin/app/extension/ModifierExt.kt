package app.extension

import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha

@Stable
fun Modifier.visibility(
    isVisible: Boolean
) = alpha(if (isVisible) 1f else 0f)