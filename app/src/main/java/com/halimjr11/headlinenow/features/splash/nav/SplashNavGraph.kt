package com.halimjr11.headlinenow.features.splash.nav

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.halimjr11.headlinenow.features.splash.SplashScreen
import com.halimjr11.headlinenow.utils.Constant.SPLASH_GRAPH

fun NavGraphBuilder.splashNavGraph(
    toTopHeadline: () -> Unit,
) {
    composable(route = SPLASH_GRAPH) {
        SplashScreen(
            onNavigateNext = toTopHeadline
        )
    }
}
