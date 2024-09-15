package app.kaito_dogi.mybrary.core.ui.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import app.kaito_dogi.mybrary.core.designsystem.component.BottomBarScaffold

@Composable
fun AppScaffold(
  startDestination: AppRoute,
  builder: NavGraphBuilder.(NavHostController) -> Unit,
) {
  val navController = rememberNavController()
  val currentBackStackEntry by navController.currentBackStackEntryAsState()

  BottomBarScaffold(
    modifier = Modifier.fillMaxSize(),
    bottomBar = {
      AppNavigationBar(
        currentDestination = currentBackStackEntry?.destination,
        onItemClick = { destination ->
          val route = when (destination) {
            NavigationBarDestination.MyBook -> AppRoute.MyBook
            NavigationBarDestination.Setting -> AppRoute.Setting
          }
          navController.navigate(route = route) {
            popUpTo(navController.graph.findStartDestination().id) {
              saveState = true
            }
            launchSingleTop = true
            restoreState = true
          }
        },
      )
    },
  ) { innerPadding ->
    AppNavHost(
      navController = navController,
      startDestination = startDestination,
      builder = builder,
      modifier = Modifier.padding(innerPadding),
    )
  }
}
