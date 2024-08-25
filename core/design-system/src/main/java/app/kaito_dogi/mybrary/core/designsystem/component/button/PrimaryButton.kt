package app.kaito_dogi.mybrary.core.designsystem.component.button

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import app.kaito_dogi.mybrary.core.designsystem.component.Gap
import app.kaito_dogi.mybrary.core.designsystem.component.Icon
import app.kaito_dogi.mybrary.core.designsystem.component.Text
import app.kaito_dogi.mybrary.core.designsystem.theme.MybraryTheme

@Composable
fun PrimaryButton(
  @StringRes textResId: Int,
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
      iconResId = iconResId,
      altResId = altResId,
    )

    Gap(width = MybraryTheme.space.xs)
  }

  if (isLoading) {
    CircularProgressIndicator(
      modifier = Modifier.size(24.dp),
      color = ButtonDefaults.buttonColors().disabledContentColor,
      strokeWidth = 3.dp,
      strokeCap = StrokeCap.Round,
    )

    Gap(width = MybraryTheme.space.xs)
  }

  Text(textResId = textResId)
}

@Preview(showBackground = true)
@Composable
private fun PrimaryButtonPreview(
  @PreviewParameter(PrimaryButtonPreviewParameterProvider::class) parameter: PrimaryButtonPreviewParameter,
) {
  MybraryTheme {
    PrimaryButton(
      textResId = android.R.string.ok,
      onClick = {},
      modifier = Modifier.fillMaxWidth(),
      isLoading = parameter.isLoading,
      isEnabled = parameter.isEnabled,
    )
  }
}

private class PrimaryButtonPreviewParameterProvider :
  PreviewParameterProvider<PrimaryButtonPreviewParameter> {
  override val values: Sequence<PrimaryButtonPreviewParameter>
    get() = sequenceOf(
      PrimaryButtonPreviewParameter(
        isLoading = false,
        isEnabled = true,
      ),
      PrimaryButtonPreviewParameter(
        isLoading = true,
        isEnabled = true,
      ),
      PrimaryButtonPreviewParameter(
        isLoading = false,
        isEnabled = false,
      ),
    )
}

private data class PrimaryButtonPreviewParameter(
  val isLoading: Boolean,
  val isEnabled: Boolean,
)
