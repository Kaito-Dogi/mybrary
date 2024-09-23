package app.kaito_dogi.mybrary.feature.setting.destination.settinglist

import androidx.lifecycle.ViewModel
import app.kaito_dogi.mybrary.core.config.MybraryConfig
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

@HiltViewModel
internal class SettingListViewModel @Inject constructor(
  config: MybraryConfig,
) : ViewModel() {
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
    // TODO: 実装する
  }

  fun onDeleteAccountClick() {
    // TODO: 実装する
  }
}
