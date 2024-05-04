package app.kaito_dogi.mybrary

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import app.kaito_dogi.feature.mybookdetail.myBookDetailScreen
import app.kaito_dogi.mybrary.feature.mybooklist.myBookListScreen

// TODO: destination の管理方法を検討する
@Composable
internal fun MybraryNavHost(
  modifier: Modifier = Modifier,
) {
  val navController = rememberNavController()

  NavHost(
    navController = navController,
    startDestination = "MyBookList",
    modifier = modifier.fillMaxSize(),
  ) {
    myBookListScreen(
      onAdditionClick = {},
      onMyBookClick = {
        navController.navigate("MyBookDetail")
      },
    )
    myBookDetailScreen()
  }
}
