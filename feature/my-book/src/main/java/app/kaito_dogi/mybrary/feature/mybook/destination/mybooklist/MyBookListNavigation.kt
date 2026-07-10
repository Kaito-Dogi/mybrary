package app.kaito_dogi.mybrary.feature.mybook.destination.mybooklist

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import app.kaito_dogi.mybrary.core.domain.model.MyBook
import app.kaito_dogi.mybrary.core.ui.navigation.route.MyBookRoute

fun EntryProviderScope<NavKey>.myBookListEntry(
  onSettingClick: () -> Unit,
  onAdditionClick: () -> Unit,
  onMyBookClick: (MyBook) -> Unit,
) = entry<MyBookRoute.MyBookList> {
  MyBookListScreenContainer(
    onSettingClick = onSettingClick,
    onAdditionClick = onAdditionClick,
    onMyBookClick = onMyBookClick,
  )
}
