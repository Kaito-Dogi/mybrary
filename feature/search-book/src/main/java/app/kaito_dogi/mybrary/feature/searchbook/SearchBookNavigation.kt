package app.kaito_dogi.mybrary.feature.searchbook

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.navigation
import app.kaito_dogi.mybrary.core.ui.navigation.route.MyBookRoute
import app.kaito_dogi.mybrary.core.ui.navigation.route.SearchBookRoute

fun NavGraphBuilder.searchBookNavGraph(
  startDestination: SearchBookRoute.SearchBook,
  builder: NavGraphBuilder.() -> Unit,
) = navigation<MyBookRoute.SearchBook>(
  startDestination = startDestination,
  builder = builder,
)
