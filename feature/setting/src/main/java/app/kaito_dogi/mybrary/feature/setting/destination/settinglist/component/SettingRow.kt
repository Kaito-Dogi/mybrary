package app.kaito_dogi.mybrary.feature.setting.destination.settinglist.component

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import app.kaito_dogi.mybrary.core.designsystem.R
import app.kaito_dogi.mybrary.core.designsystem.component.Icon
import app.kaito_dogi.mybrary.core.designsystem.component.Text
import app.kaito_dogi.mybrary.core.designsystem.theme.MybraryTheme

@Composable
internal fun SettingRow(
  @StringRes titleResId: Int,
  modifier: Modifier = Modifier,
  @StringRes supportingTextResId: Int? = null,
  onClick: (() -> Unit)? = null,
) {
  Row(
    modifier = modifier
      .clip(MybraryTheme.shapes.small)
      .clickable(enabled = onClick != null) { onClick?.invoke() }
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
    onClick?.let {
      Icon(
        iconResId = R.drawable.icon_arrow_forward,
        altResId = titleResId,
        tint = MybraryTheme.colorScheme.onSurface,
      )
    }
  }
}

@Preview
@Composable
private fun SettingRowPreview() {
  MybraryTheme {
    Box(modifier = Modifier.background(MybraryTheme.colorScheme.surface)) {
      SettingRow(
        titleResId = R.string.setting_list_text_terms_of_use,
        onClick = {},
      )
    }
  }
}
