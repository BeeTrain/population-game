package app.view.gameinfo

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import app.config.theme.ThemeColors
import app.extension.onHover
import app.view.toast.state.showToast

@Composable
fun RowScope.GameInfoCell(
    icon: ImageVector,
    text: String,
    description: String
) {
    val cellContentColor = remember { mutableStateOf(ThemeColors.onSecondary) }
    val textStyle = TextStyle()

    val mouseHover = Modifier.onHover { isHover ->
        if (isHover) {
            cellContentColor.value = ThemeColors.highlight
        } else {
            cellContentColor.value = ThemeColors.onSecondary
        }
    }

    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 4.dp)
            .then(mouseHover)
            .clickable { showToast(description) }
    ) {
        Icon(
            imageVector = icon,
            contentDescription = text,
            tint = cellContentColor.value
        )
        Text(
            text = text,
            modifier = Modifier.padding(8.dp),
            style = TextStyle(
                color = cellContentColor.value,
                fontSize = textStyle.fontSize,
                fontWeight = textStyle.fontWeight
            )
        )
    }
}