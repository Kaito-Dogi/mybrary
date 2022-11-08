package app.doggy.newmybrary.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.doggy.newmybrary.domain.model.Book
import app.doggy.newmybrary.domain.repository.BookRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class HomeViewModel @Inject constructor(
  private val bookRepository: BookRepository,
) : ViewModel() {
  private val _uiState = MutableStateFlow(HomeState.initial())
  val uiState: StateFlow<HomeState> = _uiState.asStateFlow()

  fun onViewCreated() {
    viewModelScope.launch {
      _uiState.update { it.copy(isLoading = true) }
      runCatching {
        bookRepository.getBooks()
      }.onSuccess { books ->
        _uiState.update { currentState ->
          currentState.copy(
            uiModels = books.map { it.toHomeUiModel() },
            isLoading = false,
          )
        }
      }.onFailure {
        // TODO: エラーハンドリング
        _uiState.update { it.copy(isLoading = false) }
      }
    }
  }

  private fun onBookClick(id: Long) {
  }

  private fun Book.toHomeUiModel() = HomeUiModel.BookUiModel(
    book = this,
    onClick = ::onBookClick,
  )
}
