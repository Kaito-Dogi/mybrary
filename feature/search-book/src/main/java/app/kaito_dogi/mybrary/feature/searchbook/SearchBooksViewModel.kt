package app.kaito_dogi.mybrary.feature.searchbook

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.kaito_dogi.mybrary.core.domain.model.Book
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
          bookList = null,
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
          _uiState.update { it.copy(bookList = searchResult) }
        } catch (e: Exception) {
          // TODO: 共通のエラーハンドリングを表示
          println("あああ: $e")
        }
      }
    }.invokeOnCompletion {
      _uiState.update { it.copy(isSearching = false) }
    }
  }

  fun onBookLongClick(
    book: Book,
  ) {
    viewModelScope.launch {
      try {
        myBookRepository.registerMyBook(book = book)
        _uiState.update { it.copy(shownMessage = "『${book.title}』をMybraryに追加しました") }
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
