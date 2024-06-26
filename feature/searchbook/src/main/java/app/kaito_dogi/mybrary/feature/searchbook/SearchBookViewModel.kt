package app.kaito_dogi.mybrary.feature.searchbook

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.kaito_dogi.mybrary.core.domain.repository.SearchBookRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
internal class SearchBookViewModel @Inject constructor(
  private val searchBookRepository: SearchBookRepository,
) : ViewModel() {
  private val _uiState = MutableStateFlow(SearchBookUiState.InitialValue)
  val uiState = _uiState.asStateFlow()

  fun onSearchQueryChange(searchQuery: String) {
    viewModelScope.launch {
      _uiState.update {
        it.copy(
          searchResults = null,
          searchQuery = searchQuery,
          isSearching = true,
        )
      }
      if (searchQuery.isNotBlank()) {
        try {
          val searchResult = searchBookRepository.searchBooks(
            query = searchQuery,
            startIndex = 0,
          )
          _uiState.update { it.copy(searchResults = searchResult) }
        } catch (e: Exception) {
          // TODO: 共通のエラーハンドリングを表示
          println("あああ: $e")
        }
      }
    }.invokeOnCompletion {
      _uiState.update { it.copy(isSearching = false) }
    }
  }
}
