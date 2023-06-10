package app.doggy.mybrary.ui.book.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.doggy.core.common.util.UnixTime
import app.doggy.mybrary.R
import app.doggy.mybrary.core.domain.model.author.Author
import app.doggy.mybrary.core.domain.model.author.AuthorId
import app.doggy.mybrary.core.domain.model.book.Book
import app.doggy.mybrary.core.domain.model.book.BookId
import app.doggy.mybrary.core.domain.model.book.BookStatus
import app.doggy.mybrary.core.domain.model.book.BookTotalPage
import app.doggy.mybrary.core.domain.repository.BookRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class RegisterViewModel @Inject constructor(
  private val bookRepository: BookRepository,
) : ViewModel() {
  private val _uiState = MutableStateFlow(RegisterState())
  val uiState: StateFlow<RegisterState> = _uiState.asStateFlow()

  // TODO: 本の内容を更新する処理の実装
  fun onRegisterButtonClick(
    title: String,
    authorName: String,
    description: String,
    totalPage: String,
  ) {
    viewModelScope.launch {
      _uiState.update { it.copy(isLoading = true) }
      runCatching {
        val isValid = title.isNotBlank() && authorName.isNotBlank() && totalPage.isNotBlank() && totalPage.first() != '0'
        if (!isValid) throw IllegalArgumentException()

        bookRepository.registerBook(
          book = Book(
            id = BookId(-1),
            title = title,
            description = description,
            totalPage = BookTotalPage(totalPage.toInt()),
            imageUrl = "",
            authors = listOf(
              Author(
                id = AuthorId(-1),
                name = authorName,
              ),
            ),
            registeredAt = UnixTime(0),
            isPinned = false,
            status = BookStatus.WAITING,
          ),
        )
      }.onSuccess {
        _uiState.update { currentState ->
          currentState.copy(
            isLoading = false,
            isBookRegistered = true,
          )
        }
      }.onFailure { throwable ->
        _uiState.update { currentState ->
          currentState.copy(
            isLoading = false,
            errorMessageRes = when (throwable) {
              is IllegalArgumentException -> R.string.error_invalid_input
              else -> R.string.error_failed_to_register_book
            },
          )
        }
      }
    }
  }

  fun onErrorMessageShown() {
    _uiState.update { it.copy(errorMessageRes = null) }
  }
}
