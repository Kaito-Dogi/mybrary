package app.kaito_dogi.mybrary.feature.setting.destination.settinglist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.kaito_dogi.mybrary.core.common.coroutines.LaunchSafe
import app.kaito_dogi.mybrary.core.config.MybraryConfig
import app.kaito_dogi.mybrary.core.domain.repository.LogoutRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

@HiltViewModel
internal class SettingListViewModel @Inject constructor(
  private val logoutRepository: LogoutRepository,
  launchSafe: LaunchSafe,
  config: MybraryConfig,
) : ViewModel(), LaunchSafe by launchSafe {
  private val _uiState = MutableStateFlow(
    SettingListUiState.createInitialValue(
      termsOfUseUrl = config.termsOfUseUrl,
      privacyPolicyUrl = config.privacyPolicyUrl,
      rakutenDevelopersUrl = config.rakutenDevelopersUrl,
      versionName = config.versionName,
    ),
  )
  val uiState = _uiState.asStateFlow()

  fun onSwitchClick(value: Boolean) {
    // TODO: 実装する
  }

  fun onLogoutClick() {
    viewModelScope.launchSafe {
      _uiState.update { it.copy(isLoggingOut = true) }
      logoutRepository.logout()
      _uiState.update { it.copy(isLoggedOut = true) }
    }.invokeOnCompletion {
      _uiState.update { it.copy(isLoggingOut = false) }
    }
  }

  fun onDeleteAccountClick() {
    // TODO: 実装する
  }

  fun onUiEventConsume() {
    _uiState.update { it.copy(isLoggedOut = false) }
  }
}
