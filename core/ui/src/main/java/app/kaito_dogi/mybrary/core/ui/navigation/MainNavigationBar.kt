package app.kaito_dogi.mybrary.core.ui.navigation

import androidx.compose.material3.NavigationBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination
import app.kaito_dogi.mybrary.core.designsystem.component.NavigationBarItem

@Composable
internal fun MainNavigationBar(
  hierarchy: Sequence<NavDestination>?,
  onItemClick: (NavigationBarDestination) -> Unit,
  modifier: Modifier = Modifier,
) = NavigationBar(
  modifier = modifier,
) {
  NavigationBarDestination.entries.forEach { navigationBarDestination ->
    // https://developer.android.com/develop/ui/compose/navigation#bottom-nav
    val isSelected = hierarchy?.any { navDestination ->
      navDestination.route == navigationBarDestination.route
    } == true

    NavigationBarItem(
      isSelected = isSelected,
      onClick = { onItemClick(navigationBarDestination) },
      iconResId = navigationBarDestination.iconResId,
      iconAltResId = navigationBarDestination.iconAltResId,
      labelResId = navigationBarDestination.labelResId,
    )
  }
}
