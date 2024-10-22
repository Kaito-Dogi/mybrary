package app.kaito_dogi.mybrary.feature.setting.destination.settinglist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.kaito_dogi.mybrary.core.common.coroutines.LaunchSafe
import app.kaito_dogi.mybrary.core.config.AppConfig
import app.kaito_dogi.mybrary.core.domain.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

@HiltViewModel
internal class SettingListViewModel @Inject constructor(
  private val authRepository: AuthRepository,
  launchSafe: LaunchSafe,
  appConfig: AppConfig,
) : ViewModel(), LaunchSafe by launchSafe {
  private val _uiState = MutableStateFlow(
    SettingListUiState.createInitialValue(
      termsOfUseUrl = appConfig.termsOfUseUrl,
      privacyPolicyUrl = appConfig.privacyPolicyUrl,
      rakutenDevelopersUrl = appConfig.rakutenDevelopersUrl,
      versionName = appConfig.versionName,
      deleteAccountUrl = appConfig.deleteAccountUrl,
    ),
  )
  val uiState = _uiState.asStateFlow()

  fun onSwitchClick(value: Boolean) {
    // TODO: 実装する
  }

  fun onLogoutClick() {
    _uiState.update { it.copy(isLogoutDialogVisible = true) }
  }

  fun onLogoutDialogConfirmClick() {
    viewModelScope.launchSafe {
      _uiState.update { it.copy(isLoggingOut = true) }
      authRepository.logout()
      _uiState.update {
        it.copy(
          isLogoutDialogVisible = false,
          isLoggedOut = true,
        )
      }
    }.invokeOnCompletion {
      _uiState.update { it.copy(isLoggingOut = false) }
    }
  }

  fun onLogoutDialogDismissClick() {
    _uiState.update { it.copy(isLogoutDialogVisible = false) }
  }

  fun onDeleteAccountClick() {
    // TODO: 実装する
  }

  fun onUiEventConsume() {
    _uiState.update { it.copy(isLoggedOut = false) }
  }
}
