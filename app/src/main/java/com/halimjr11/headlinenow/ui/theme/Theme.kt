package com.halimjr11.headlinenow.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = BluePrimary,
    onPrimary = White,
    secondary = BlueHighlight,
    onSecondary = White,
    background = NavyDark,
    onBackground = White,
    surface = NavySurface,
    onSurface = White,
    error = RedError,
    onError = White,
    outline = Outline,
)

private val LightColorScheme = lightColorScheme(
    primary = BluePrimary,
    onPrimary = White,
    secondary = BlueHighlight,
    onSecondary = White,
    background = White,
    onBackground = NavyDark,
    surface = Color(0xFFF6F6F6),
    onSurface = NavyDark,
    error = RedError,
    onError = White,
    outline = Outline,
)

@Composable
fun HeadlineNowTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}