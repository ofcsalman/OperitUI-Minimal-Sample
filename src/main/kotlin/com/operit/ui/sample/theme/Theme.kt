package com.operit.ui.sample.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF6C63FF),
    secondary = Color(0xFFFF6B9D),
    tertiary = Color(0xFF00D9FF),
    background = Color(0xFF0F0E17),
    surface = Color(0xFF1A1922),
    onBackground = Color(0xFFE0E0E0),
    onSurface = Color(0xFFE0E0E0)
)

val LightColorScheme = lightColorScheme(
    primary = Color(0xFF6C63FF),
    secondary = Color(0xFFFF6B9D),
    tertiary = Color(0xFF00D9FF),
    background = Color(0xFFF5F5F5),
    surface = Color(0xFFFFFFFF)
)

@Composable
fun OperitTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}