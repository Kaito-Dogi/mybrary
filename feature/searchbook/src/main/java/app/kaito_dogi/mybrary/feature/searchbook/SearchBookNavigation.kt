package app.kaito_dogi.mybrary.feature.searchbook

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

private const val searchBook = "searchBook"

const val searchBookRoute = searchBook

fun NavGraphBuilder.searchBookScreen() {
  composable(
    route = searchBookRoute,
  ) {
    SearchBookContainer()
  }
}
