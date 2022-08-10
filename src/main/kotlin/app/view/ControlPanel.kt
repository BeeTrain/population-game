package app.view

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import app.extension.update
import app.extension.visibility
import app.state.AppState

@Composable
@Preview
fun BoxScope.ControlPanel() {
    var isInfoWindowVisible by remember { AppState.isInfoWindowVisible }

    Row(
        modifier = Modifier.align(Alignment.BottomEnd).padding(16.dp)
    ) {
        Button(
            modifier = Modifier.padding(8.dp).visibility(isInfoWindowVisible),
            onClick = {
                if (isInfoWindowVisible.not()) return@Button

                AppState.game.runCycle()
                AppState.populationStatusState.update(AppState.game.lifecycle.populationStatus())
            },
            content = { Text("Run cycle") }
        )
        Button(
            modifier = Modifier.padding(8.dp),
            onClick = {
                AppState.game.restartGame()
                AppState.populationStatusState.update(AppState.game.lifecycle.populationStatus())
            },
            content = { Text("Restart") }
        )
        Button(
            modifier = Modifier.padding(8.dp),
            onClick = {
                AppState.isInfoWindowVisible.update(isInfoWindowVisible.not())
            },
            content = { Text(if (isInfoWindowVisible) "Hide" else "Show") }
        )
    }
}