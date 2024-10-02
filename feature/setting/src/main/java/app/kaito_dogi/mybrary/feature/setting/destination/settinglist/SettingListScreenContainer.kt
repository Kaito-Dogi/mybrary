package app.kaito_dogi.mybrary.feature.setting.destination.settinglist

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import app.kaito_dogi.mybrary.core.common.model.Url

@Composable
internal fun SettingListScreenContainer(
  onLogoutComplete: () -> Unit,
  onTermsOfUseClick: (Url) -> Unit,
  onPrivacyPolicyClick: (Url) -> Unit,
  onLicenceClick: () -> Unit,
  onRakutenDevelopersClick: (Url) -> Unit,
  viewModel: SettingListViewModel = hiltViewModel(),
) {
  val uiState by viewModel.uiState.collectAsStateWithLifecycle()

  if (uiState.isLoggedOut) {
    LaunchedEffect(Unit) {
      onLogoutComplete()
      viewModel.onUiEventConsume()
    }
  }

  SettingListScreen(
    uiState = uiState,
    onSwitchClick = viewModel::onSwitchClick,
    onTermsOfUseClick = { onTermsOfUseClick(uiState.termsOfUseUrl) },
    onPrivacyPolicyClick = { onPrivacyPolicyClick(uiState.privacyPolicyUrl) },
    onLicenceClick = onLicenceClick,
    onRakutenDevelopersClick = { onRakutenDevelopersClick(uiState.rakutenDevelopersUrl) },
    onLogoutClick = viewModel::onLogoutClick,
    onDeleteAccountClick = viewModel::onDeleteAccountClick,
  )
}
