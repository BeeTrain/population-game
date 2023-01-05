package app.view.settings.map

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import app.model.game.MapSize
import app.state.AppState

@Composable
fun MapSizeRow() {
    val state = remember { AppState.settings }
    Row(
        modifier = Modifier
            .padding(16.dp)
    ) {
        Text(
            modifier = Modifier
                .align(Alignment.CenterVertically),
            text = "Map size"
        )
        Spacer(Modifier.weight(1f).fillMaxWidth())
        MapSizeButton(
            isSelected = state.mapSize.value == MapSize.SIZE_S,
            text = "S",
            onClick = { state.updateMapSize(MapSize.SIZE_S) }
        )
        MapSizeButton(
            isSelected = state.mapSize.value == MapSize.SIZE_M,
            text = "M",
            onClick = { state.updateMapSize(MapSize.SIZE_M) }
        )
        MapSizeButton(
            isSelected = state.mapSize.value == MapSize.SIZE_L,
            text = "L",
            onClick = { state.updateMapSize(MapSize.SIZE_L) }
        )
    }
}