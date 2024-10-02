package app.kaito_dogi.mybrary.feature.setting.destination.settinglist

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import app.kaito_dogi.mybrary.core.common.model.Url
import app.kaito_dogi.mybrary.core.designsystem.R
import app.kaito_dogi.mybrary.core.designsystem.component.AlertDialog
import app.kaito_dogi.mybrary.core.designsystem.component.NavigationBarContentScaffold
import app.kaito_dogi.mybrary.core.designsystem.theme.MybraryTheme
import app.kaito_dogi.mybrary.feature.setting.destination.settinglist.component.SettingDanger
import app.kaito_dogi.mybrary.feature.setting.destination.settinglist.component.SettingHeader
import app.kaito_dogi.mybrary.feature.setting.destination.settinglist.component.SettingListDivider
import app.kaito_dogi.mybrary.feature.setting.destination.settinglist.component.SettingListTopAppBar
import app.kaito_dogi.mybrary.feature.setting.destination.settinglist.component.SettingRow
import app.kaito_dogi.mybrary.feature.setting.destination.settinglist.component.SettingSwitch

@Composable
internal fun SettingListScreen(
  uiState: SettingListUiState,
  onSwitchClick: (Boolean) -> Unit,
  onTermsOfUseClick: () -> Unit,
  onPrivacyPolicyClick: () -> Unit,
  onLicenceClick: () -> Unit,
  onRakutenDevelopersClick: () -> Unit,
  onLogoutClick: () -> Unit,
  onLogoutDialogConfirmClick: () -> Unit,
  onLogoutDialogDismissClick: () -> Unit,
  onDeleteAccountClick: () -> Unit,
) {
  NavigationBarContentScaffold { innerPadding ->
    LazyColumn(contentPadding = innerPadding) {
      item {
        SettingListTopAppBar()
      }

      // アカウント
      item {
        SettingHeader(titleResId = R.string.setting_list_text_account)
      }
      item {
        SettingSwitch(
          titleResId = R.string.setting_list_text_make_notes_public_by_default,
          isChecked = uiState.isMemoMadePublicByDefault,
          onClick = onSwitchClick,
        )
      }

      item {
        SettingListDivider(
          modifier = Modifier.padding(horizontal = MybraryTheme.spaces.sm),
        )
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

      item {
        SettingListDivider(
          modifier = Modifier.padding(horizontal = MybraryTheme.spaces.md),
        )
      }

      // その他
      item {
        SettingHeader(titleResId = R.string.setting_list_text_others)
      }
      item {
        SettingDanger(
          titleResId = R.string.setting_list_text_logout,
          onClick = onLogoutClick,
        )
      }
      item {
        SettingDanger(
          titleResId = R.string.setting_list_text_delete_account,
          onClick = onDeleteAccountClick,
        )
      }
    }

    if (uiState.isLogoutDialogVisible) {
      AlertDialog(
        title = stringResource(id = R.string.setting_list_text_would_you_like_to_logout),
        onConfirmClick = onLogoutDialogConfirmClick,
        confirmTextResId = R.string.setting_list_text_ok,
        onDismissRequest = onLogoutDialogDismissClick,
        dismissTextResId = R.string.setting_list_text_cancel,
        onDismissClick = onLogoutDialogDismissClick,
        isConfirmLoading = uiState.isLoggingOut,
      )
    }
  }
}

@Preview
@Composable
private fun SettingListScreenPreview() {
  MybraryTheme {
    SettingListScreen(
      uiState = SettingListUiState(
        isMemoMadePublicByDefault = false,
        termsOfUseUrl = Url.Web(value = ""),
        privacyPolicyUrl = Url.Web(value = ""),
        rakutenDevelopersUrl = Url.Web(value = ""),
        versionName = "0.0.1",
        isLogoutDialogVisible = false,
        isLoggingOut = false,
        isLoggedOut = false,
      ),
      onSwitchClick = {},
      onTermsOfUseClick = {},
      onPrivacyPolicyClick = {},
      onLicenceClick = {},
      onRakutenDevelopersClick = {},
      onLogoutClick = {},
      onLogoutDialogConfirmClick = {},
      onLogoutDialogDismissClick = {},
      onDeleteAccountClick = {},
    )
  }
}
