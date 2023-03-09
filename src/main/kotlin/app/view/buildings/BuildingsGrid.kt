package app.view.buildings

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.extension.update
import app.state.AppState
import app.view.buildings.resources.BuildingsSelectorResources
import app.view.map.model.extension.buildings
import app.view.toast.state.showToast

@Composable
fun BuildingsGrid() {
    val availableBuildings = listOf(listOf(""), buildings).flatten()


    LazyVerticalGrid(
        modifier = Modifier.padding(16.dp),
        columns = GridCells.Fixed(10),

        ) {
        items(items = availableBuildings) { item ->
            Box(
                modifier = Modifier.size(30.dp)
            ) {
                Card(
                    modifier = Modifier.size(26.dp)
                        .clickable { onBuildingClick(item) }
                ) {
                    if (item.isEmpty()) {
                        Icon(
                            imageVector = BuildingsSelectorResources.buildNothingIcon,
                            contentDescription = null,
                            modifier = Modifier
                                .align(Alignment.Center)
                        )
                    } else {
                        Text(
                            text = item,
                            fontSize = 22.sp,
                            modifier = Modifier
                                .align(Alignment.Center)
                        )
                    }
                }
            }
        }
    }
}

private fun onBuildingClick(building: String) {
    AppState.buildingsSelector.selectBuilding(building)
    showToast("$building selected")
    AppState.buildingsSelector.isVisible.update { false }
}