package app.kaito_dogi.mybrary.feature.mybook.destination.mybookdetail

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import app.kaito_dogi.mybrary.core.domain.model.MyBook
import app.kaito_dogi.mybrary.core.ui.navigation.route.MyBookRoute

fun NavGraphBuilder.myBookDetailScreen(
  onNavigationIconClick: () -> Unit,
) = composable<MyBookRoute.MyBookDetail>(typeMap = MyBookDetailTypeMap) {
  MyBookDetailScreenContainer(
    onNavigationIconClick = onNavigationIconClick,
  )
}

fun NavHostController.navigateToMyBookDetailScreen(
  myBook: MyBook,
) = this.navigate(
  route = MyBookRoute.MyBookDetail(
    myBook = myBook,
  ),
)
