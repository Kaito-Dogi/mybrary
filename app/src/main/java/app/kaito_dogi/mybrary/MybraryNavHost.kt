package app.kaito_dogi.mybrary

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import app.kaito_dogi.mybrary.core.ui.navigation.MybraryRoute
import app.kaito_dogi.mybrary.feature.searchbook.searchBookScreen
import app.kaito_dogi.mybrary.feature.auth.destination.sendotp.sendOtpScreen
import app.kaito_dogi.mybrary.feature.auth.destination.verifyotp.verifyOtpScreen

@Deprecated("")
@Composable
internal fun MybraryNavHost(
  modifier: Modifier = Modifier,
) {
  val navController = rememberNavController()

  NavHost(
    navController = navController,
    startDestination = MybraryRoute.SearchBook,
    modifier = modifier.fillMaxSize(),
  ) {
    searchBookScreen()
  }
}
