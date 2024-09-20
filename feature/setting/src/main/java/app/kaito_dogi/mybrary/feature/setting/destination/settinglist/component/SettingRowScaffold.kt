package app.kaito_dogi.mybrary.feature.setting.destination.settinglist.component

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import app.kaito_dogi.mybrary.core.designsystem.component.Text
import app.kaito_dogi.mybrary.core.designsystem.theme.MybraryTheme

@Composable
internal fun SettingRowScaffold(
  @StringRes titleResId: Int,
  modifier: Modifier = Modifier,
  @StringRes supportingTextResId: Int? = null,
  trailingContent: @Composable () -> Unit,
) {
  Row(
    modifier = modifier
      .clip(MybraryTheme.shapes.small)
      .fillMaxWidth()
      .padding(MybraryTheme.spaces.sm),
    horizontalArrangement = Arrangement.spacedBy(MybraryTheme.spaces.xs),
    verticalAlignment = Alignment.CenterVertically,
  ) {
    Column(
      modifier = Modifier.weight(1f),
      verticalArrangement = Arrangement.spacedBy(MybraryTheme.spaces.xxs),
    ) {
      Text(
        text = stringResource(titleResId),
        color = MybraryTheme.colorScheme.onSurface,
        maxLines = 1,
        style = MybraryTheme.typography.bodyLarge,
      )
      supportingTextResId?.let {
        Text(
          text = stringResource(it),
          color = MybraryTheme.colorScheme.onSurfaceVariant,
          maxLines = 1,
          style = MybraryTheme.typography.bodySmall,
        )
      }
    }
    trailingContent()
  }
}
