package com.halimjr11.headlinenow.features.detail.nav

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.halimjr11.headlinenow.features.detail.DetailScreen
import com.halimjr11.headlinenow.utils.Constant.DETAIL_ROUTE

fun NavGraphBuilder.detailNavGraph(
    toOnBoarding: () -> Unit,
    toLogin: () -> Unit,
    toSetProfile: () -> Unit,
    toTopLevelNavigation: () -> Unit
) {
    composable(route = DETAIL_ROUTE) {
        DetailScreen (
            toOnBoarding = toOnBoarding,
            toLogin = toLogin,
            toSetProfile = toSetProfile,
            toTopLevelNavigation = toTopLevelNavigation
        )
    }
}
