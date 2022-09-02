package app.view.gameinfo

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.DateRange
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.dp
import app.config.theme.ThemeColors
import app.extension.update
import app.state.AppState
import app.view.gameinfo.resources.GameInfoStrings

@Composable
fun BoxScope.GameInfoPanel() {
    val state = AppState.gameInfoPanelState
    val lifecycleStatus by remember { AppState.game.lifecycleStatusState }

    Row(
        modifier = Modifier.align(Alignment.BottomStart)
            .border(width = 1.dp, color = ThemeColors.secondaryVariant, shape = RectangleShape)
            .background(ThemeColors.secondary)
            .fillMaxWidth()
            .onGloballyPositioned { state.size.update(it.size) }
    ) {
        GameInfoCell(
            icon = Icons.Rounded.AccountCircle,
            text = lifecycleStatus.population.people.toString(),
            description = GameInfoStrings.populationDescription
        )
        GameInfoCell(
            icon = Icons.Rounded.DateRange,
            text = lifecycleStatus.period.cycle.toString(),
            description = GameInfoStrings.cyclesDescription
        )
    }
}