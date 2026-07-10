package app.kaito_dogi.mybrary.feature.setting.destination.settinglist

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import app.kaito_dogi.mybrary.core.common.model.Url
import app.kaito_dogi.mybrary.core.designsystem.R
import app.kaito_dogi.mybrary.core.designsystem.component.NavigationBarContentScaffold
import app.kaito_dogi.mybrary.core.designsystem.theme.MybraryTheme
import app.kaito_dogi.mybrary.feature.setting.destination.settinglist.component.SettingHeader
import app.kaito_dogi.mybrary.feature.setting.destination.settinglist.component.SettingListTopAppBar
import app.kaito_dogi.mybrary.feature.setting.destination.settinglist.component.SettingRow

@Composable
internal fun SettingListScreen(
  uiState: SettingListUiState,
  onTermsOfUseClick: () -> Unit,
  onPrivacyPolicyClick: () -> Unit,
  onLicenceClick: () -> Unit,
  onRakutenDevelopersClick: () -> Unit,
) {
  NavigationBarContentScaffold { innerPadding ->
    LazyColumn(contentPadding = innerPadding) {
      item {
        SettingListTopAppBar()
      }

      // アプリについて
      item {
        SettingHeader(titleResId = R.string.setting_list_text_about)
      }
      item {
        SettingRow(
          titleResId = R.string.setting_list_text_terms_of_use,
          onClick = onTermsOfUseClick,
        )
      }
      item {
        SettingRow(
          titleResId = R.string.setting_list_text_privacy_policy,
          onClick = onPrivacyPolicyClick,
        )
      }
      item {
        SettingRow(
          titleResId = R.string.setting_list_text_license,
          onClick = onLicenceClick,
        )
      }
      item {
        SettingRow(
          titleResId = R.string.setting_list_text_supported_by_rakuten_developers,
          onClick = onRakutenDevelopersClick,
        )
      }
      item {
        SettingRow(
          titleResId = R.string.setting_list_text_version,
          supportingText = uiState.versionName,
        )
      }
    }
  }
}

@Preview
@Composable
private fun SettingListScreenPreview() {
  MybraryTheme {
    SettingListScreen(
      uiState = SettingListUiState(
        termsOfUseUrl = Url.Web(value = ""),
        privacyPolicyUrl = Url.Web(value = ""),
        rakutenDevelopersUrl = Url.Web(value = ""),
        versionName = "0.0.1",
      ),
      onTermsOfUseClick = {},
      onPrivacyPolicyClick = {},
      onLicenceClick = {},
      onRakutenDevelopersClick = {},
    )
  }
}
