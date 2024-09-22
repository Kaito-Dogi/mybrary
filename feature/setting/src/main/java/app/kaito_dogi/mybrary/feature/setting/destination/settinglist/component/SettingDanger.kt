package app.kaito_dogi.mybrary.feature.setting.destination.settinglist.component

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import app.kaito_dogi.mybrary.core.designsystem.R
import app.kaito_dogi.mybrary.core.designsystem.theme.MybraryTheme

@Composable
internal fun SettingDanger(
  @StringRes titleResId: Int,
  onClick: () -> Unit,
  modifier: Modifier = Modifier,
  supportingText: String? = null,
) {
  SettingRowScaffold(
    titleResId = titleResId,
    modifier = modifier,
    isDanger = true,
    supportingText = supportingText,
    onClick = onClick,
  )
}

@Preview
@Composable
private fun SettingDangerPreview(
) {
  MybraryTheme {
    SettingDanger(
      titleResId = R.string.setting_list_text_logout,
      onClick = {},
    )
  }
}
