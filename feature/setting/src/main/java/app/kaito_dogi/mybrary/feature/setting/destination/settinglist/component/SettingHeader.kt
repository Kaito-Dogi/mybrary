package app.kaito_dogi.mybrary.feature.setting.destination.settinglist.component

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import app.kaito_dogi.mybrary.core.designsystem.R
import app.kaito_dogi.mybrary.core.designsystem.component.Text
import app.kaito_dogi.mybrary.core.designsystem.theme.MybraryTheme

@Composable
internal fun SettingHeader(
  @StringRes titleResId: Int,
  modifier: Modifier = Modifier,
) {
  Box(
    modifier = modifier
      .fillMaxWidth()
      .padding(
        horizontal = MybraryTheme.spaces.xs,
        vertical = MybraryTheme.spaces.sm,
      ),
    contentAlignment = Alignment.CenterStart,
  ) {
    Text(
      text = stringResource(titleResId),
      color = MybraryTheme.colorScheme.onSurfaceVariant,
      style = MybraryTheme.typography.titleMedium,
    )
  }
}

@Preview
@Composable
private fun SettingHeaderPreview() {
  MybraryTheme {
    SettingHeader(
      titleResId = R.string.setting_list_text_account,
    )
  }
}
