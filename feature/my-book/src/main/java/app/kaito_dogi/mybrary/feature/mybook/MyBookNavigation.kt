package app.kaito_dogi.mybrary.feature.mybook

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.navigation
import app.kaito_dogi.mybrary.core.ui.navigation.route.MainRoute
import app.kaito_dogi.mybrary.core.ui.navigation.route.MyBookRoute

fun NavGraphBuilder.myBookDestination(
  startDestination: MyBookRoute,
  builder: NavGraphBuilder.() -> Unit,
) = navigation<MainRoute.MyBook>(
  startDestination = startDestination,
  builder = builder,
)
