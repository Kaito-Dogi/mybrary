package app.kaito_dogi.mybrary.feature.auth

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

@Composable
internal fun AuthNavHost(
  builder: NavGraphBuilder.(NavController) -> Unit,
  modifier: Modifier = Modifier,
) {
  val navController = rememberNavController()

  NavHost(
    navController = navController,
    startDestination = AuthRoute.Login,
    modifier = modifier.fillMaxSize(),
    builder = { builder(navController) },
  )
}
