package app.kaito_dogi.mybrary.feature.mybooklist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.kaito_dogi.mybrary.core.common.coroutines.LaunchSafe
import app.kaito_dogi.mybrary.core.domain.repository.MyBookRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

@HiltViewModel
internal class MyBookListViewModel @Inject constructor(
  private val myBookRepository: MyBookRepository,
  launchSafe: LaunchSafe,
) : ViewModel(), LaunchSafe by launchSafe {
  private val _uiState = MutableStateFlow(MyBookListUiState.InitialValue)
  val uiState = _uiState.asStateFlow()

  fun onInit() {
    viewModelScope.launchSafe {
      val myBookList = myBookRepository.getMyBookList()
      _uiState.update { it.copy(myBookList = myBookList) }
    }
  }
}
