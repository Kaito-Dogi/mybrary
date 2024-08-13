package app.kaito_dogi.mybrary

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import app.kaito_dogi.mybrary.core.navigation.MybraryRoute
import app.kaito_dogi.mybrary.feature.auth.AuthRoute
import app.kaito_dogi.mybrary.feature.auth.authNavigation
import app.kaito_dogi.mybrary.feature.auth.route.login.loginScreen
import app.kaito_dogi.mybrary.feature.mybookdetail.MyBookDetailNavArg
import app.kaito_dogi.mybrary.feature.mybookdetail.myBookDetailRouteWithNavArg
import app.kaito_dogi.mybrary.feature.mybookdetail.myBookDetailScreen
import app.kaito_dogi.mybrary.feature.mybooklist.MyBookListRoute
import app.kaito_dogi.mybrary.feature.mybooklist.myBookListScreen
import app.kaito_dogi.mybrary.feature.searchbooks.SearchBooksRoute
import app.kaito_dogi.mybrary.feature.searchbooks.searchBooksScreen
import app.kaito_dogi.mybrary.feature.verifyotp.verifyOtpScreen

@Composable
internal fun MybraryNavHost(
  modifier: Modifier = Modifier,
) {
  val navController = rememberNavController()

  NavHost(
    navController = navController,
    startDestination = MybraryRoute.Auth,
    modifier = modifier.fillMaxSize(),
  ) {
    authNavigation { childNavController ->
      loginScreen(
        onSendOtpComplete = { email ->
          val route = AuthRoute.VerifyOtp(email = email)
          childNavController.navigate(route)
        },
        onLoginComplete = {
          navController.navigate(MyBookListRoute)
        },
        onSignUpClick = {
          childNavController.navigate(AuthRoute.SignUp)
        },
      )

      // TODO: screen の追加
    }
    // TODO: 他の画面から遷移できないようにする
    verifyOtpScreen(
      onVerifyOtpComplete = {
        navController.navigate(MyBookListRoute)
      },
    )
    myBookListScreen(
      onAdditionClick = {
        navController.navigate(SearchBooksRoute)
      },
      onMyBookClick = { myBook ->
        val navArg = MyBookDetailNavArg(myBook = myBook)
        navController.navigate(myBookDetailRouteWithNavArg(navArg))
      },
    )
    myBookDetailScreen()
    searchBooksScreen()
  }
}
