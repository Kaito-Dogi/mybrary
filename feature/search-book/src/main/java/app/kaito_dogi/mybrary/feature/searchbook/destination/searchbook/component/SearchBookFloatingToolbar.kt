package app.kaito_dogi.mybrary.feature.searchbook.destination.searchbook.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.HorizontalFloatingToolbar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import app.kaito_dogi.mybrary.core.designsystem.R
import app.kaito_dogi.mybrary.core.designsystem.component.TextField
import app.kaito_dogi.mybrary.core.designsystem.theme.MybraryTheme

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
internal fun SearchBookFloatingToolbar(
  value: String,
  onValueChange: (String) -> Unit,
  modifier: Modifier = Modifier,
  isExpanded: Boolean = true,
) {
  HorizontalFloatingToolbar(
    expanded = isExpanded,
    modifier = modifier,
  ) {
    TextField(
      value = value,
      onValueChange = onValueChange,
      placeholderResId = R.string.search_book_placeholder_enter_search_keywords,
      modifier = Modifier.fillMaxWidth(),
      leadingIconResId = R.drawable.icon_search,
      leadingIconAltResId = R.string.search_book_alt_search_for_books,
      imeAction = ImeAction.Done,
      singleLine = true,
      shape = MybraryTheme.shapes.circle,
    )
  }
}

@Preview
@Composable
private fun SearchBookFloatingToolbarPreview() {
  MybraryTheme {
    SearchBookFloatingToolbar(
      value = "",
      onValueChange = {},
      isExpanded = true,
    )
  }
}
