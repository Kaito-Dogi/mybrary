package app.kaito_dogi.mybrary.feature.searchbook

import androidx.compose.runtime.Immutable
import app.kaito_dogi.mybrary.core.domain.model.SearchResultBook

@Immutable
internal data class SearchBooksUiState(
  val searchResults: List<SearchResultBook>?,
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
