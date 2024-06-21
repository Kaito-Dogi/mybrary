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

@HiltViewModel
internal class MyBookListViewModel @Inject constructor(
  private val myBookRepository: MyBookRepository,
) : ViewModel() {
  private val _uiState = MutableStateFlow(MyBookListUiState.InitialValue)
  val uiState = _uiState.asStateFlow()

  fun init() {
    viewModelScope.launch {
      try {
        val myBookList = myBookRepository.getMyBookList()
        _uiState.update { it.copy(myBookList = myBookList) }
      } catch (e: Exception) {
        // TODO: デバッグ用のログを実装する
        println("あああ: ${e.message}")
      }
    }
  }
}
