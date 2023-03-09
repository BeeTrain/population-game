package app.extension

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.Stable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.input.pointer.PointerEventType
import androidx.compose.ui.input.pointer.onPointerEvent

@Stable
fun Modifier.visibility(
    isVisible: Boolean
) = alpha(if (isVisible) 1f else 0f)

@OptIn(ExperimentalComposeUiApi::class)
fun Modifier.onHover(hasHover: (Boolean) -> Unit): Modifier = composed {
    val isHover = remember { mutableStateOf(false) }
    hasHover.invoke(isHover.value)

    onPointerEvent(PointerEventType.Enter) { isHover.value = true }
        .onPointerEvent(PointerEventType.Exit) { isHover.value = false }
}

fun Modifier.nonClickable() = clickable(
    interactionSource = MutableInteractionSource(),
    indication = null,
    onClick = {}
)