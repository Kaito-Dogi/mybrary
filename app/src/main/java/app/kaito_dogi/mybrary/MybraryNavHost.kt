package app.kaito_dogi.mybrary

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import app.kaito_dogi.mybrary.core.ui.navigation.MybraryRoute
import app.kaito_dogi.mybrary.feature.mybooklist.myBookDetailScreen
import app.kaito_dogi.mybrary.feature.mybooklist.myBookListScreen
import app.kaito_dogi.mybrary.feature.searchbook.searchBookScreen
import app.kaito_dogi.mybrary.feature.sendotp.sendOtpScreen
import app.kaito_dogi.mybrary.feature.verifyotp.verifyOtpScreen

@Composable
internal fun MybraryNavHost(
  modifier: Modifier = Modifier,
) {
  val navController = rememberNavController()

  NavHost(
    navController = navController,
    startDestination = MybraryRoute.SendOtp,
    modifier = modifier.fillMaxSize(),
  ) {
    myBookListScreen(
      onAdditionClick = {
        navController.navigate(MybraryRoute.SearchBook)
      },
      onMyBookClick = { myBook ->
        val route = MybraryRoute.MyBookDetail(myBook = myBook)
        navController.navigate(route)
      },
    )

    myBookDetailScreen()

    searchBookScreen()

    sendOtpScreen(
      onSendOtpComplete = { email, page ->
        val route = MybraryRoute.VerifyOtp(
          email = email,
          page = page,
        )
        navController.navigate(route)
      },
      onLoginComplete = {
        navController.navigate(MybraryRoute.MyBookList) {
          popUpTo<MybraryRoute.SendOtp> {
            inclusive = true
          }
        }
      },
      onSignUpComplete = {
        navController.navigate(MybraryRoute.MyBookList) {
          popUpTo<MybraryRoute.SendOtp> {
            inclusive = true
          }
        }
      },
    )

    verifyOtpScreen(
      onVerifyOtpComplete = {
        navController.navigate(MybraryRoute.MyBookList) {
          popUpTo<MybraryRoute.SendOtp> {
            inclusive = true
          }
        }
      },
    )
  }
}
