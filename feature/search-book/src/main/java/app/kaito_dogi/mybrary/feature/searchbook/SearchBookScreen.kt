package app.kaito_dogi.mybrary.feature.searchbook

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import app.kaito_dogi.mybrary.core.designsystem.component.AlertDialog
import app.kaito_dogi.mybrary.core.designsystem.ext.plus
import app.kaito_dogi.mybrary.core.designsystem.theme.MybraryTheme
import app.kaito_dogi.mybrary.core.domain.model.Book
import app.kaito_dogi.mybrary.core.ui.R
import app.kaito_dogi.mybrary.feature.searchbook.component.BookRow
import app.kaito_dogi.mybrary.feature.searchbook.component.BookRowSkeleton
import app.kaito_dogi.mybrary.feature.searchbook.component.SearchBookBottomAppBar

@Composable
internal fun SearchBookScreen(
  uiState: SearchBookUiState,
  snackbarHost: @Composable () -> Unit,
  onSearchQueryChange: (String) -> Unit,
  onBarcodeScannerClick: () -> Unit,
  onBookClick: (Book) -> Unit,
  onBookLongClick: (Book) -> Unit,
  onConfirmClick: () -> Unit,
  onDismissRequest: () -> Unit,
) {
  Scaffold(
    bottomBar = {
      SearchBookBottomAppBar(
        value = uiState.searchTitle,
        onValueChange = onSearchQueryChange,
        onBarcodeScannerClick = onBarcodeScannerClick,
        modifier = Modifier.imePadding(),
      )
    },
    snackbarHost = snackbarHost,
  ) { innerPadding ->
    LazyColumn(
      modifier = Modifier.fillMaxSize(),
      contentPadding = innerPadding.plus(all = MybraryTheme.spaces.md),
      verticalArrangement = Arrangement.spacedBy(MybraryTheme.spaces.md),
    ) {
      uiState.bookList?.let {
        items(
          items = uiState.bookList,
          key = { it.isbn },
        ) {
          BookRow(
            book = it,
            onClick = onBookClick,
            onLongClick = onBookLongClick,
          )
        }
      }

      if (uiState.isSearching) {
        items(
          count = 4,
          key = { "SearchResultBookRowSkeleton$it" },
        ) {
          BookRowSkeleton()
        }
      }
    }

    if (uiState.isDialogShown && uiState.selectedBook != null) {
      AlertDialog(
        title = stringResource(id = R.string.search_book_text_would_you_like_to_add_to_mybrary),
        content = uiState.selectedBook.title,
        onConfirmClick = onConfirmClick,
        confirmTextResId = R.string.search_book_text_add,
        onDismissRequest = onDismissRequest,
        dismissTextResId = R.string.search_book_text_cancel,
        onDismissClick = onDismissRequest,
        isConfirmLoading = uiState.isBookRegistering,
      )
    }
  }
}

@Preview
@Composable
private fun SearchBookScreenPreview() {
  MybraryTheme {
    SearchBookScreen(
      uiState = SearchBookUiState.InitialValue,
      snackbarHost = {},
      onSearchQueryChange = {},
      onBarcodeScannerClick = {},
      onBookClick = {},
      onBookLongClick = {},
      onConfirmClick = {},
      onDismissRequest = {},
    )
  }
}
