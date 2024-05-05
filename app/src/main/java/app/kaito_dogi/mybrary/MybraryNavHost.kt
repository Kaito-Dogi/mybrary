package app.kaito_dogi.mybrary

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import app.kaito_dogi.mybrary.feature.mybookdetail.MyBookDetailNavArg
import app.kaito_dogi.mybrary.feature.mybookdetail.myBookDetailRoute
import app.kaito_dogi.mybrary.feature.mybookdetail.myBookDetailScreen
import app.kaito_dogi.mybrary.feature.mybooklist.myBookListRoute
import app.kaito_dogi.mybrary.feature.searchbook.searchBookScreen
import app.kaito_dogi.mybrary.feature.mybooklist.myBookListScreen
import app.kaito_dogi.mybrary.feature.searchbook.searchBookRoute

@Composable
internal fun MybraryNavHost(
  modifier: Modifier = Modifier,
) {
  val navController = rememberNavController()

  NavHost(
    navController = navController,
    startDestination = myBookListRoute,
    modifier = modifier.fillMaxSize(),
  ) {
    myBookListScreen(
      onAdditionClick = {
        navController.navigate(searchBookRoute)
      },
      onMyBookClick = { myBook ->
        val arg = MyBookDetailNavArg(myBook.id)
        navController.navigate(myBookDetailRoute(arg))
      },
    )
    myBookDetailScreen()
    searchBookScreen()
  }
}
