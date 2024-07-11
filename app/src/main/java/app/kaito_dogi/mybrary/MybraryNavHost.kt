package app.kaito_dogi.mybrary

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import app.kaito_dogi.mybrary.feature.login.LoginRoute
import app.kaito_dogi.mybrary.feature.login.loginScreen
import app.kaito_dogi.mybrary.feature.mybookdetail.MyBookDetailNavArg
import app.kaito_dogi.mybrary.feature.mybookdetail.myBookDetailRouteWithNavArg
import app.kaito_dogi.mybrary.feature.mybookdetail.myBookDetailScreen
import app.kaito_dogi.mybrary.feature.mybooklist.MyBookListRoute
import app.kaito_dogi.mybrary.feature.mybooklist.myBookListScreen
import app.kaito_dogi.mybrary.feature.searchbooks.SearchBooksRoute
import app.kaito_dogi.mybrary.feature.searchbooks.searchBooksScreen

@Composable
internal fun MybraryNavHost(
  modifier: Modifier = Modifier,
) {
  val navController = rememberNavController()

  NavHost(
    navController = navController,
    startDestination = LoginRoute,
    modifier = modifier.fillMaxSize(),
  ) {
    loginScreen(
      onLoginComplete = {
        navController.navigate(MyBookListRoute)
      },
      onSignUpClick = {},
    )
    myBookListScreen(
      onAdditionClick = {
        navController.navigate(SearchBooksRoute)
      },
      onMyBookClick = { myBook ->
        val navArg = MyBookDetailNavArg(
          myBook = myBook,
        )
        navController.navigate(myBookDetailRouteWithNavArg(navArg))
      },
    )
    myBookDetailScreen()
    searchBooksScreen()
  }
}
