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

  // FIXME: 暫定的に API 呼び出し
  fun init() {
    viewModelScope.launch {
      try {
        val searchResult = searchBookRepository.searchBooks(
          query = "ハッカーと画家",
          maxResults = 10,
          startIndex = 0,
        )
        _uiState.update {
          it.copy(
            searchResults = searchResult,
          )
        }
      } catch (e: Exception) {
        // TODO: 共通のエラーハンドリングを表示
        println("あああ: $e")
      }
    }
  }
}
