package app.kaito_dogi.mybrary.feature.setting.destination.settinglist.component

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import app.kaito_dogi.mybrary.core.designsystem.R
import app.kaito_dogi.mybrary.core.designsystem.theme.MybraryTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun SettingListTopAppBar(
  onNavigationIconClick: () -> Unit,
  modifier: Modifier = Modifier,
) {
  TopAppBar(
    title = {
      Text(
        text = stringResource(id = R.string.setting_list_text_setting),
        style = MybraryTheme.typography.headlineSmall,
      )
    },
    modifier = modifier,
    navigationIcon = {
      IconButton(onClick = onNavigationIconClick) {
        Icon(
          painter = painterResource(id = R.drawable.icon_arrow_back),
          contentDescription = stringResource(id = R.string.setting_list_alt_back),
        )
      }
    },
    colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Transparent),
  )
}

@Preview
@Composable
private fun SettingListTopAppBarPreview() {
  MybraryTheme {
    SettingListTopAppBar(
      onNavigationIconClick = {},
    )
  }
}
