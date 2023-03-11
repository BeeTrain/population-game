package app.view.buildings

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import app.extension.update
import app.model.building.buildings
import app.state.AppState

@Composable
fun BuildingsGrid() {
    LazyVerticalGrid(
        modifier = Modifier.padding(16.dp),
        columns = GridCells.Fixed(8),

        ) {
        items(items = buildings) { item ->
            Box(
                modifier = Modifier.size(56.dp)
            ) {
                Card {
                    Box(
                        modifier = Modifier.size(42.dp)
                    ) {
                        Image(
                            modifier = Modifier
                                .align(Alignment.Center)
                                .clickable { AppState.buildingsSelector.selectedBuilding.update { item } },
                            bitmap = item.mapModel,
                            contentDescription = item.title
                        )
                    }
                }
            }
        }
    }
}