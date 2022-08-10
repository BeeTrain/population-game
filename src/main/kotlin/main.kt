import androidx.compose.ui.window.singleWindowApplication
import app.PopulationApp
import app.config.AppConfig

fun main() {
    with(AppConfig) {
        singleWindowApplication(
            title = title,
            state = windowState,
            resizable = isResizable,
            icon = launcherIcon,
            content = { PopulationApp() }
        )
    }
}