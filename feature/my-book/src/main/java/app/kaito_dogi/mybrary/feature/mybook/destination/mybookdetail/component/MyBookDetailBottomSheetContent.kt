package app.kaito_dogi.mybrary.feature.mybook.destination.mybookdetail.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import app.kaito_dogi.mybrary.core.designsystem.component.Icon
import app.kaito_dogi.mybrary.core.designsystem.component.TextField
import app.kaito_dogi.mybrary.core.designsystem.theme.MybraryTheme
import app.kaito_dogi.mybrary.core.domain.model.DraftMemo
import app.kaito_dogi.mybrary.core.domain.model.MyBookId
import app.kaito_dogi.mybrary.core.ui.R

private const val Radix = 10

@Composable
internal fun MyBookDetailBottomSheetContent(
  draftMemo: DraftMemo,
  isContentTextFieldError: Boolean,
  onStartPageChange: (String) -> Unit,
  onEndPageChange: (String) -> Unit,
  onContentChange: (String) -> Unit,
  onSaveClick: () -> Unit,
  modifier: Modifier = Modifier,
) {
  Column(
    modifier = modifier,
    verticalArrangement = Arrangement.spacedBy(MybraryTheme.spaces.sm),
  ) {
    Row(
      modifier = Modifier.fillMaxWidth(),
      horizontalArrangement = Arrangement.spacedBy(MybraryTheme.spaces.sm),
    ) {
      TextField(
        value = draftMemo.pageRange?.start?.toString(radix = Radix) ?: "",
        onValueChange = onStartPageChange,
        modifier = Modifier.weight(1f),
        placeholderResId = R.string.my_book_detail_placeholder_start_page,
        keyboardType = KeyboardType.NumberPassword,
        imeAction = ImeAction.Next,
        singleLine = true,
      )

      TextField(
        value = draftMemo.pageRange?.end?.toString(radix = Radix) ?: "",
        onValueChange = onEndPageChange,
        modifier = Modifier.weight(1f),
        isEnabled = draftMemo.pageRange?.start != null,
        placeholderResId = R.string.my_book_detail_placeholder_end_page,
        keyboardType = KeyboardType.NumberPassword,
        imeAction = ImeAction.Next,
        singleLine = true,
      )
    }

    Row(
      modifier = Modifier.fillMaxWidth(),
      verticalAlignment = Alignment.Bottom,
    ) {
      TextField(
        value = draftMemo.content,
        onValueChange = onContentChange,
        modifier = Modifier.weight(1f),
        placeholderResId = R.string.my_book_detail_placeholder_enter_memo,
        isError = isContentTextFieldError,
        keyboardType = KeyboardType.Text,
        onSend = { onSaveClick() },
        minLines = 2,
      )

      IconButton(onClick = onSaveClick) {
        Icon(
          iconResId = R.drawable.icon_send,
          altResId = R.string.my_book_detail_alt_save_a_memo,
        )
      }
    }
  }
}

@Preview(showBackground = true)
@Composable
private fun MyBookDetailBottomSheetContentPreview() {
  MybraryTheme {
    MyBookDetailBottomSheetContent(
      draftMemo = DraftMemo.createInitialValue(
        myBookId = MyBookId(value = ""),
      ),
      isContentTextFieldError = false,
      onStartPageChange = {},
      onEndPageChange = {},
      onContentChange = {},
      onSaveClick = {},
    )
  }
}
