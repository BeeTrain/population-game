import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.res.loadImageBitmap
import androidx.compose.ui.res.useResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.singleWindowApplication
import app.PopulationApp

fun main() {
    singleWindowApplication(
        title = "Population",
        state = WindowState(width = 800.dp, height = 600.dp),
        icon = BitmapPainter(useResource("ic_launcher.png", ::loadImageBitmap)),
        content = { PopulationApp() }
    )
}