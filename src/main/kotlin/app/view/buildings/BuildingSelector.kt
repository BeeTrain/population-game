package app.view.buildings

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import app.extension.nonClickable
import app.extension.update
import app.extension.visibility
import app.state.AppState
import app.view.buildings.resources.BuildingsSelectorResources

@Composable
fun BoxScope.BuildingSelector() {
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
        ) {
            Column {
                BuildingsSelectorHeader()
                BuildingsGrid()
            }
        }
    }
}


@Composable
private fun BuildingsSelectorHeader() {
    Row(
        modifier = Modifier
            .padding(8.dp)
    ) {
        Spacer(Modifier.weight(1f).fillMaxWidth())
        Icon(
            imageVector = BuildingsSelectorResources.closeIcon,
            contentDescription = null,
            modifier = Modifier
                .size(16.dp)
                .clickable { onCloseIconClick() }
        )
    }
}

private fun onCloseIconClick() {
    AppState.buildingsSelector.isVisible.update { false }
}