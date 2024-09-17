package app.kaito_dogi.mybrary.feature.mybook.destination.mybooklist

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import app.kaito_dogi.mybrary.core.domain.model.MyBook
import app.kaito_dogi.mybrary.core.ui.navigation.route.MyBookRoute

fun NavGraphBuilder.myBookListScreen(
  onAdditionClick: () -> Unit,
  onMyBookClick: (MyBook) -> Unit,
) = composable<MyBookRoute.MyBookList> {
  MyBookListScreenContainer(
    onAdditionClick = onAdditionClick,
    onMyBookClick = onMyBookClick,
  )
}

fun NavHostController.navigateToMyBookListScreen() = this.navigate(MyBookRoute.MyBookList)
