package app.kaito_dogi.mybrary

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import app.kaito_dogi.mybrary.feature.mybooklist.myBookListScreen

// TODO: destination の管理方法を検討する
@Composable
internal fun MybraryNavHost(
  modifier: Modifier = Modifier,
) {
  NavHost(
    navController = rememberNavController(),
    startDestination = "MyBookList",
    modifier = modifier.fillMaxSize(),
  ) {
    myBookListScreen()
  }
}
