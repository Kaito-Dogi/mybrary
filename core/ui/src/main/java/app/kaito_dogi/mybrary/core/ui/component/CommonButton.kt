package app.kaito_dogi.mybrary.core.ui.component

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
import androidx.compose.ui.graphics.vector.ImageVector
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
  icon: ImageVector? = null,
  iconContentDescription: String? = null,
  isLoading: Boolean = false,
  isEnabled: Boolean = true,
) {
  Button(
    onClick = onClick,
    modifier = modifier,
    enabled = isEnabled && !isLoading,
  ) {
    if (icon != null && !isLoading) {
      Icon(
        imageVector = icon,
        contentDescription = iconContentDescription,
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
}

@Preview(showBackground = true)
@Composable
private fun CommonButtonPreview(
  @PreviewParameter(CommonButtonPreviewParameterProvider::class) parameter: CommonButtonPreviewParameter,
) {
  MybraryTheme {
    CommonButton(
      text = "Common Button",
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