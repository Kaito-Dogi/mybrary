package app.kaito_dogi.mybrary.feature.searchbook.destination.searchbook.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.BottomAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.kaito_dogi.mybrary.core.designsystem.component.TextField
import app.kaito_dogi.mybrary.core.designsystem.theme.MybraryTheme
import app.kaito_dogi.mybrary.core.ui.R

private val Elevation = 3.0.dp

@Composable
internal fun SearchBookBottomAppBar(
  value: String,
  onValueChange: (String) -> Unit,
  onBarcodeScannerClick: () -> Unit,
  modifier: Modifier = Modifier,
) {
  BottomAppBar(
    modifier = modifier,
    containerColor = Color.Transparent,
    contentPadding = PaddingValues(horizontal = MybraryTheme.spaces.md),
  ) {
    TextField(
      value = value,
      onValueChange = onValueChange,
      modifier = Modifier
        .shadow(
          elevation = Elevation,
          shape = MybraryTheme.shapes.circle,
        )
        .weight(1f),
      placeholderResId = R.string.search_book_placeholder_enter_search_keywords,
      leadingIconResId = R.drawable.icon_search,
      leadingIconAltResId = R.string.search_book_alt_search_for_books,
      imeAction = ImeAction.Done,
      singleLine = true,
      shape = MybraryTheme.shapes.circle,
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
private fun SearchBookBottomAppBarPreview() {
  MybraryTheme {
    SearchBookBottomAppBar(
      value = "",
      onValueChange = {},
      onBarcodeScannerClick = {},
    )
  }
}
