package app.kaito_dogi.mybrary.feature.searchbook.destination.searchbook

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import app.kaito_dogi.mybrary.core.designsystem.R
import app.kaito_dogi.mybrary.core.designsystem.component.AlertDialog
import app.kaito_dogi.mybrary.core.designsystem.component.NavigationBarContentScaffold
import app.kaito_dogi.mybrary.core.designsystem.ext.plus
import app.kaito_dogi.mybrary.core.designsystem.theme.MybraryTheme
import app.kaito_dogi.mybrary.core.domain.model.Book
import app.kaito_dogi.mybrary.feature.searchbook.destination.searchbook.component.BookRow
import app.kaito_dogi.mybrary.feature.searchbook.destination.searchbook.component.BookRowSkeleton
import app.kaito_dogi.mybrary.feature.searchbook.destination.searchbook.component.SearchBookFloatingToolbar

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
internal fun SearchBookScreen(
  uiState: SearchBookUiState,
  snackbarHost: @Composable () -> Unit,
  onSearchQueryChange: (String) -> Unit,
  onBookClick: (Book) -> Unit,
  onBookLongClick: (Book) -> Unit,
  onBookRakutenClick: (Book) -> Unit,
  onConfirmClick: () -> Unit,
  onDismissRequest: () -> Unit,
) {
  NavigationBarContentScaffold(
    bottomBar = {
      SearchBookFloatingToolbar(
        value = uiState.searchTitle,
        onValueChange = onSearchQueryChange,
        modifier = Modifier
          .imePadding()
          .windowInsetsPadding(insets = BottomAppBarDefaults.windowInsets)
          .padding(
            start = MybraryTheme.spaces.md,
            end = MybraryTheme.spaces.md,
          )
      )
    },
    snackbarHost = snackbarHost,
  ) { innerPadding ->
    Box(
      modifier = Modifier.fillMaxSize(),
    ) {
      LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = innerPadding.plus(all = MybraryTheme.spaces.md),
        verticalArrangement = Arrangement.spacedBy(space = MybraryTheme.spaces.md),
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
              onRakutenClick = onBookRakutenClick,
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
      onBookClick = {},
      onBookLongClick = {},
      onBookRakutenClick = {},
      onConfirmClick = {},
      onDismissRequest = {},
    )
  }
}
