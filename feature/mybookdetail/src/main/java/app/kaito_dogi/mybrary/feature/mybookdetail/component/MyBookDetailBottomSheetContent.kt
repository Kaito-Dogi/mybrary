package app.kaito_dogi.mybrary.feature.mybookdetail.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import app.kaito_dogi.mybrary.core.designsystem.component.Gap
import app.kaito_dogi.mybrary.core.designsystem.theme.MybraryTheme
import app.kaito_dogi.mybrary.core.domain.model.DraftMemo
import app.kaito_dogi.mybrary.core.domain.model.MyBookId
import app.kaito_dogi.mybrary.feature.mybookdetail.R

@Composable
internal fun MyBookDetailBottomSheetContent(
  draftMemo: DraftMemo,
  onFromPageChange: (String) -> Unit,
  onToPageChange: (String) -> Unit,
  onContentChange: (String) -> Unit,
  onSaveClick: () -> Unit,
  modifier: Modifier = Modifier,
) {
  Column(modifier = modifier) {
    Row(modifier = Modifier.fillMaxWidth()) {
      TextField(
        value = if (draftMemo.fromPage == null) "" else draftMemo.fromPage.toString(),
        onValueChange = onFromPageChange,
        modifier = Modifier.weight(1f),
        placeholder = { Text(text = "開始ページ") },
        keyboardOptions = KeyboardOptions.Default.copy(
          keyboardType = KeyboardType.Number,
          imeAction = ImeAction.Next,
        ),
      )
      Gap(width = MybraryTheme.space.sm)
      TextField(
        value = if (draftMemo.toPage == null) "" else draftMemo.toPage.toString(),
        onValueChange = onToPageChange,
        modifier = Modifier.weight(1f),
        placeholder = { Text(text = "終了ページ") },
        keyboardOptions = KeyboardOptions.Default.copy(
          keyboardType = KeyboardType.Number,
          imeAction = ImeAction.Next,
        ),
      )
    }
    Gap(height = MybraryTheme.space.sm)
    Row(
      modifier = Modifier.fillMaxWidth(),
      verticalAlignment = Alignment.Bottom,
    ) {
      TextField(
        value = draftMemo.content,
        onValueChange = onContentChange,
        modifier = Modifier.weight(1f),
        placeholder = { Text(text = "メモを入力…") },
        keyboardOptions = KeyboardOptions.Default.copy(
          keyboardType = KeyboardType.Text,
          imeAction = ImeAction.Send,
        ),
        keyboardActions = KeyboardActions(
          onSend = {
            onSaveClick()
          },
        ),
        minLines = 2,
      )
      IconButton(onClick = onSaveClick) {
        Icon(
          painter = painterResource(id = R.drawable.mybookdetail_send),
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
      draftMemo = DraftMemo.createInitialValue(myBookId = MyBookId(0L)),
      onFromPageChange = {},
      onToPageChange = {},
      onContentChange = {},
      onSaveClick = {},
    )
  }
}
