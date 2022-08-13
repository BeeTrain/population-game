package app.config.theme

import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

object ThemeColors {

    val primary = Color(0xFF4b2c20)
    val primaryVariant = Color(0xFFf9683a)
    val secondary = Color(0xFF4b2c20)
    val secondaryVariant = Color(0xFF6d4c41)
    val background = Color.White
    val surface = Color(0xFF718792)
    val error = Color.Red
    val onPrimary = Color.White
    val onSecondary = Color.White
    val onBackground = Color.Black
    val onSurface = Color.Black
    val onError = Color.White
    val highlight = Color(0xFFf4511e)
}

@Composable
fun colors(): Colors {
    return Colors(
        primary = ThemeColors.primary,
        primaryVariant = ThemeColors.primaryVariant,
        secondary = ThemeColors.secondary,
        secondaryVariant = ThemeColors.secondaryVariant,
        background = ThemeColors.background,
        surface = ThemeColors.surface,
        error = ThemeColors.error,
        onPrimary = ThemeColors.onPrimary,
        onSecondary = ThemeColors.onSecondary,
        onBackground = ThemeColors.onBackground,
        onSurface = ThemeColors.onSurface,
        onError = ThemeColors.onError,
        isLight = true
    )
}