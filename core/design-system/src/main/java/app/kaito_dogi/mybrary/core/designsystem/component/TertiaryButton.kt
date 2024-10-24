package app.kaito_dogi.mybrary.core.designsystem.component

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import app.kaito_dogi.mybrary.core.designsystem.theme.MybraryTheme

@Composable
fun TertiaryButton(
  text: String,
  onClick: () -> Unit,
  modifier: Modifier = Modifier,
  @DrawableRes iconResId: Int? = null,
  @StringRes altResId: Int? = null,
  isLoading: Boolean = false,
  isEnabled: Boolean = true,
  colors: ButtonColors? = null,
) = TextButton(
  onClick = onClick,
  modifier = modifier,
  enabled = isEnabled && !isLoading,
  colors = colors ?: ButtonDefaults.textButtonColors().copy(
    disabledContentColor = ButtonDefaults.buttonColors().disabledContentColor,
  ),
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
private fun TertiaryButtonPreview(
  @PreviewParameter(TertiaryButtonPreviewParameterProvider::class) parameter: TertiaryButtonPreviewParameter,
) {
  MybraryTheme {
    TertiaryButton(
      text = "TertiaryButton",
      onClick = {},
      modifier = Modifier.fillMaxWidth(),
      isLoading = parameter.isLoading,
      isEnabled = parameter.isEnabled,
    )
  }
}

private class TertiaryButtonPreviewParameterProvider :
  PreviewParameterProvider<TertiaryButtonPreviewParameter> {
  override val values: Sequence<TertiaryButtonPreviewParameter>
    get() = sequenceOf(
      TertiaryButtonPreviewParameter(
        isLoading = false,
        isEnabled = true,
      ),
      TertiaryButtonPreviewParameter(
        isLoading = true,
        isEnabled = true,
      ),
      TertiaryButtonPreviewParameter(
        isLoading = false,
        isEnabled = false,
      ),
    )
}

private data class TertiaryButtonPreviewParameter(
  val isLoading: Boolean,
  val isEnabled: Boolean,
)
