package com.halimjr11.headlinenow.features.detail.nav

import android.net.Uri
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.google.gson.Gson
import com.halimjr11.headlinenow.domain.model.ArticleDomain
import com.halimjr11.headlinenow.features.detail.DetailScreen
import com.halimjr11.headlinenow.utils.Constant.DETAIL_ROUTE

fun NavGraphBuilder.detailNavGraph(
    onBackClick: () -> Unit,
    onRecommendedClick: (ArticleDomain) -> Unit
) {
    composable(
        route = DETAIL_ROUTE,
        arguments = listOf(navArgument("article") { type = NavType.StringType })
    ) { backStackEntry ->
        val articleJson = backStackEntry.arguments?.getString("article")
        val articleDomain = articleJson?.let {
            Gson().fromJson<ArticleDomain>(Uri.decode(it), ArticleDomain::class.java)
        } ?: ArticleDomain()

        DetailScreen(
            onBackClick = onBackClick,
            onRecommendedClick = onRecommendedClick,
            article = articleDomain
        )
    }
}
