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
  startDestination: AuthRoute,
  builder: NavGraphBuilder.(NavController) -> Unit,
  modifier: Modifier = Modifier,
) {
  val navController = rememberNavController()

  NavHost(
    navController = navController,
    startDestination = startDestination,
    modifier = modifier.fillMaxSize(),
    builder = { builder(navController) },
  )
}
