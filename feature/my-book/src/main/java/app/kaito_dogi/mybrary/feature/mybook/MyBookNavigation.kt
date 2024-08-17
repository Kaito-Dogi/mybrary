package app.kaito_dogi.mybrary.feature.mybook

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import app.kaito_dogi.mybrary.core.navigation.MybraryRoute

fun NavGraphBuilder.myBookNavigation(
  startDestination: MyBookRoute,
  builder: NavGraphBuilder.(NavController) -> Unit,
) {
  composable<MybraryRoute.MyBook> {
    MyBookNavHost(
      startDestination = startDestination,
      builder = builder,
    )
  }
}
