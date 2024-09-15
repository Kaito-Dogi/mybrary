package app.kaito_dogi.mybrary.core.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable

fun NavGraphBuilder.mainNavGraph(
  navController: NavHostController,
  startDestination: MainRoute,
  builder: NavGraphBuilder.() -> Unit,
) = composable<AppRoute.Main> {
  MainNavHost(
    navController = navController,
    startDestination = startDestination,
    builder = builder,
  )
}
