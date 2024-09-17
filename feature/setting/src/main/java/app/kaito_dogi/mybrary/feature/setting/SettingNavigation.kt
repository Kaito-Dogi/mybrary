package app.kaito_dogi.mybrary.feature.setting

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.navigation
import app.kaito_dogi.mybrary.core.ui.navigation.route.MainRoute
import app.kaito_dogi.mybrary.core.ui.navigation.route.SettingRoute

fun NavGraphBuilder.settingDestination(
  startDestination: SettingRoute,
  builder: NavGraphBuilder.() -> Unit,
) = navigation<MainRoute.Setting>(
  startDestination = startDestination,
  builder = builder,
)
