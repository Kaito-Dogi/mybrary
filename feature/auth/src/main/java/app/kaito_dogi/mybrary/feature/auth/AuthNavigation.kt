package app.kaito_dogi.mybrary.feature.auth

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import app.kaito_dogi.mybrary.core.navigation.MybraryRoute

fun NavGraphBuilder.authNavigation(
  startDestination: AuthRoute,
  builder: NavGraphBuilder.(NavController) -> Unit,
) {
  composable<MybraryRoute.Auth> {
    AuthNavHost(
      startDestination = startDestination,
      builder = builder,
    )
  }
}
