package app.kaito_dogi.mybrary.core.designsystem.component

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import app.kaito_dogi.mybrary.core.designsystem.theme.MybraryTheme

@Composable
fun TextField(
  value: String,
  onValueChange: (String) -> Unit,
  @StringRes placeholderResId: Int,
  modifier: Modifier = Modifier,
  @DrawableRes leadingIconResId: Int? = null,
  @StringRes leadingIconAltResId: Int? = null,
  isError: Boolean = false,
  keyboardType: KeyboardType = KeyboardType.Text,
  imeAction: ImeAction = ImeAction.Default,
  onSend: (() -> Unit)? = null,
  singleLine: Boolean = false,
  minLines: Int = 1,
) = androidx.compose.material3.OutlinedTextField(
  value = value,
  onValueChange = onValueChange,
  modifier = modifier,
  placeholder = {
    Text(textResId = placeholderResId)
  },
  leadingIcon = leadingIconResId?.let {
    {
      Icon(
        iconResId = it,
        altResId = leadingIconAltResId,
      )
    }
  },
  isError = isError,
  keyboardOptions = KeyboardOptions(
    keyboardType = keyboardType,
    imeAction = imeAction,
  ),
  keyboardActions = KeyboardActions(
    onSend = onSend?.let { { onSend() } },
  ),
  singleLine = singleLine,
  minLines = minLines,
  shape = MybraryTheme.shapes.small,
  colors = OutlinedTextFieldDefaults.colors().copy(
    focusedContainerColor = MybraryTheme.colorScheme.surface,
    unfocusedContainerColor = MybraryTheme.colorScheme.surface,
    disabledContainerColor = MybraryTheme.colorScheme.surface,
    errorContainerColor = MybraryTheme.colorScheme.surface,
  ),
)

@Preview
@Composable
private fun TextFieldPreview(
  @PreviewParameter(TextFieldPreviewParameterProvider::class) parameter: TextFieldPreviewParameter,
) {
  MybraryTheme {
    TextField(
      value = "",
      onValueChange = {},
      placeholderResId = android.R.string.unknownName,
      isError = parameter.isError,
    )
  }
}

private class TextFieldPreviewParameterProvider :
  PreviewParameterProvider<TextFieldPreviewParameter> {
  override val values: Sequence<TextFieldPreviewParameter>
    get() = sequenceOf(
      TextFieldPreviewParameter(isError = false),
      TextFieldPreviewParameter(isError = true),
    )
}

private data class TextFieldPreviewParameter(
  val isError: Boolean,
)
