package app.view.map

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import app.view.map.model.CellLand

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Land(cellLand: CellLand) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(2)
    ) {
        items(cellLand.toList()) {
            Image(
                painter = it,
                contentDescription = null,
            )
        }
    }
}