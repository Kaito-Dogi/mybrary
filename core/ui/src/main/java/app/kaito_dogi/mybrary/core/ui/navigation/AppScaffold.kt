package app.kaito_dogi.mybrary.core.ui.navigation

import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScaffoldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun AppScaffold(
  mainNavController: NavHostController,
  startDestination: AppRoute,
  builder: NavGraphBuilder.(NavHostController) -> Unit,
) {
  val currentBackStackEntry by mainNavController.currentBackStackEntryAsState()

  Scaffold(
    modifier = Modifier.fillMaxSize(),
    bottomBar = {
      MainNavigationBar(
        currentDestination = currentBackStackEntry?.destination,
        onItemClick = { destination ->
          val route = when (destination) {
            NavigationBarDestination.MyBook -> MainRoute.MyBook
            NavigationBarDestination.Setting -> MainRoute.Setting
          }

          // https://developer.android.com/develop/ui/compose/navigation#bottom-nav
          mainNavController.navigate(route = route) {
            popUpTo(mainNavController.graph.findStartDestination().id) {
              saveState = true
            }
            launchSingleTop = true
            restoreState = true
          }
        },
      )
    },
    contentWindowInsets = ScaffoldDefaults.contentWindowInsets.only(WindowInsetsSides.Bottom),
  ) { innerPadding ->
    AppNavHost(
      startDestination = startDestination,
      builder = builder,
      modifier = Modifier.padding(innerPadding),
    )
  }
}
