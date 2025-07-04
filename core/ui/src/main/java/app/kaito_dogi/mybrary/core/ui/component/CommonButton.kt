package app.kaito_dogi.mybrary.core.ui.component

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import app.kaito_dogi.mybrary.core.designsystem.component.Gap
import app.kaito_dogi.mybrary.core.designsystem.theme.MybraryTheme

@Composable
fun CommonButton(
  text: String,
  onClick: () -> Unit,
  modifier: Modifier = Modifier,
  @DrawableRes iconResId: Int? = null,
  @StringRes altResId: Int? = null,
  isLoading: Boolean = false,
  isEnabled: Boolean = true,
) = Button(
  onClick = onClick,
  modifier = modifier,
  enabled = isEnabled && !isLoading,
) {
  if (iconResId != null && !isLoading) {
    Icon(
      painter = painterResource(id = iconResId),
      contentDescription = altResId?.let { stringResource(id = it) },
      modifier = Modifier.size(ButtonDefaults.IconSize),
    )

    Gap(width = ButtonDefaults.IconSpacing)
  }

  if (isLoading) {
    CircularProgressIndicator(
      modifier = Modifier.size(ButtonDefaults.IconSize),
      color = ButtonDefaults.buttonColors().disabledContentColor,
      strokeWidth = 2.dp,
      strokeCap = StrokeCap.Round,
    )

    Gap(width = ButtonDefaults.IconSpacing)
  }

  Text(text = text)
}

@Preview(showBackground = true)
@Composable
private fun CommonButtonPreview(
  @PreviewParameter(CommonButtonPreviewParameterProvider::class) parameter: CommonButtonPreviewParameter,
) {
  MybraryTheme {
    CommonButton(
      text = "CommonButton",
      onClick = {},
      modifier = Modifier.fillMaxWidth(),
      isLoading = parameter.isLoading,
      isEnabled = parameter.isEnabled,
    )
  }
}

private class CommonButtonPreviewParameterProvider :
  PreviewParameterProvider<CommonButtonPreviewParameter> {
  override val values: Sequence<CommonButtonPreviewParameter>
    get() = sequenceOf(
      CommonButtonPreviewParameter(
        isLoading = false,
        isEnabled = true,
      ),
      CommonButtonPreviewParameter(
        isLoading = true,
        isEnabled = true,
      ),
      CommonButtonPreviewParameter(
        isLoading = false,
        isEnabled = false,
      ),
    )
}

private data class CommonButtonPreviewParameter(
  val isLoading: Boolean,
  val isEnabled: Boolean,
)