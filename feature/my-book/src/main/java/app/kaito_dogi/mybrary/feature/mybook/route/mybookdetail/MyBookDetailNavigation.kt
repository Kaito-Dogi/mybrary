package app.kaito_dogi.mybrary.feature.mybook.route.mybookdetail

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import app.kaito_dogi.mybrary.core.domain.model.MyBook
import app.kaito_dogi.mybrary.core.navigation.createTypePair
import app.kaito_dogi.mybrary.feature.mybook.MyBookRoute

fun NavGraphBuilder.myBookDetailScreen() {
  composable<MyBookRoute.MyBookDetail>(
    typeMap = mapOf(
      createTypePair<MyBook>(),
    ),
  ) {
    MyBookDetailScreenContainer()
  }
}
