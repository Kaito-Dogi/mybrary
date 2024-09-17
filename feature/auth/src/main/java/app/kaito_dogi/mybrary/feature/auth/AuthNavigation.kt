package app.kaito_dogi.mybrary.feature.auth

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.navigation
import app.kaito_dogi.mybrary.core.ui.navigation.route.MybraryRoute
import app.kaito_dogi.mybrary.core.ui.navigation.route.AuthRoute

fun NavGraphBuilder.authNavGraph(
  startDestination: AuthRoute,
  builder: NavGraphBuilder.() -> Unit,
) = navigation<MybraryRoute.Auth>(
  startDestination = startDestination,
  builder = builder,
)
