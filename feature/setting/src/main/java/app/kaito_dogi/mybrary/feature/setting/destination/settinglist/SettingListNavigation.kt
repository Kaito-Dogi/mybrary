package app.kaito_dogi.mybrary.feature.setting.destination.settinglist

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import app.kaito_dogi.mybrary.core.ui.navigation.route.SettingRoute

fun NavGraphBuilder.settingListScreen(
) = composable<SettingRoute.SettingList> {
  SettingListScreenContainer()
}

fun NavHostController.navigateToSettingListScreen() = this.navigate(SettingRoute.SettingList)
