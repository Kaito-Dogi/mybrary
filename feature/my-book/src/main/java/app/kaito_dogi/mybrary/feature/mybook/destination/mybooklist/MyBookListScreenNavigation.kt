package app.kaito_dogi.mybrary.feature.mybook.destination.mybooklist

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import app.kaito_dogi.mybrary.core.ui.navigation.route.MyBookRoute

fun NavGraphBuilder.myBookListScreen(
) = composable<MyBookRoute.MyBookList> {
  MyBookListScreenContainer()
}

fun NavHostController.navigateToMyBookListScreen() = this.navigate(MyBookRoute.MyBookList)
