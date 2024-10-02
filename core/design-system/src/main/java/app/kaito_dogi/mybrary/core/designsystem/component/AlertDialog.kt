package app.kaito_dogi.mybrary.core.designsystem.component

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import app.kaito_dogi.mybrary.core.designsystem.theme.MybraryTheme

@Composable
fun AlertDialog(
  title: String,
  @StringRes confirmTextResId: Int,
  onConfirmClick: () -> Unit,
  onDismissRequest: () -> Unit,
  modifier: Modifier = Modifier,
  content: String? = null,
  @StringRes dismissTextResId: Int? = null,
  onDismissClick: (() -> Unit)? = null,
  isConfirmLoading: Boolean = false,
  isDismissLoading: Boolean = false,
  isDanger: Boolean = false,
) = androidx.compose.material3.AlertDialog(
  onDismissRequest = {
    if (!isConfirmLoading && !isDismissLoading) {
      onDismissRequest()
    }
  },
  confirmButton = {
    TertiaryButton(
      textResId = confirmTextResId,
      onClick = onConfirmClick,
      isLoading = isConfirmLoading,
      isEnabled = !isDismissLoading,
    )
  },
  modifier = modifier,
  dismissButton = if (dismissTextResId != null && onDismissClick != null) {
    {
      TertiaryButton(
        textResId = dismissTextResId,
        onClick = onDismissClick,
        isLoading = isDismissLoading,
        isEnabled = !isConfirmLoading,
        colors = ButtonDefaults.textButtonColors().copy(
          containerColor = if (isDanger) MybraryTheme.colorScheme.errorContainer else Color.Unspecified,
          contentColor = if (isDanger) MybraryTheme.colorScheme.error else Color.Unspecified,
          disabledContainerColor = if (isDanger) ButtonDefaults.buttonColors().disabledContainerColor else Color.Unspecified,
          disabledContentColor = ButtonDefaults.buttonColors().disabledContentColor,
        ),
      )
    }
  } else {
    null
  },
  title = {
    Text(
      text = title,
      modifier = Modifier.fillMaxWidth(),
      textAlign = TextAlign.Center,
      style = MybraryTheme.typography.titleMedium,
    )
  },
  text = content?.let{ {Text(text = content)} },
  shape = MybraryTheme.shapes.small,
)

@Preview
@Composable
private fun AlertDialogPreview(
  @PreviewParameter(AlertDialogPreviewParameterProvider::class) parameter: AlertDialogPreviewParameter,
) {
  MybraryTheme {
    AlertDialog(
      title = "タイトル",
      content = "内容",
      confirmTextResId = android.R.string.unknownName,
      onConfirmClick = {},
      onDismissRequest = {},
      dismissTextResId = parameter.dismissTextResId,
      onDismissClick = parameter.onDismissClick,
      isConfirmLoading = parameter.isConfirmLoading,
      isDismissLoading = parameter.isDismissLoading,
      isDanger = parameter.isDanger,
    )
  }
}

private class AlertDialogPreviewParameterProvider :
  PreviewParameterProvider<AlertDialogPreviewParameter> {
  override val values: Sequence<AlertDialogPreviewParameter>
    get() = sequenceOf(
      AlertDialogPreviewParameter(
        dismissTextResId = null,
        onDismissClick = null,
        isConfirmLoading = false,
        isDismissLoading = false,
        isDanger = false,
      ),
      AlertDialogPreviewParameter(
        dismissTextResId = android.R.string.unknownName,
        onDismissClick = {},
        isConfirmLoading = false,
        isDismissLoading = false,
        isDanger = false,
      ),
      AlertDialogPreviewParameter(
        dismissTextResId = android.R.string.unknownName,
        onDismissClick = {},
        isConfirmLoading = true,
        isDismissLoading = false,
        isDanger = false,
      ),
      AlertDialogPreviewParameter(
        dismissTextResId = android.R.string.unknownName,
        onDismissClick = {},
        isConfirmLoading = false,
        isDismissLoading = false,
        isDanger = true,
      ),
      AlertDialogPreviewParameter(
        dismissTextResId = android.R.string.unknownName,
        onDismissClick = {},
        isConfirmLoading = true,
        isDismissLoading = false,
        isDanger = true,
      ),
      AlertDialogPreviewParameter(
        dismissTextResId = android.R.string.unknownName,
        onDismissClick = {},
        isConfirmLoading = false,
        isDismissLoading = true,
        isDanger = true,
      ),
    )
}

private data class AlertDialogPreviewParameter(
  @StringRes val dismissTextResId: Int?,
  val onDismissClick: (() -> Unit)?,
  val isConfirmLoading: Boolean,
  val isDismissLoading: Boolean,
  val isDanger: Boolean,
)
