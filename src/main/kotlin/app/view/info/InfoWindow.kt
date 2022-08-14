package app.view.info

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.VerticalScrollbar
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.rememberScrollbarAdapter
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.state.AppState
import app.view.info.resources.InfoWindowIcons
import app.view.info.resources.InfoWindowStrings
import kotlinx.coroutines.launch

@Composable
@Preview
fun BoxScope.InfoWindow() {
    val isInfoWindowVisible by remember { AppState.infoWindow.isVisible }
    val infoWindowText by remember { AppState.infoWindow.text }
    val iconAlignment = if (isInfoWindowVisible) Alignment.End else Alignment.Start
    val scrollState = rememberScrollState(0)
    val coroutineScope = rememberCoroutineScope()

    coroutineScope.launch { scrollState.scrollTo(scrollState.maxValue) }

    if (infoWindowText.isEmpty()) return

    Card(
        backgroundColor = Color.LightGray,
        modifier = Modifier.align(Alignment.TopStart)
            .heightIn(50.dp, 300.dp)
            .padding(16.dp)
    ) {
        Column {
            Icon(
                imageVector = getIcon(isInfoWindowVisible),
                contentDescription = getContentDescription(isInfoWindowVisible),
                modifier = Modifier.padding(4.dp)
                    .align(iconAlignment)
                    .size(16.dp)
                    .clickable { onIconClick() }
            )
            if (isInfoWindowVisible) {
                Text(
                    text = infoWindowText,
                    fontSize = 14.sp,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                        .padding(8.dp)
                        .verticalScroll(scrollState)
                        .draggable(
                            orientation = Orientation.Vertical,
                            state = rememberDraggableState { delta ->
                                coroutineScope.launch {
                                    scrollState.scrollTo((scrollState.value + delta).toInt())
                                }
                            }
                        )
                )
            }
        }
        if (isInfoWindowVisible) {
            VerticalScrollbar(
                adapter = rememberScrollbarAdapter(scrollState),
                modifier = Modifier.align(Alignment.CenterEnd)
                    .heightIn(50.dp, 300.dp)
                    .padding(top = 24.dp)
            )
        }
    }
}

private fun getIcon(isInfoWindowVisible: Boolean): ImageVector {
    return if (isInfoWindowVisible) InfoWindowIcons.closeIcon else InfoWindowIcons.showIcon
}

private fun getContentDescription(isInfoWindowVisible: Boolean): String {
    return if (isInfoWindowVisible) InfoWindowStrings.hideText else InfoWindowStrings.showText
}

private fun onIconClick() {
    AppState.infoWindow.toggleIconClick()
}