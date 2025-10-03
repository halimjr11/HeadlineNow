package com.halimjr11.headlinenow.features.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.halimjr11.headlinenow.R

@Composable
fun SplashScreen(
    onNavigateNext: () -> Unit
) {
    val isDark = isSystemInDarkTheme()
    // Start a side-effect once this composable is shown
    LaunchedEffect(Unit) {
        kotlinx.coroutines.delay(3000) // 2 sec delay
        onNavigateNext()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = R.drawable.logo_transparent),
                contentDescription = "Splash Logo",
                modifier = Modifier.size(200.dp),
                contentScale = ContentScale.Fit,
                colorFilter = ColorFilter.tint(
                    if (isDark) Color.White else Color.Black
                )
            )

            Spacer(Modifier.height(16.dp))

            Text(
                text = stringResource(id = R.string.app_name),
                color = Color.White,
                style = MaterialTheme.typography.titleLarge
            )
        }
    }
}
