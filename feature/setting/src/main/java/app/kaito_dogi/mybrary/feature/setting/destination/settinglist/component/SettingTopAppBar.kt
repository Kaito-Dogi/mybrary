package app.kaito_dogi.mybrary.feature.setting.destination.settinglist.component

import androidx.annotation.StringRes
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import app.kaito_dogi.mybrary.core.designsystem.R
import app.kaito_dogi.mybrary.core.designsystem.component.Text
import app.kaito_dogi.mybrary.core.designsystem.theme.MybraryTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun SettingListTopAppBar(
  @StringRes titleResId: Int,
) {
  CenterAlignedTopAppBar(
    title = {
      Text(
        text = stringResource(titleResId),
        style = MybraryTheme.typography.headlineSmall,
      )
    },
  )
}

@Preview
@Composable
private fun SettingListTopAppBarPreview() {
  MybraryTheme {
    SettingListTopAppBar(titleResId = R.string.setting_list_text_setting)
  }
}
