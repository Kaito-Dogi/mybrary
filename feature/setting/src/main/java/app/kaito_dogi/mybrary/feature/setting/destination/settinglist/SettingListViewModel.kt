package app.kaito_dogi.mybrary.feature.setting.destination.settinglist

import androidx.lifecycle.ViewModel
import app.kaito_dogi.mybrary.core.common.coroutines.LaunchSafe
import app.kaito_dogi.mybrary.core.config.AppConfig
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

@HiltViewModel
internal class SettingListViewModel @Inject constructor(
  launchSafe: LaunchSafe,
  appConfig: AppConfig,
) : ViewModel(), LaunchSafe by launchSafe {
  private val _uiState = MutableStateFlow(
    value = SettingListUiState.createInitialValue(
      termsOfUseUrl = appConfig.termsOfUseUrl,
      privacyPolicyUrl = appConfig.privacyPolicyUrl,
      rakutenDevelopersUrl = appConfig.rakutenDevelopersUrl,
      versionName = appConfig.versionName,
    ),
  )
  val uiState = _uiState.asStateFlow()
}
