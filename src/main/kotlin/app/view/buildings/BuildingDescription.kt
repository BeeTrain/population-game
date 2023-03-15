package app.view.buildings

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import app.extension.nonClickable
import app.state.AppState
import app.view.buildings.resources.BuildingsSelectorResources

@Composable
fun BoxScope.BuildingDescription() {
    val selectedBuilding by remember { AppState.buildingsSelector.selectedBuilding }

    AnimatedVisibility(
        modifier = Modifier.align(Alignment.BottomCenter).padding(16.dp),
        visible = selectedBuilding != null,
        enter = fadeIn(),
        exit = fadeOut()
    ) {
        selectedBuilding?.let { building ->
            Card(
                modifier = Modifier.nonClickable(),
                backgroundColor = Color.DarkGray.copy(alpha = 0.6f)
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                ) {
                    Image(
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .size(80.dp)
                            .padding(16.dp),
                        bitmap = building.mapModel,
                        contentDescription = building.title
                    )
                    Text(
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(4.dp),
                        text = building.title,
                        fontSize = 14.sp
                    )
                    Text(
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(4.dp),
                        text = building.description,
                        fontSize = 12.sp
                    )
                    Button(
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(8.dp),
                        onClick = { AppState.buildingsSelector.selectBuilding(building) },
                        content = { Text(BuildingsSelectorResources.selectBuildingButtonTitle) }
                    )
                }
            }
        }
    }
}