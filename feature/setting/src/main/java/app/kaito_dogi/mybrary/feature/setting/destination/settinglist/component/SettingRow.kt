package app.kaito_dogi.mybrary.feature.setting.destination.settinglist.component

import androidx.annotation.StringRes
import androidx.compose.foundation.clickable
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import app.kaito_dogi.mybrary.core.designsystem.R
import app.kaito_dogi.mybrary.core.designsystem.component.Icon
import app.kaito_dogi.mybrary.core.designsystem.theme.MybraryTheme

@Composable
internal fun SettingRow(
  @StringRes titleResId: Int,
  modifier: Modifier = Modifier,
  @StringRes supportingTextResId: Int? = null,
  onClick: (() -> Unit)? = null,
) {
  SettingRowScaffold(
    titleResId = titleResId,
    modifier = modifier.clickable(enabled = onClick != null) { onClick?.invoke() },
    supportingTextResId = supportingTextResId,
    trailingContent = {
      onClick?.let {
        Icon(
          iconResId = R.drawable.icon_arrow_forward,
          altResId = titleResId,
          tint = MybraryTheme.colorScheme.onSurface,
        )
      }
    },
  )
}

@Preview
@Composable
private fun SettingRowPreview(
  @PreviewParameter(SettingRowPreviewParameterProvider::class) parameter: SettingRowPreviewParameter,
) {
  MybraryTheme {
    SettingRow(
      titleResId = R.string.setting_list_text_terms_of_use,
      onClick = parameter.onClick,
    )
  }
}

private class SettingRowPreviewParameterProvider : PreviewParameterProvider<SettingRowPreviewParameter> {
  override val values: Sequence<SettingRowPreviewParameter>
    get() = sequenceOf(
      SettingRowPreviewParameter(
        onClick = null,
      ),
      SettingRowPreviewParameter(
        onClick = {},
      ),
    )
}

private data class SettingRowPreviewParameter(
  val onClick: (() -> Unit)?,
)
