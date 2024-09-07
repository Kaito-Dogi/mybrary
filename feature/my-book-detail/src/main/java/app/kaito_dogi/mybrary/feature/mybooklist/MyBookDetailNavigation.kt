package app.kaito_dogi.mybrary.feature.mybooklist

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import app.kaito_dogi.mybrary.core.domain.model.MyBook
import app.kaito_dogi.mybrary.core.navigation.MybraryRoute
import app.kaito_dogi.mybrary.core.navigation.createTypePair

fun NavGraphBuilder.myBookDetailScreen() {
  composable<MybraryRoute.MyBookDetail>(
    typeMap = mapOf(
      createTypePair<MyBook>(),
    ),
  ) {
    MyBookDetailScreenContainer()
  }
}
