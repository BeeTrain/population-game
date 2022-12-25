package app.view.control

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.dp
import app.config.theme.ThemeColors
import app.extension.nonClickable
import app.extension.update
import app.model.lifecycle.PopulationStatus
import app.state.AppState
import app.view.control.resources.ControlPanelStrings

@Composable
fun BoxScope.ControlPanel() {
    val state = AppState.controlPanelState
    val lifecycleStatus by remember { AppState.game.lifecycleStatusState }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.align(Alignment.CenterEnd)
            .fillMaxHeight()
            .border(width = 1.dp, color = ThemeColors.secondaryVariant, shape = RectangleShape)
            .background(ThemeColors.secondaryVariant)
            .onGloballyPositioned { coordinates -> state.size.update { coordinates.size } }
            .nonClickable()
    ) {
        ControlButton(
            title = ControlPanelStrings.runCycleTitle,
            visibility = lifecycleStatus.population != PopulationStatus.Extinction,
            onClick = onRunCycleClick(),
        )
        ControlButton(
            title = ControlPanelStrings.restartTitle,
            onClick = onRestartClick()
        )
    }
}

private fun onRestartClick(): () -> Unit = {
    AppState.game.restartGame()
}

private fun onRunCycleClick(): () -> Unit = {
    AppState.game.runCycle()
}