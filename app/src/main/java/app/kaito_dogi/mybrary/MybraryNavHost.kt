package app.kaito_dogi.mybrary

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import app.kaito_dogi.mybrary.feature.mybookdetail.MyBookDetailNavArg
import app.kaito_dogi.mybrary.feature.mybookdetail.myBookDetail
import app.kaito_dogi.mybrary.feature.mybookdetail.myBookDetailRouteWithNavArg
import app.kaito_dogi.mybrary.feature.mybooklist.myBookList
import app.kaito_dogi.mybrary.feature.mybooklist.myBookListRoute
import app.kaito_dogi.mybrary.feature.searchbook.searchBookRoute
import app.kaito_dogi.mybrary.feature.searchbook.searchBookScreen

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
    myBookList(
      onAdditionClick = {
        navController.navigate(searchBookRoute)
      },
      onMyBookClick = { myBook ->
        val navArg = MyBookDetailNavArg(
          myBook = myBook,
        )
        navController.navigate(myBookDetailRouteWithNavArg(navArg))
      },
    )
    myBookDetail()
    searchBookScreen()
  }
}
