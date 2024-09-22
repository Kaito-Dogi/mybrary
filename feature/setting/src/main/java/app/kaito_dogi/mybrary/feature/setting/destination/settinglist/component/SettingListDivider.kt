package app.kaito_dogi.mybrary.feature.setting.destination.settinglist.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import app.kaito_dogi.mybrary.core.designsystem.theme.MybraryTheme

@Composable
internal fun SettingListDivider(
  modifier: Modifier = Modifier,
) {
  HorizontalDivider(
    modifier = modifier
        .padding(vertical = MybraryTheme.spaces.md)
        .fillMaxWidth(),
    color = MybraryTheme.colorScheme.surfaceVariant,
  )
}

@Preview
@Composable
private fun SettingListDividerPreview(
) {
  MybraryTheme {
    SettingListDivider()
  }
}
