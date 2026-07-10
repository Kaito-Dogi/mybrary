package app.kaito_dogi.mybrary.feature.setting.destination.settinglist

import androidx.compose.runtime.Immutable
import app.kaito_dogi.mybrary.core.common.model.Url

@Immutable
internal data class SettingListUiState(
  val termsOfUseUrl: Url.Web,
  val privacyPolicyUrl: Url.Web,
  val rakutenDevelopersUrl: Url.Web,
  val versionName: String,
) {
  companion object {
    fun createInitialValue(
      termsOfUseUrl: Url.Web,
      privacyPolicyUrl: Url.Web,
      rakutenDevelopersUrl: Url.Web,
      versionName: String,
    ) = SettingListUiState(
      termsOfUseUrl = termsOfUseUrl,
      privacyPolicyUrl = privacyPolicyUrl,
      rakutenDevelopersUrl = rakutenDevelopersUrl,
      versionName = versionName,
    )
  }
}
