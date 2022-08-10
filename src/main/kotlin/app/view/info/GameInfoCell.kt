package app.view.info

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
@Preview
fun RowScope.GameInfoCell(text: String) {
    Text(
        text = text,
        modifier = Modifier.padding(8.dp)
    )
}