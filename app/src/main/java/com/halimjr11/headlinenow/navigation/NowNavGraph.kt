package com.halimjr11.headlinenow.navigation

import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.google.gson.Gson
import com.halimjr11.headlinenow.features.detail.nav.detailNavGraph
import com.halimjr11.headlinenow.features.news.nav.newsNavGraph
import com.halimjr11.headlinenow.features.splash.nav.splashNavGraph
import com.halimjr11.headlinenow.utils.Constant.MAIN_ROUTE
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
        splashNavGraph {
            navHostController.popBackStack()
            navHostController.navigate(MAIN_ROUTE)
        }
        newsNavGraph { article ->
            val articleDomain = Uri.encode(Gson().toJson(article))
            navHostController.navigate("detail/$articleDomain")
        }
        detailNavGraph(
            onBackClick = {
                navHostController.popBackStack()
            },
            onRecommendedClick = { article ->
                val articleDomain = Gson().toJson(article)
                navHostController.navigate("detail/$articleDomain")
            }
        )
    }
}