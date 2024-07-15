package app.kaito_dogi.mybrary.feature.searchbooks

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

private const val SearchBooks = "search-books"

const val SearchBooksRoute = SearchBooks

fun NavGraphBuilder.searchBooksScreen() {
  composable(
    route = SearchBooksRoute,
  ) {
    SearchBooksScreenContainer()
  }
}
