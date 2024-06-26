package app.kaito_dogi.mybrary.feature.searchbook

import androidx.compose.runtime.Immutable
import app.kaito_dogi.mybrary.core.domain.model.SearchResultBook

@Immutable
data class SearchBookUiState(
  val searchResults: List<SearchResultBook>?,
  val searchQuery: String,
) {
  companion object {
    val InitialValue = SearchBookUiState(
      searchResults = null,
      searchQuery = "",
    )
  }
}
