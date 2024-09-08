package app.kaito_dogi.mybrary.feature.mybooklist

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import app.kaito_dogi.mybrary.core.domain.model.MyBook
import app.kaito_dogi.mybrary.core.ui.navigation.MybraryRoute
import app.kaito_dogi.mybrary.core.ui.navigation.createTypePair

fun NavGraphBuilder.myBookDetailScreen() {
  composable<MybraryRoute.MyBookDetail>(
    typeMap = mapOf(
      createTypePair<MyBook>(),
    ),
  ) {
    MyBookDetailScreenContainer()
  }
}
