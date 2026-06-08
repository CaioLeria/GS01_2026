package cesarb98.com.github.t_space.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
    primary = AzulSideralMedio,
    secondary = AzulGeada,
    tertiary = AzulNoturnoFundo,
    background = PretoCosmico,
    surface = AzulNoturnoFundo,
    onPrimary = BrancoNeblina,
    onSecondary = BrancoNeblina,
    onBackground = BrancoNeblina,
    onSurface = BrancoNeblina
)

private val LightColorScheme = lightColorScheme(
    primary = AzulSideralMedio,
    secondary = AzulGeada,
    tertiary = AzulNoturnoFundo,
    background = PretoCosmico,
    surface = AzulNoturnoFundo,
    onPrimary = BrancoNeblina,
    onSecondary = BrancoNeblina,
    onBackground = BrancoNeblina,
    onSurface = BrancoNeblina
)

@Composable
fun TSpaceTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}