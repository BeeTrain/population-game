package app.view.control

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import app.extension.visibility

@Composable
fun ColumnScope.ControlButton(
    title: String,
    visibility: Boolean = true,
    onClick: () -> Unit = { }
) {
    Button(
        modifier = Modifier
            .width(200.dp)
            .padding(horizontal = 16.dp, vertical = 4.dp)
            .visibility(visibility),
        onClick = {
            if (visibility.not()) return@Button

            onClick.invoke()
        },
        content = { Text(title) }
    )
}