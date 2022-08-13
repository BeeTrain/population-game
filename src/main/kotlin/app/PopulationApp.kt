package app

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import app.config.theme.colors
import app.view.LogInfoPanel
import app.view.Toast
import app.view.control.ControlPanel
import app.view.info.GameInfoPanel

@Composable
@Preview
fun PopulationApp() {
    MaterialTheme(
        colors = colors()
    ) {
        Box(Modifier.fillMaxSize()) {
            LogInfoPanel()
            ControlPanel()
            GameInfoPanel()
            Toast()
        }
    }
}