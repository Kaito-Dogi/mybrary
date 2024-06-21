package app.kaito_dogi.mybrary.feature.mybooklist

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import app.kaito_dogi.mybrary.core.domain.model.MyBook

private const val myBookList = "myBookList"

const val myBookListRoute = myBookList

fun NavGraphBuilder.myBookListScreen(
  onAdditionClick: () -> Unit,
  onMyBookClick: (MyBook) -> Unit,
) {
  composable(
    route = myBookListRoute,
  ) {
    MyBookListContainer(
      onAdditionClick = onAdditionClick,
      onMyBookClick = onMyBookClick,
    )
  }
}
