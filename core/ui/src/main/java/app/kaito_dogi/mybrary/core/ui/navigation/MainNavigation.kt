package app.kaito_dogi.mybrary.core.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable

fun NavGraphBuilder.mainNavGraph(
  startDestination: MainRoute,
  builder: NavGraphBuilder.(NavHostController) -> Unit,
) = composable<AppRoute.Main> {
  MainNavHost(
      startDestination = startDestination,
      builder = builder,
  )
}
