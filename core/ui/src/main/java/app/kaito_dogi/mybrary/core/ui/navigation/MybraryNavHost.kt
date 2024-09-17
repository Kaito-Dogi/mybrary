package app.kaito_dogi.mybrary.core.ui.navigation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import app.kaito_dogi.mybrary.core.ui.navigation.bar.MainNavigationBar
import app.kaito_dogi.mybrary.core.ui.navigation.bar.NavigationBarDestination
import app.kaito_dogi.mybrary.core.ui.navigation.route.MybraryRoute
import app.kaito_dogi.mybrary.core.ui.navigation.route.MainRoute

@Composable
fun MybraryNavHost(
  startDestination: MybraryRoute,
  modifier: Modifier = Modifier,
  builder: NavGraphBuilder.(NavHostController) -> Unit,
) {
  val navController = rememberNavController()
  val currentBackStackEntry by navController.currentBackStackEntryAsState()
  val hierarchy = currentBackStackEntry?.destination?.hierarchy

  Box(
    modifier = modifier.fillMaxSize(),
  ) {
    NavHost(
      navController = navController,
      startDestination = startDestination,
      builder = { builder(navController) },
      modifier = Modifier.fillMaxSize(),
    )

    val isNavigationBarShown =
      hierarchy?.any { navDestination ->
        NavigationBarDestination.entries.any { navigationBarDestination ->
          navDestination.route == navigationBarDestination.route
        }
      } == true
    AnimatedVisibility(
      visible = isNavigationBarShown,
      modifier = Modifier.align(Alignment.BottomCenter),
      enter = slideInVertically(
        initialOffsetY = { fullHeight -> fullHeight },
      ),
      exit = slideOutVertically(
        targetOffsetY = { fullHeight -> fullHeight },
      ),
    ) {
      MainNavigationBar(
        hierarchy = hierarchy,
        onItemClick = { navigationBarDestination ->
          val route = when (navigationBarDestination) {
            NavigationBarDestination.MyBook -> MainRoute.MyBook
            NavigationBarDestination.Setting -> MainRoute.Setting
          }

          // https://developer.android.com/develop/ui/compose/navigation#bottom-nav
          navController.navigate(route = route) {
            popUpTo(navController.graph.findStartDestination().id) {
              saveState = true
            }
            launchSingleTop = true
            restoreState = true
          }
        },
      )
    }
  }
}
