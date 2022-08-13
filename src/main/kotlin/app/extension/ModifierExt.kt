package app.extension

import androidx.compose.runtime.Stable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.input.pointer.pointerMoveFilter

@Stable
fun Modifier.visibility(
    isVisible: Boolean
) = alpha(if (isVisible) 1f else 0f)

@OptIn(ExperimentalComposeUiApi::class)
fun Modifier.onHover(hasHover: (Boolean) -> Unit): Modifier = composed {
    val isHover = remember { mutableStateOf(false) }
    hasHover.invoke(isHover.value)

    pointerMoveFilter(
        onEnter = { isHover.value = true; true },
        onExit = { isHover.value = false; true }
    )
}