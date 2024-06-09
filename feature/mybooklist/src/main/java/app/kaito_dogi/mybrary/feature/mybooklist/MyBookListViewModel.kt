package app.kaito_dogi.mybrary.feature.mybooklist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.kaito_dogi.mybrary.core.domain.repository.MyBookRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

private const val NUMBER_OF_COLUMNS = 3

@HiltViewModel
internal class MyBookListViewModel @Inject constructor(
  private val myBookRepository: MyBookRepository,
) : ViewModel() {
  private val _uiState = MutableStateFlow<MyBookListUiState>(
    MyBookListUiState.Loading(
      numberOfColumns = NUMBER_OF_COLUMNS,
    ),
  )
  val uiState = _uiState.asStateFlow()

  fun init() {
    viewModelScope.launch {
      try {
        val myBooks = myBookRepository.getMyBooks()
        _uiState.update {
          MyBookListUiState.Success(
            numberOfColumns = it.numberOfColumns,
            myBookList = myBooks,
          )
        }
      } catch (e: Exception) {
        // TODO: デバッグ用のログを実装する
        println("あああ: ${e.message}")
      }
    }
  }
}
