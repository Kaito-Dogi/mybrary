package app.kaito_dogi.mybrary.feature.mybook.destination.mybookdetail

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import app.kaito_dogi.mybrary.core.ui.navigation.route.MyBookRoute

fun EntryProviderScope<NavKey>.myBookDetailEntry(
  onNavigationIconClick: () -> Unit,
) = entry<MyBookRoute.MyBookDetail> { key ->
  MyBookDetailScreenContainer(
    myBook = key.myBook,
    onNavigationIconClick = onNavigationIconClick,
  )
}
