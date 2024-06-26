package app.kaito_dogi.mybrary.feature.searchbook

import androidx.compose.runtime.Immutable
import app.kaito_dogi.mybrary.core.domain.model.SearchResultBook

@Immutable
data class SearchBookUiState(
  val searchResults: List<SearchResultBook>?,
) {
  companion object {
    val InitialValue = SearchBookUiState(
      searchResults = null,
    )
  }
}
