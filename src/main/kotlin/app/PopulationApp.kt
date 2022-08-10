package app

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import app.view.ControlPanel
import app.view.GameInfoPanel
import app.view.LogInfoPanel

@Composable
@Preview
fun PopulationApp() {
    MaterialTheme {
        Box(Modifier.fillMaxSize()) {
            LogInfoPanel()
            ControlPanel()
            GameInfoPanel()
        }
    }
}