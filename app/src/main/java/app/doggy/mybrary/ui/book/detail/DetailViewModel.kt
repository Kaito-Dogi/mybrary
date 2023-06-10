package app.doggy.mybrary.ui.book.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.doggy.mybrary.R
import app.doggy.mybrary.core.domain.model.book.BookId
import app.doggy.mybrary.core.domain.repository.BookRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class DetailViewModel @Inject constructor(
  savedStateHandle: SavedStateHandle,
  private val bookRepository: BookRepository,
) : ViewModel() {
  private val args = DetailFragmentArgs.fromSavedStateHandle(savedStateHandle)

  private val _uiState = MutableStateFlow(DetailState())
  val uiState: StateFlow<DetailState> = _uiState.asStateFlow()

  init {
    viewModelScope.launch {
      _uiState.update { it.copy(isLoading = true) }
      runCatching {
        bookRepository.getBook(bookId = BookId(args.bookId)).first()
      }.onSuccess { book ->
        _uiState.update { currentState ->
          currentState.copy(
            book = book,
            isLoading = false,
          )
        }
      }.onFailure {
        _uiState.update {
          it.copy(
            isLoading = false,
            errorMessageRes = R.string.error_failed_to_get_book,
          )
        }
      }
    }
  }

  fun onErrorMessageShown() {
    _uiState.update { it.copy(errorMessageRes = null) }
  }
}
