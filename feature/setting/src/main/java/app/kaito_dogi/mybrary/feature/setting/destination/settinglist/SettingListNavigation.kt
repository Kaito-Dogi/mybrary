package app.kaito_dogi.mybrary.feature.setting.destination.settinglist

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import app.kaito_dogi.mybrary.core.common.model.Url
import app.kaito_dogi.mybrary.core.ui.navigation.route.SettingRoute

fun EntryProviderScope<NavKey>.settingListEntry(
  onNavigationIconClick: () -> Unit,
  onTermsOfUseClick: (Url) -> Unit,
  onPrivacyPolicyClick: (Url) -> Unit,
  onLicenceClick: () -> Unit,
  onRakutenDevelopersClick: (Url) -> Unit,
) = entry<SettingRoute.SettingList> {
  SettingListScreenContainer(
    onNavigationIconClick = onNavigationIconClick,
    onTermsOfUseClick = onTermsOfUseClick,
    onPrivacyPolicyClick = onPrivacyPolicyClick,
    onLicenceClick = onLicenceClick,
    onRakutenDevelopersClick = onRakutenDevelopersClick,
  )
}
