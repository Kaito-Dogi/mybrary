package app.kaito_dogi.mybrary.feature.searchbook.destination.searchbook

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import app.kaito_dogi.mybrary.core.ui.navigation.route.SearchBookRoute

fun EntryProviderScope<NavKey>.searchBookEntry() = entry<SearchBookRoute.SearchBook> {
  SearchBookScreenContainer()
}
