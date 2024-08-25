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
import app.kaito_dogi.mybrary.feature.mybook.MyBookRoute
import app.kaito_dogi.mybrary.feature.mybook.myBookNavigation
import app.kaito_dogi.mybrary.feature.mybook.route.mybookdetail.myBookDetailScreen
import app.kaito_dogi.mybrary.feature.mybook.route.mybooklist.myBookListScreen
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
    authNavigation(
      startDestination = AuthRoute.Login,
    ) { childNavController ->
      loginScreen(
        onSendOtpComplete = { email ->
          val route = MybraryRoute.VerifyOtp(
            email = email,
            page = MybraryRoute.VerifyOtp.Page.Login,
          )
          navController.navigate(route)
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
          val route = MybraryRoute.VerifyOtp(
            email = email,
            page = MybraryRoute.VerifyOtp.Page.SignUp,
          )
          navController.navigate(route)
        },
        onSignUpComplete = {
          navController.navigate(MybraryRoute.MyBook)
        },
        onLoginClick = {
          childNavController.navigate(AuthRoute.Login)
        },
      )
    }

    myBookNavigation(
      startDestination = MyBookRoute.MyBookList,
    ) { childNavController ->
      myBookListScreen(
        onAdditionClick = {
          childNavController.navigate(SearchBooksRoute)
        },
        onMyBookClick = { myBook ->
          val route = MyBookRoute.MyBookDetail(myBook = myBook)
          childNavController.navigate(route)
        },
      )

      myBookDetailScreen()
    }

    searchBooksScreen()

    verifyOtpScreen(
      onVerifyOtpComplete = {
        navController.navigate(MybraryRoute.MyBook)
      },
    )
  }
}
