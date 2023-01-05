package app.view.settings.map

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import app.config.theme.ThemeColors

@Composable
fun MapSizeButton(
    isSelected: Boolean = false,
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
) {
    val backgroundColor = if (isSelected) ThemeColors.surface else ThemeColors.primary
    Button(
        modifier = modifier
            .size(64.dp)
            .padding(8.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = backgroundColor),
        content = { Text(text) },
        onClick = onClick
    )
}