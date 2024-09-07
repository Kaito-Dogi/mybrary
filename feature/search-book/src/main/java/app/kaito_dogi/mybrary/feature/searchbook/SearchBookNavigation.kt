package app.kaito_dogi.mybrary.feature.searchbook

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import app.kaito_dogi.mybrary.core.ui.navigation.MybraryRoute

fun NavGraphBuilder.searchBookScreen() {
  composable<MybraryRoute.SearchBook> {
    SearchBookScreenContainer()
  }
}
