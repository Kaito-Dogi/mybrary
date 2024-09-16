package app.kaito_dogi.mybrary.feature.setting

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import app.kaito_dogi.mybrary.core.ui.navigation.MainRoute

fun NavGraphBuilder.settingDestination(
  startDestination: SettingRoute,
  builder: NavGraphBuilder.(NavHostController) -> Unit,
) = composable<MainRoute.Setting> {
  SettingNavHost(
    startDestination = startDestination,
    builder = builder,
  )
}
