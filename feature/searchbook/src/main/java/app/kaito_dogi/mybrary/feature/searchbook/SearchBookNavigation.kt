package app.kaito_dogi.mybrary.feature.searchbook

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

private const val SearchBook = "searchBook"

const val SearchBookRoute = SearchBook

fun NavGraphBuilder.searchBookScreen() {
  composable(
    route = SearchBookRoute,
  ) {
    SearchBookContainer()
  }
}
