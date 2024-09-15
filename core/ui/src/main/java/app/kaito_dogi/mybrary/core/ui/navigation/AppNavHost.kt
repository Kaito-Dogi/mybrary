package app.kaito_dogi.mybrary.core.ui.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

@Composable
internal fun AppNavHost(
  navController: NavHostController,
  startDestination: AppRoute,
  builder: NavGraphBuilder.(NavHostController) -> Unit,
  modifier: Modifier = Modifier,
) = NavHost(
  navController = navController,
  startDestination = startDestination,
  builder = { builder(navController) },
  modifier = modifier.fillMaxSize(),
)
