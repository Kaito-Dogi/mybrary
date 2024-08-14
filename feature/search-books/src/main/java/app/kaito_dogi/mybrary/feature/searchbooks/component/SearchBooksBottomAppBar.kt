package app.kaito_dogi.mybrary.feature.searchbooks.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import app.kaito_dogi.mybrary.core.designsystem.component.Icon
import app.kaito_dogi.mybrary.core.designsystem.component.Text
import app.kaito_dogi.mybrary.core.designsystem.theme.MybraryTheme
import app.kaito_dogi.mybrary.core.ui.R

@Composable
internal fun SearchBooksBottomAppBar(
  value: String,
  onValueChange: (String) -> Unit,
  onBarcodeScannerClick: () -> Unit,
  modifier: Modifier = Modifier,
) {
  BottomAppBar(
    modifier = modifier,
    contentPadding = PaddingValues(horizontal = MybraryTheme.space.md),
  ) {
    TextField(
      value = value,
      onValueChange = onValueChange,
      modifier = Modifier.weight(1f),
      placeholder = { Text(textResId = R.string.search_books_placeholder_enter_search_keywords) },
      leadingIcon = {
        Icon(
          iconResId = R.drawable.icon_search,
          altResId = R.string.search_books_desc_search_for_books,
        )
      },
      keyboardOptions = KeyboardOptions.Default.copy(
        imeAction = ImeAction.Done,
      ),
      singleLine = true,
    )

//    Gap(width = MybraryTheme.space.sm)
//
//    // TODO: v2 以降で実装する
//    FloatingActionButton(
//      onClick = onBarcodeScannerClick,
//      elevation = FloatingActionButtonDefaults.elevationZero(),
//    ) {
//      Icon(
//        iconResId = R.drawable.icon_barcode_scanner,
//        altResId = R.string.search_books_desc_scan_book_barcode,
//      )
//    }
  }
}

@Preview
@Composable
private fun SearchBooksBottomAppBarPreview() {
  MybraryTheme {
    SearchBooksBottomAppBar(
      value = "",
      onValueChange = {},
      onBarcodeScannerClick = {},
    )
  }
}
