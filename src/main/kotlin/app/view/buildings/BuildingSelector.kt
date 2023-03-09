package app.view.buildings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import app.extension.clickableNoRipple
import app.extension.nonClickable
import app.extension.update
import app.extension.visibility
import app.state.AppState

@Composable
fun BuildingSelector() {
    val isVisible by remember { AppState.buildingsSelector.isVisible }

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
                .clickableNoRipple { onBuildingSelectorCardClick() }
        ) {
            Box {
                Column {
                    BuildingsSelectorHeader()
                    BuildingsGrid()
                }
                BuildingDescription()
            }
        }
    }
}

private fun onBuildingSelectorCardClick() {
    AppState.buildingsSelector.selectedBuilding.update { "" }
}