package app.view

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import app.extension.update
import app.state.AppState

@Composable
@Preview
fun BoxScope.ControlPanel() {
    val isInfoWindowVisible by remember { AppState.isInfoWindowVisible }

    Column(
        modifier = Modifier.align(Alignment.CenterEnd)
            .fillMaxHeight()
            .border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(4.dp))
            .background(Color.LightGray),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ControlButton(
            title = "Run cycle",
            onClick = onRunCycleClick()
        )
        ControlButton(
            title = "Restart", onClick = onRestartClick()
        )
        ControlButton(
            title = getVisibilityButtonTitle(isInfoWindowVisible),
            onClick = onVisibilityButtonClick(isInfoWindowVisible)
        )
    }
}

private fun getVisibilityButtonTitle(isInfoWindowVisible: Boolean): String {
    return if (isInfoWindowVisible) "Hide" else "Show"
}

private fun onVisibilityButtonClick(isInfoWindowVisible: Boolean): () -> Unit = {
    AppState.isInfoWindowVisible.update(isInfoWindowVisible.not())
}

private fun onRestartClick(): () -> Unit = {
    AppState.game.restartGame()
}

private fun onRunCycleClick(): () -> Unit = {
    AppState.game.runCycle()
}