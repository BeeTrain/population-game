package app.config

import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.WindowState
import app.extension.imageResource

object AppConfig {

    val title = "Population game"
    val windowState = WindowState(width = 800.dp, height = 600.dp)
    val isResizable = false
    val launcherIcon = BitmapPainter(imageResource("icons/ic_launcher.png"))
}