package app.kaito_dogi.mybrary.core.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.navigation
import app.kaito_dogi.mybrary.core.ui.navigation.route.AppRoute
import app.kaito_dogi.mybrary.core.ui.navigation.route.AuthRoute

fun NavGraphBuilder.authNavGraph(
  startDestination: AuthRoute,
  builder: NavGraphBuilder.() -> Unit,
) = navigation<AppRoute.Auth>(
  startDestination = startDestination,
  builder = builder,
)
