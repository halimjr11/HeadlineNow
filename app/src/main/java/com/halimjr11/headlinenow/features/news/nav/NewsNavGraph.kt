package com.halimjr11.headlinenow.features.news.nav

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.halimjr11.headlinenow.domain.model.ArticleDomain
import com.halimjr11.headlinenow.features.news.NewsScreen
import com.halimjr11.headlinenow.utils.Constant.MAIN_ROUTE

fun NavGraphBuilder.newsNavGraph(
    onCardClick: (ArticleDomain) -> Unit
) {
    composable(route = MAIN_ROUTE) {
        NewsScreen(
            onCardClick = onCardClick
        )
    }
}
