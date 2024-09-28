package app.kaito_dogi.mybrary.feature.setting.destination.settinglist.component

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import app.kaito_dogi.mybrary.core.designsystem.R
import app.kaito_dogi.mybrary.core.designsystem.theme.MybraryTheme

private val IconContainerSize = 48.dp

@Composable
internal fun SettingRow(
  @StringRes titleResId: Int,
  modifier: Modifier = Modifier,
  supportingText: String? = null,
  onClick: (() -> Unit)? = null,
) {
  SettingRowScaffold(
    titleResId = titleResId,
    modifier = modifier,
    supportingText = supportingText,
    onClick = onClick,
    trailingContent = {
      onClick?.let {
        Box(
          modifier = Modifier.size(IconContainerSize),
          contentAlignment = Alignment.Center,
        ) {
          Icon(
            painter = painterResource(R.drawable.icon_arrow_forward),
            contentDescription = stringResource(titleResId),
            tint = MybraryTheme.colorScheme.onSurface,
          )
        }
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
