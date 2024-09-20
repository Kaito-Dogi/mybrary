package app.kaito_dogi.mybrary.feature.setting.destination.settinglist.component

import androidx.annotation.StringRes
import androidx.compose.foundation.clickable
import androidx.compose.material3.Switch
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import app.kaito_dogi.mybrary.core.designsystem.R
import app.kaito_dogi.mybrary.core.designsystem.theme.MybraryTheme

@Composable
internal fun SettingSwitchRow(
  @StringRes titleResId: Int,
  isChecked: Boolean,
  onClick: (Boolean) -> Unit,
  modifier: Modifier = Modifier,
  @StringRes supportingTextResId: Int? = null,
) {
  SettingRowScaffold(
    titleResId = titleResId,
    modifier = modifier.clickable { onClick(!isChecked) },
    supportingTextResId = supportingTextResId,
    trailingContent = {
      Switch(
        checked = isChecked,
        onCheckedChange = onClick,
      )
    },
  )
}

@Preview
@Composable
private fun SettingSwitchRowPreview(
  @PreviewParameter(SettingSwitchRowPreviewParameterProvider::class) parameter: SettingSwitchRowPreviewParameter,
) {
  MybraryTheme {
    SettingSwitchRow(
      titleResId = R.string.setting_list_text_make_notes_public_by_default,
      isChecked = parameter.isChecked,
      onClick = {},
    )
  }
}

private class SettingSwitchRowPreviewParameterProvider : PreviewParameterProvider<SettingSwitchRowPreviewParameter> {
  override val values: Sequence<SettingSwitchRowPreviewParameter>
    get() = sequenceOf(
      SettingSwitchRowPreviewParameter(
        isChecked = true,
      ),
      SettingSwitchRowPreviewParameter(
        isChecked = false,
      ),
    )
}

private data class SettingSwitchRowPreviewParameter(
  val isChecked: Boolean,
)
