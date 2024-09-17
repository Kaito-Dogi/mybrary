package app.kaito_dogi.mybrary.feature.mybook.destination.mybooklist

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import app.kaito_dogi.mybrary.feature.mybook.MyBookRoute

fun NavGraphBuilder.myBookListScreen(
) = composable<MyBookRoute.MyBookList> {
  MyBookListScreenContainer()
}