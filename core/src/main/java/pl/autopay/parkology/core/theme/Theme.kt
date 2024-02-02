package pl.autopay.parkology.core.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColors = darkColors(
    primary = Purple80,
    primaryVariant = Purple80,
    secondary = PurpleGrey80,
    secondaryVariant = PurpleGrey80,
    onSurface = Color.White
)

private val LightColors = lightColors(
    primary = Purple40,
    primaryVariant = Purple40,
    secondary = PurpleGrey40,
    secondaryVariant = PurpleGrey40,
    onSurface = Color.Black
)

@Composable
fun ParkologyTheme(
    useDarkColors: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (useDarkColors) DarkColors else LightColors

    MaterialTheme(
        colors = colors,
        content = content
    )
}