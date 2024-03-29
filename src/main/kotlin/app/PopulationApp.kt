package app

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import app.config.theme.colors
import app.view.buildings.BuildingSelector
import app.view.control.ControlPanel
import app.view.gameinfo.GameInfoPanel
import app.view.info.InfoWindow
import app.view.map.buildings.BuildingsLayer
import app.view.map.land.LandsLayer
import app.view.settings.GameSettings
import app.view.toast.Toast

@Composable
@Preview
fun PopulationApp() {
    MaterialTheme(
        colors = colors()
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
        ) {
            LandsLayer()
            BuildingsLayer()

            InfoWindow()
            ControlPanel()
            GameInfoPanel()

            GameSettings()
            BuildingSelector()
            Toast()
        }
    }
}