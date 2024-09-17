package app.kaito_dogi.mybrary.feature.searchbook.destination.searchbook

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import app.kaito_dogi.mybrary.core.ui.navigation.route.SearchBookRoute

fun NavGraphBuilder.searchBookScreen() {
  composable<SearchBookRoute.SearchBook> {
    SearchBookScreenContainer()
  }
}

fun NavHostController.navigateToSearchBookScreen() = this.navigate(SearchBookRoute.SearchBook)
