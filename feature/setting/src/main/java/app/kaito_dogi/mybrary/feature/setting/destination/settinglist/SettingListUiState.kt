package app.kaito_dogi.mybrary.feature.setting.destination.settinglist

import androidx.compose.runtime.Immutable
import app.kaito_dogi.mybrary.core.common.model.Url

@Immutable
internal data class SettingListUiState(
  val isMemoMadePublicByDefault: Boolean,
  val termsOfUseUrl: Url.Web,
  val privacyPolicyUrl: Url.Web,
  val rakutenDevelopersUrl: Url.Web,
  val versionName: String,
  val isLogoutDialogVisible: Boolean,
  val isLoggingOut: Boolean,
  val isLoggedOut: Boolean,
) {
  companion object {
    fun createInitialValue(
      termsOfUseUrl: Url.Web,
      privacyPolicyUrl: Url.Web,
      rakutenDevelopersUrl: Url.Web,
      versionName: String,
    ) = SettingListUiState(
      isMemoMadePublicByDefault = true,
      termsOfUseUrl = termsOfUseUrl,
      privacyPolicyUrl = privacyPolicyUrl,
      rakutenDevelopersUrl = rakutenDevelopersUrl,
      versionName = versionName,
      isLogoutDialogVisible = false,
      isLoggingOut = false,
      isLoggedOut = false,
    )
  }
}
