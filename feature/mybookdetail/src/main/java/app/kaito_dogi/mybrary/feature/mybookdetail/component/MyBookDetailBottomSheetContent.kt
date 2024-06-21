package app.kaito_dogi.mybrary.feature.mybookdetail.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import app.kaito_dogi.mybrary.core.designsystem.component.Gap
import app.kaito_dogi.mybrary.core.designsystem.theme.MybraryTheme

@Composable
internal fun MyBookDetailBottomSheetContent(
  onSaveClick: () -> Unit,
  modifier: Modifier = Modifier,
) {
  Column(modifier = modifier.fillMaxWidth()) {
    Row(modifier = Modifier.fillMaxWidth()) {
      TextField(
        value = "",
        onValueChange = {},
        modifier = Modifier.weight(1f),
      )
      Gap(width = MybraryTheme.space.sm)
      TextField(
        value = "",
        onValueChange = {},
        modifier = Modifier.weight(1f),
      )
    }
    Gap(height = MybraryTheme.space.sm)
    Row(
      modifier = Modifier.fillMaxWidth(),
      verticalAlignment = Alignment.Bottom,
    ) {
      TextField(
        value = "",
        onValueChange = {},
        modifier = Modifier.weight(1f),
        minLines = 2,
      )
      IconButton(onClick = onSaveClick) {
        Icon(
          imageVector = Icons.AutoMirrored.Outlined.Send,
          contentDescription = "メモを保存する",
        )
      }
    }
  }
}

@Preview
@Composable
private fun MyBookDetailBottomSheetContentPreview() {
  MybraryTheme {
    MyBookDetailBottomSheetContent(
      onSaveClick = {},
    )
  }
}
