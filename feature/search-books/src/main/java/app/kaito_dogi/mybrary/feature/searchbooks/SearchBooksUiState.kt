package app.kaito_dogi.mybrary.feature.searchbooks

import androidx.compose.runtime.Immutable

@Immutable
internal data class SearchBooksUiState(
  val searchResults: List<SearchedBook>?,
  val searchQuery: String,
  val isSearching: Boolean,
  val shownMessage: String?,
) {
  companion object {
    val InitialValue = SearchBooksUiState(
      searchResults = null,
      searchQuery = "",
      isSearching = false,
      shownMessage = null,
    )
  }
}
