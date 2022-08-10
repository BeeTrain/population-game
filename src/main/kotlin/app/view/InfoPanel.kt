package app.view

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.extension.visibility
import app.state.AppState


@Composable
@Preview
fun BoxScope.InfoPanel() {
    var populationStatusText by remember { AppState.populationStatusState }
    var isInfoWindowVisible by remember { AppState.isInfoWindowVisible }

    Column(
        modifier = Modifier.align(Alignment.TopStart).padding(16.dp)
    ) {
        Text(
            populationStatusText,
            fontSize = 14.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
                .padding(16.dp)
                .visibility(isInfoWindowVisible),
        )
    }
}