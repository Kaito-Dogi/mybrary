package app.kaito_dogi.mybrary.feature.searchbooks

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.kaito_dogi.mybrary.core.domain.model.SearchResultBook
import app.kaito_dogi.mybrary.core.domain.repository.MyBookRepository
import app.kaito_dogi.mybrary.core.domain.repository.SearchBooksRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
internal class SearchBooksViewModel @Inject constructor(
  private val searchBooksRepository: SearchBooksRepository,
  private val myBookRepository: MyBookRepository,
) : ViewModel() {
  private val _uiState = MutableStateFlow(SearchBooksUiState.InitialValue)
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
          val searchResult = searchBooksRepository.searchBooks(
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

  fun onSearchResultBookLongClick(
    searchResultBook: SearchResultBook,
  ) {
    viewModelScope.launch {
      try {
        val isSuccess = myBookRepository.registerMyBook(searchResultBook = searchResultBook)
        if (isSuccess) {
          _uiState.update {
            it.copy(
              shownMessage = "『${searchResultBook.title}』をMybraryに追加しました",
            )
          }
        }
      } catch (e: Exception) {
        // TODO: 共通のエラーハンドリングを表示
        println("あああ: $e")
      }
    }
  }

  fun onMessageShown() {
    _uiState.update {
      it.copy(
        shownMessage = null,
      )
    }
  }
}
