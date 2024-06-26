package app.kaito_dogi.mybrary.feature.searchbook

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.tooling.preview.Preview
import app.kaito_dogi.mybrary.core.designsystem.theme.MybraryTheme
import app.kaito_dogi.mybrary.core.domain.model.SearchResultBook
import app.kaito_dogi.mybrary.feature.searchbook.component.SearchBookBottomAppBar
import app.kaito_dogi.mybrary.feature.searchbook.component.SearchResultBookRow
import app.kaito_dogi.mybrary.feature.searchbook.component.SearchResultBookRowSkeleton

@Composable
internal fun SearchBookScreen(
  uiState: SearchBookUiState,
  snackbarHost: @Composable () -> Unit,
  showSnackbar: (String) -> Unit,
  onSearchQueryChange: (String) -> Unit,
  onBarcodeScannerClick: () -> Unit,
  onSearchResultClick: (SearchResultBook) -> Unit,
  onSearchResultLongClick: (SearchResultBook) -> Unit,
) {
  uiState.shownMessage?.let {
    LaunchedEffect(it) {
      showSnackbar(it)
    }
  }

  Scaffold(
    bottomBar = {
      SearchBookBottomAppBar(
        value = uiState.searchQuery,
        onValueChange = onSearchQueryChange,
        onBarcodeScannerClick = onBarcodeScannerClick,
        modifier = Modifier.windowInsetsPadding(WindowInsets.ime),
      )
    },
    snackbarHost = snackbarHost,
  ) { innerPadding ->
    val layoutDirection = LocalLayoutDirection.current
    LazyColumn(
      modifier = Modifier.fillMaxSize(),
      contentPadding = PaddingValues(
        start = innerPadding.calculateStartPadding(layoutDirection) + MybraryTheme.space.md,
        top = innerPadding.calculateTopPadding() + MybraryTheme.space.md,
        end = innerPadding.calculateEndPadding(layoutDirection) + MybraryTheme.space.md,
        bottom = innerPadding.calculateBottomPadding(),
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

        item {
          // リストの1番下に Arrangement.spacedBy で余白をもたせるため、高さ0の要素を表示
          Spacer(modifier = Modifier.fillMaxWidth())
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
private fun SearchBookScreenPreview() {
  MybraryTheme {
    SearchBookScreen(
      uiState = SearchBookUiState.InitialValue,
      snackbarHost = {},
      showSnackbar = {},
      onSearchQueryChange = {},
      onBarcodeScannerClick = {},
      onSearchResultClick = {},
      onSearchResultLongClick = {},
    )
  }
}
