package com.halimjr11.headlinenow.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.halimjr11.headlinenow.utils.Constant.SPLASH_GRAPH

@Composable
fun NowNavGraph(
    navHostController: NavHostController,
    startDestination: String = SPLASH_GRAPH
) {
    NavHost(
        navController = navHostController,
        startDestination = startDestination
    ) {

    }
}