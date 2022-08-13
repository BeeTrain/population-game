package app.view

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.extension.update
import app.state.AppState


@Composable
@Preview
fun BoxScope.InfoWindow() {
    val isInfoWindowVisible by remember { AppState.isInfoWindowVisible }
    val infoWindowText by remember { AppState.infoWindowText }
    val iconAlignment = if (isInfoWindowVisible) Alignment.End else Alignment.Start

    if (infoWindowText.isEmpty()) return

    Column(
        modifier = Modifier.align(Alignment.TopStart)
            .heightIn(50.dp, 300.dp)
            .padding(16.dp)
    ) {
        Card(
            backgroundColor = Color.LightGray
        ) {
            Column {
                Image(
                    imageVector = getIcon(isInfoWindowVisible),
                    contentDescription = getContentDescription(isInfoWindowVisible),
                    modifier = Modifier.padding(4.dp)
                        .align(iconAlignment)
                        .size(16.dp)
                        .clickable { onIconClick(isInfoWindowVisible) }
                )
                if (isInfoWindowVisible) {
                    Text(
                        text = infoWindowText,
                        fontSize = 14.sp,
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                            .padding(8.dp)
                    )
                }
            }
        }
    }
}

private fun getIcon(isInfoWindowVisible: Boolean): ImageVector {
    return if (isInfoWindowVisible) Icons.Default.Close else Icons.Default.Info
}

private fun getContentDescription(isInfoWindowVisible: Boolean): String {
    return if (isInfoWindowVisible) "Hide" else "Show"
}

private fun onIconClick(isInfoWindowVisible: Boolean) {
    AppState.isInfoWindowVisible.update(isInfoWindowVisible.not())
}