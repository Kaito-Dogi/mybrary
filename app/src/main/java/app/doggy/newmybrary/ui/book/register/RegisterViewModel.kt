package app.doggy.newmybrary.ui.book.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.doggy.newmybrary.domain.model.Book
import app.doggy.newmybrary.domain.repository.BookRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class RegisterViewModel @Inject constructor(
  private val bookRepository: BookRepository,
) : ViewModel() {
  private val _uiState = MutableStateFlow(RegisterState.initial())
  val uiState: StateFlow<RegisterState> = _uiState.asStateFlow()

  fun onRegisterButtonClick(book: Book) {
    viewModelScope.launch {
      runCatching {
        bookRepository.registerBook(book)
      }.onSuccess {
        // TODO: 成功した時のイベントを発火する
      }.onFailure {
        // TODO: エラーハンドリング
      }
    }
  }
}
