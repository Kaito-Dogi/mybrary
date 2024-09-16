package app.kaito_dogi.mybrary.core.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

@Composable
internal fun MainNavHost(
  navController: NavHostController,
  startDestination: MainRoute,
  builder: NavGraphBuilder.() -> Unit,
  modifier: Modifier = Modifier,
) {
  NavHost(
    navController = navController,
    startDestination = startDestination,
    builder = builder,
    modifier = modifier,
  )
}
