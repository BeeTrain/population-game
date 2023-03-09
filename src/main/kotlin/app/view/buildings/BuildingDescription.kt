package app.view.buildings

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.state.AppState
import app.view.buildings.resources.BuildingsSelectorResources

@Composable
fun BoxScope.BuildingDescription() {
    val selectedBuilding by remember { AppState.buildingsSelector.selectedBuilding }

    AnimatedVisibility(
        modifier = Modifier.align(Alignment.BottomCenter).padding(16.dp),
        visible = selectedBuilding.isNotEmpty(),
        enter = fadeIn(),
        exit = fadeOut()
    ) {
        Card(
            backgroundColor = Color.DarkGray
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
            ) {
                Text(
                    text = selectedBuilding,
                    fontSize = 14.sp,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(16.dp)
                )
                Row {
                    Button(
                        modifier = Modifier
                            .padding(8.dp),
                        onClick = { AppState.buildingsSelector.selectBuilding(selectedBuilding) },
                        content = { Text(BuildingsSelectorResources.selectBuildingButtonTitle) })
                }
            }
        }
    }
}