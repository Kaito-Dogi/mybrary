package app.kaito_dogi.mybrary.feature.mybooklist

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import app.kaito_dogi.mybrary.core.domain.model.MyBook

private const val MyBookList = "my-book-list"

const val MyBookListRoute = MyBookList

fun NavGraphBuilder.myBookListScreen(
  onAdditionClick: () -> Unit,
  onMyBookClick: (MyBook) -> Unit,
) {
  composable(
    route = MyBookListRoute,
  ) {
    MyBookListScreenContainer(
      onAdditionClick = onAdditionClick,
      onMyBookClick = onMyBookClick,
    )
  }
}
