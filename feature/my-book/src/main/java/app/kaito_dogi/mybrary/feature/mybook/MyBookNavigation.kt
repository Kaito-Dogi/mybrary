package app.kaito_dogi.mybrary.feature.mybook

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import app.kaito_dogi.mybrary.core.ui.navigation.MainRoute

fun NavGraphBuilder.myBookDestination(
  startDestination: MyBookRoute,
  builder: NavGraphBuilder.(NavHostController) -> Unit,
) = composable<MainRoute.MyBook> {
  MyBookNavHost(
    startDestination = startDestination,
    builder = builder,
  )
}
