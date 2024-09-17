package app.kaito_dogi.mybrary.core.ui.navigation

import androidx.compose.material3.NavigationBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import app.kaito_dogi.mybrary.core.designsystem.component.NavigationBarItem

@Composable
internal fun MainNavigationBar(
  currentDestination: NavDestination?,
  onItemClick: (NavigationBarDestination) -> Unit,
  modifier: Modifier = Modifier,
) = NavigationBar(
  modifier = modifier,
) {
  NavigationBarDestination.entries.forEach { destination ->
    // https://developer.android.com/develop/ui/compose/navigation#bottom-nav
    val isSelected = (currentDestination?.hierarchy?.any { it.route == destination.route } == true)

    NavigationBarItem(
      isSelected = isSelected,
      onClick = { onItemClick(destination) },
      iconResId = destination.iconResId,
      iconAltResId = destination.iconAltResId,
      labelResId = destination.labelResId,
    )
  }
}