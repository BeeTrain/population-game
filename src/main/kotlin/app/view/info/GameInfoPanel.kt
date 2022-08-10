package app.view

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import app.state.AppState
import app.view.info.GameInfoCell

@Composable
@Preview
fun BoxScope.GameInfoPanel() {
    val populationSize by remember { AppState.game.populationSizeState }
    val cycleStatus by remember { AppState.game.cycleStatusState }

    Row(
        modifier = Modifier.align(Alignment.BottomStart)
            .border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(4.dp))
            .background(Color.LightGray).fillMaxWidth()
    ) {
        GameInfoCell(populationSize)
        GameInfoCell(cycleStatus)
    }
}