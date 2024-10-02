package app.kaito_dogi.mybrary.feature.setting.destination.settinglist

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import app.kaito_dogi.mybrary.core.common.model.Url
import app.kaito_dogi.mybrary.core.ui.navigation.route.SettingRoute

fun NavGraphBuilder.settingListScreen(
  onLogoutComplete: () -> Unit,
  onTermsOfUseClick: (Url) -> Unit,
  onPrivacyPolicyClick: (Url) -> Unit,
  onLicenceClick: () -> Unit,
  onRakutenDevelopersClick: (Url) -> Unit,
) = composable<SettingRoute.SettingList> {
  SettingListScreenContainer(
    onLogoutComplete = onLogoutComplete,
    onTermsOfUseClick = onTermsOfUseClick,
    onPrivacyPolicyClick = onPrivacyPolicyClick,
    onLicenceClick = onLicenceClick,
    onRakutenDevelopersClick = onRakutenDevelopersClick,
  )
}

fun NavHostController.navigateToSettingListScreen() = this.navigate(route = SettingRoute.SettingList)
