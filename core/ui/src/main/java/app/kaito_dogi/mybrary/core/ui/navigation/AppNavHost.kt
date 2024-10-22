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
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import app.kaito_dogi.mybrary.core.ui.browser.InternalBrowserLauncher
import app.kaito_dogi.mybrary.core.ui.browser.rememberInternalBrowserLauncher
import app.kaito_dogi.mybrary.core.ui.navigation.route.AppRoute
import app.kaito_dogi.mybrary.core.ui.navigation.route.MainRoute

@Composable
fun AppNavHost(
  startDestination: AppRoute,
  modifier: Modifier = Modifier,
  builder: NavGraphBuilder.(NavHostController, InternalBrowserLauncher) -> Unit,
) {
  val navController = rememberNavController()
  val internalBrowserLauncher = rememberInternalBrowserLauncher()

  val currentBackStackEntry by navController.currentBackStackEntryAsState()
  val hierarchy = currentBackStackEntry?.destination?.hierarchy

  Box(
    modifier = modifier.fillMaxSize(),
  ) {
    NavHost(
      navController = navController,
      startDestination = startDestination,
      builder = { builder(navController, internalBrowserLauncher) },
      modifier = Modifier.fillMaxSize(),
    )

    // NavDestination が MainRoute かどうかで Navigation Bar の表示・非表示を切り替える
    val isNavigationBarVisible = hierarchy?.any { navDestination ->
      NavigationBarDestination.entries.any { navigationBarDestination ->
        navDestination.route == navigationBarDestination.route
      }
    } == true
    AnimatedVisibility(
      visible = isNavigationBarVisible,
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
            popUpTo<AppRoute.Main> {
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
