package app.kaito_dogi.mybrary.feature.setting.destination.settinglist.component

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import app.kaito_dogi.mybrary.core.designsystem.component.Text
import app.kaito_dogi.mybrary.core.designsystem.theme.MybraryTheme

private val MinHeight = 56.dp

@Composable
internal fun SettingRowScaffold(
  @StringRes titleResId: Int,
  modifier: Modifier = Modifier,
  isDanger: Boolean = false,
  @StringRes supportingTextResId: Int? = null,
  onClick: (() -> Unit)? = null,
  trailingContent: (@Composable () -> Unit)? = null,
) {
  Row(
    modifier = modifier
      .clickable(enabled = onClick != null) { onClick?.invoke() }
      .background(MybraryTheme.colorScheme.background)
      .fillMaxWidth()
      .defaultMinSize(minHeight = MinHeight)
      .padding(horizontal = MybraryTheme.spaces.md),
    horizontalArrangement = Arrangement.spacedBy(MybraryTheme.spaces.xs),
    verticalAlignment = Alignment.CenterVertically,
  ) {
    Column(
      modifier = Modifier.weight(1f),
      verticalArrangement = Arrangement.spacedBy(MybraryTheme.spaces.xxs),
    ) {
      Text(
        text = stringResource(titleResId),
        color = if (isDanger) MybraryTheme.colorScheme.error else MybraryTheme.colorScheme.onSurface,
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
    trailingContent?.invoke()
  }
}
