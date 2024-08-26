package app.kaito_dogi.mybrary.feature.searchbooks

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import app.kaito_dogi.mybrary.core.designsystem.ext.plus
import app.kaito_dogi.mybrary.core.designsystem.theme.MybraryTheme
import app.kaito_dogi.mybrary.feature.searchbooks.component.SearchBooksBottomAppBar
import app.kaito_dogi.mybrary.feature.searchbooks.component.SearchResultBookRow
import app.kaito_dogi.mybrary.feature.searchbooks.component.SearchResultBookRowSkeleton

@Composable
internal fun SearchBooksScreen(
  uiState: SearchBooksUiState,
  snackbarHost: @Composable () -> Unit,
  onSearchQueryChange: (String) -> Unit,
  onBarcodeScannerClick: () -> Unit,
  onSearchResultClick: (SearchedBook) -> Unit,
  onSearchResultLongClick: (SearchedBook) -> Unit,
) {
  Scaffold(
    bottomBar = {
      SearchBooksBottomAppBar(
        value = uiState.searchQuery,
        onValueChange = onSearchQueryChange,
        onBarcodeScannerClick = onBarcodeScannerClick,
        modifier = Modifier.windowInsetsPadding(WindowInsets.ime),
      )
    },
    snackbarHost = snackbarHost,
  ) { innerPadding ->
    LazyColumn(
      modifier = Modifier.fillMaxSize(),
      contentPadding = innerPadding.plus(
        start = MybraryTheme.space.md,
        top = MybraryTheme.space.sm,
        end = MybraryTheme.space.md,
        bottom = MybraryTheme.space.md,
      ),
      verticalArrangement = Arrangement.spacedBy(MybraryTheme.space.md),
    ) {
      uiState.searchResults?.let {
        items(
          items = uiState.searchResults,
          key = { it.externalId.value },
        ) {
          SearchResultBookRow(
            searchResultBook = it,
            onClick = onSearchResultClick,
            onLongClick = onSearchResultLongClick,
          )
        }
      }

      if (uiState.isSearching) {
        items(
          count = 4,
          key = { "SearchResultBookRowSkeleton$it" },
        ) {
          SearchResultBookRowSkeleton()
        }
      }
    }
  }
}

@Preview
@Composable
private fun SearchBooksScreenPreview() {
  MybraryTheme {
    SearchBooksScreen(
      uiState = SearchBooksUiState.InitialValue,
      snackbarHost = {},
      onSearchQueryChange = {},
      onBarcodeScannerClick = {},
      onSearchResultClick = {},
      onSearchResultLongClick = {},
    )
  }
}
