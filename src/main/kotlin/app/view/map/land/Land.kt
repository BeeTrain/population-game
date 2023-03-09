package app.view.map.land

import androidx.compose.foundation.Image
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import app.view.map.model.CellLand

@Composable
fun Land(cellLand: CellLand) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3)
    ) {
        items(cellLand.toList()) {
            Image(
                painter = it,
                contentDescription = null,
            )
        }
    }
}