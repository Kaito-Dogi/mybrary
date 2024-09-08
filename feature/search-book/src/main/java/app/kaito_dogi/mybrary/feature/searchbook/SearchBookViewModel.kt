package app.kaito_dogi.mybrary.feature.searchbook

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.kaito_dogi.mybrary.core.common.coroutines.LaunchSafe
import app.kaito_dogi.mybrary.core.domain.model.Book
import app.kaito_dogi.mybrary.core.domain.repository.BookRepository
import app.kaito_dogi.mybrary.core.domain.repository.MyBookRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

@HiltViewModel
internal class SearchBookViewModel @Inject constructor(
  private val bookRepository: BookRepository,
  private val myBookRepository: MyBookRepository,
  launchSafe: LaunchSafe,
) : ViewModel(), LaunchSafe by launchSafe {
  private val _uiState = MutableStateFlow(SearchBookUiState.InitialValue)
  val uiState = _uiState.asStateFlow()

  fun onSearchQueryChange(searchTitle: String) {
    viewModelScope.launchSafe {
      _uiState.update {
        it.copy(
          bookList = null,
          searchTitle = searchTitle,
          isSearching = true,
        )
      }
      if (searchTitle.isNotBlank()) {
        // FIXME: isbn を渡せるようにする
        // FIXME: author を渡せるようにする
        // FIXME: publisher を渡せるようにする
        // FIXME: Paging を実装する
        // FIXME: sort できるようにする
        val bookList = bookRepository.searchBook(
          title = searchTitle,
          isbn = null,
        )
        _uiState.update { it.copy(bookList = bookList) }
      }
    }.invokeOnCompletion {
      _uiState.update { it.copy(isSearching = false) }
    }
  }

  fun onBookLongClick(book: Book) {
    _uiState.update {
      it.copy(
        selectedBook = book,
        isDialogShown = true,
      )
    }
  }

  fun onConfirmClick() {
    uiState.value.selectedBook?.let { selectedBook ->
      viewModelScope.launchSafe {
        _uiState.update { it.copy(isBookRegistering = true) }

        myBookRepository.addBookToMybrary(book = selectedBook)

        _uiState.update {
          // FIXME: String Resources を渡すようにする
          it.copy(
            shownMessage = "『${selectedBook.title}』をMybraryに追加しました",
            isDialogShown = false,
          )
        }
      }.invokeOnCompletion {
        _uiState.update { it.copy(isBookRegistering = false) }
      }
    }
  }

  fun onDismissClick() {
    _uiState.update { it.copy(isDialogShown = false) }
  }

  fun onMessageShown() {
    _uiState.update {
      it.copy(
        shownMessage = null,
      )
    }
  }
}
