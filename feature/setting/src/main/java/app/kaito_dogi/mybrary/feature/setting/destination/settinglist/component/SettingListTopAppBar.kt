package app.kaito_dogi.mybrary.feature.setting.destination.settinglist.component

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import app.kaito_dogi.mybrary.core.designsystem.R
import app.kaito_dogi.mybrary.core.designsystem.ext.none
import app.kaito_dogi.mybrary.core.designsystem.theme.MybraryTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun SettingListTopAppBar(
  modifier: Modifier = Modifier,
) {
  // FIXME: NavigationBarItem で表示できる NavHost の Root の TopAppBar として共通化する
  CenterAlignedTopAppBar(
    title = {
      Text(
        text = stringResource(R.string.setting_list_text_setting),
        style = MybraryTheme.typography.headlineSmall,
      )
    },
    modifier = modifier,
    windowInsets = WindowInsets.none,
  )
}

@Preview
@Composable
private fun SettingListTopAppBarPreview() {
  MybraryTheme {
    SettingListTopAppBar()
  }
}
