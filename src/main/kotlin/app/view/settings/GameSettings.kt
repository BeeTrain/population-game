package app.view.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import app.extension.nonClickable
import app.extension.update
import app.extension.visibility
import app.state.AppState
import app.view.info.resources.InfoWindowIcons
import app.view.settings.map.MapSizeRow

@Composable
fun BoxScope.GameSettings() {
    val isVisible by remember { AppState.settings.isVisible }

    if (isVisible.not()) return

    Box(
        modifier = Modifier
            .visibility(isVisible)
            .fillMaxSize()
            .background(Color.Black.copy(alpha = 0.5f))
            .nonClickable()
    ) {
        Card(
            backgroundColor = Color.LightGray,
            modifier = Modifier
                .size(400.dp, 350.dp)
                .align(Alignment.Center)
        ) {
            Column {
                SettingsHeader()
                MapSizeRow()
            }
        }
    }
}

@Composable
private fun SettingsHeader() {
    Row(
        modifier = Modifier
            .padding(8.dp)
    ) {
        Spacer(Modifier.weight(1f).fillMaxWidth())
        Icon(
            imageVector = InfoWindowIcons.closeIcon,
            contentDescription = null,
            modifier = Modifier
                .size(16.dp)
                .clickable { onCloseIconClick() }
        )
    }
}

private fun onCloseIconClick() {
    AppState.settings.isVisible.update { false }
}