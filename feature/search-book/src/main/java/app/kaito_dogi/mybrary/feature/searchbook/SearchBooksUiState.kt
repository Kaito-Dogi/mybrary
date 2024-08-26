package app.kaito_dogi.mybrary.feature.searchbook

import androidx.compose.runtime.Immutable
import app.kaito_dogi.mybrary.core.domain.model.Book

@Immutable
internal data class SearchBooksUiState(
  val bookList: List<Book>?,
  val searchQuery: String,
  val isSearching: Boolean,
  val shownMessage: String?,
) {
  companion object {
    val InitialValue = SearchBooksUiState(
      bookList = null,
      searchQuery = "",
      isSearching = false,
      shownMessage = null,
    )
  }
}
