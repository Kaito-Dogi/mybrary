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
import app.kaito_dogi.mybrary.feature.auth.route.signup.signUpScreen
import app.kaito_dogi.mybrary.feature.auth.route.verifyotp.VerifyOtpUiState
import app.kaito_dogi.mybrary.feature.auth.route.verifyotp.verifyOtpScreen
import app.kaito_dogi.mybrary.feature.mybook.MyBookRoute
import app.kaito_dogi.mybrary.feature.mybook.myBookNavigation
import app.kaito_dogi.mybrary.feature.searchbooks.searchBooksScreen

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
    authNavigation(
      startDestination = AuthRoute.Login,
    ) { childNavController ->
      loginScreen(
        onSendOtpComplete = { email ->
          val route = AuthRoute.VerifyOtp(
            email = email,
            page = VerifyOtpUiState.Page.Login,
          )
          childNavController.navigate(route)
        },
        onLoginComplete = {
          navController.navigate(MybraryRoute.MyBook)
        },
        onSignUpClick = {
          childNavController.navigate(AuthRoute.SignUp)
        },
      )

      signUpScreen(
        onSendOtpComplete = { email ->
          val route = AuthRoute.VerifyOtp(
            email = email,
            page = VerifyOtpUiState.Page.SignUp,
          )
          childNavController.navigate(route)
        },
        onSignUpComplete = {
          navController.navigate(MybraryRoute.MyBook)
        },
        onLoginClick = {
          childNavController.navigate(AuthRoute.Login)
        },
      )

      verifyOtpScreen(
        onVerifyOtpComplete = {
          navController.navigate(MybraryRoute.MyBook)
        },
      )
    }

    myBookNavigation(
      startDestination = MyBookRoute.MyBookList,
    ) {
      // TODO: destination を定義
    }

    // TODO: モジュール以降後削除
//    myBookListScreen(
//      onAdditionClick = {
//        navController.navigate(SearchBooksRoute)
//      },
//      onMyBookClick = { myBook ->
//        val navArg = MyBookDetailNavArg(myBook = myBook)
//        navController.navigate(myBookDetailRouteWithNavArg(navArg))
//      },
//    )
//    myBookDetailScreen()

    searchBooksScreen()
  }
}
