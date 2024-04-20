package app.doggy.mybrary.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.doggy.mybrary.R
import app.doggy.mybrary.core.domain.legacy.model.book.Book
import app.doggy.mybrary.core.domain.repository.legacy.BookRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class HomeViewModel @Inject constructor(
  private val bookRepository: BookRepository,
) : ViewModel() {
  private val _uiState = MutableStateFlow(HomeState())
  val uiState: StateFlow<HomeState> = _uiState.asStateFlow()

  init {
    viewModelScope.launch {
      _uiState.update { it.copy(isLoading = true) }
      runCatching {
        bookRepository.getBooks().first()
      }.onSuccess { books ->
        _uiState.update { currentState ->
          currentState.copy(
            uiModels = books.map { it.toHomeUiModel() },
            isLoading = false,
          )
        }
      }.onFailure {
        _uiState.update {
          it.copy(
            isLoading = false,
            errorMessageRes = R.string.error_failed_to_get_books,
          )
        }
      }
    }
  }

  fun onErrorMessageShown() {
    _uiState.update { it.copy(errorMessageRes = null) }
  }

  fun onNavigate() {
    _uiState.update { it.copy(clickedBookId = null) }
  }

  private fun onBookClicked(id: Long) {
    _uiState.update { it.copy(clickedBookId = id) }
  }

  private fun Book.toHomeUiModel() = HomeUiModel.BookUiModel(
    book = this,
    onClick = ::onBookClicked,
  )
}
