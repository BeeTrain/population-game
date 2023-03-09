package app.view.buildings

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import app.extension.update
import app.state.AppState
import app.view.buildings.resources.BuildingsSelectorResources

@Composable
fun BuildingsSelectorHeader() {
    Row(
        modifier = Modifier.padding(8.dp)
    ) {
        Spacer(Modifier.weight(1f).fillMaxWidth())
        Icon(
            modifier = Modifier
                .size(16.dp)
                .clickable { onCloseIconClick() },
            imageVector = BuildingsSelectorResources.closeIcon,
            contentDescription = null
        )
    }
}

private fun onCloseIconClick() {
    AppState.buildingsSelector.isVisible.update { false }
}
